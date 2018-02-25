package com.example.navendu.displayimages;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Enlarge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);


        Intent intent = getIntent();


        String id = intent.getStringExtra("id");

        ImageView j=findViewById(R.id.i1);

        Picasso.with(this)
                .load(id)
                .resize(400,400)
                .into(j);


    }

}
