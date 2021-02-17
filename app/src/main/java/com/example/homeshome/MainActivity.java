package com.example.homeshome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Button btnHomeList, btnMaps, btnExit;
    ImageView imgDash;
    public static final String urlGambar ="http://perumahanpekanbaru.com/wp-content/uploads/2019/08/Perumahan-Symphony-Sudirman-Pekanbaru-683x400.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHomeList = (Button)findViewById(R.id.btnListRumah);
        btnMaps = (Button)findViewById(R.id.btnPeta);
        btnExit = (Button)findViewById(R.id.btnExit);

        imgDash = (ImageView)findViewById(R.id.imageDashBoard);
        Glide.with(MainActivity.this)
                .load(urlGambar)
                .into(imgDash);

        btnHomeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeSList.class);
                startActivity(intent);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeMaps.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}