package com.example.homeshome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeSList extends AppCompatActivity {

    List<Home> homeList;
    RecyclerView recyclerView;

    private static final String URL = "https://berlinpark.000webhostapp.com/showdata.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_s_list);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext())
        );

        homeList = new ArrayList<>();

        hasildata();
    }

    private void hasildata() {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    JSONArray array = jObj.getJSONArray("RUMAH");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject hm = array.getJSONObject(i);
                        homeList.add(new Home(
                                hm.getInt("id"),
                                hm.getString("jpembayaran"),
                                hm.getDouble("harga"),
                                hm.getString("alamat"),
                                hm.getInt("ltanah"),
                                hm.getInt("lbangunan"),
                                hm.getInt("bkamar"),
                                hm.getInt("bgarasi"),
                                hm.getInt("bkmandi"),
                                hm.getString("ket"),
                                hm.getString("jrumah"),
                                hm.getString("gambar")
                        ));
                    }
                    HomeAdapter adapter = new HomeAdapter(HomeSList.this, homeList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse : "+ error.getMessage());
                Toast.makeText(HomeSList.this,"Error : " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        Volley.newRequestQueue(this).add(stringRequest);
    }
}