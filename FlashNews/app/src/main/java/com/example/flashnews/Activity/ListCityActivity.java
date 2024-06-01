package com.example.flashnews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flashnews.NewsActivity;
import com.example.flashnews.R;


public class ListCityActivity extends AppCompatActivity {

    ImageView iv_us, iv_id, iv_in, iv_jp, iv_jr, iv_ig, iv_pr, iv_br, iv_rs, iv_me, iv_kn, iv_it, iv_kr, iv_au, iv_sg;

    TextView home, country, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_city);

        iv_us = findViewById(R.id.IV_us);
        iv_id = findViewById(R.id.IV_id);
        iv_in = findViewById(R.id.IV_in);
        iv_jp = findViewById(R.id.IV_jp);
        iv_jr = findViewById(R.id.IV_jr);
        iv_ig = findViewById(R.id.IV_ig);
        iv_pr = findViewById(R.id.IV_pr);
        iv_br = findViewById(R.id.IV_br);
        iv_rs = findViewById(R.id.IV_rs);
        iv_me = findViewById(R.id.IV_me);
        iv_kn = findViewById(R.id.IV_kn);
        iv_it = findViewById(R.id.IV_it);
        iv_kr = findViewById(R.id.IV_kr);
        iv_au = findViewById(R.id.IV_au);
        iv_sg = findViewById(R.id.IV_sg);

        iv_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "usFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "idFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "inFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_jp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "jpFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_jr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "jrFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "igFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "prFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "brFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "rsFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "meFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_kn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "knFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "itFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "krFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "auFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });
        iv_sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCityActivity.this, NewsActivity.class);
                intent.putExtra("fragmentToLoad", "sgFragment");
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
            }
        });

    }
}

