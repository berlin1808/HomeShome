package com.example.homeshome;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final float INITIAL_ZOOM = 13f;
    private ArrayList<LatLng> latLngs = new ArrayList<>();
    private static final String TAG = HomeMaps.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pnp = new LatLng(-0.9135039, 100.4662569 );
        mMap.addMarker(new MarkerOptions().position(pnp).title("Marker in PNP"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pnp, INITIAL_ZOOM));

        enableDynamicMarker();
    }

    private void enableDynamicMarker() {
        String URL = "https://berlinpark.000webhostapp.com/addmarker.php/";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("respon", "hasil : " + response);

                        try {
                            JSONObject jObj = new JSONObject(response);
                            JSONArray result = jObj.getJSONArray("LOCATION");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject jsonObject1 = result.getJSONObject(i);
                                String lat_i = jsonObject1.getString("latitude");
                                String long_i = jsonObject1.getString("longitude");
                                String locationName = jsonObject1.getString("locationName");
                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(lat_i), Double.parseDouble(long_i)))
                                        .title(Double.valueOf(lat_i).toString() + "," + Double.valueOf(long_i).toString())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                        .snippet(locationName));
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.929507, 100.349957), 11.0f));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("respon", "error : "+error);
                error.printStackTrace();
                Toast.makeText(HomeMaps.this,"Error : " + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
}