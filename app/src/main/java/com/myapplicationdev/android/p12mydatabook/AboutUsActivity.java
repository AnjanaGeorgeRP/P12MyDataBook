package com.myapplicationdev.android.p12mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {

    ActionBar ab;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ab = getSupportActionBar();
        ab.setTitle("About Us");
        ab.setDisplayHomeAsUpEnabled(true);
        iv = (ImageView) findViewById(R.id.ivPic);
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        //Picasso.with(this).load(imageUrl).into(iv);
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(iv);
    }
}
