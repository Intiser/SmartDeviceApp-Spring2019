package com.example.teacher.constraintlayout;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.teacher.constraintlayout.model.Video;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity  {

    ImageView imageView;
    RelativeLayout layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout1);
        textView = findViewById(R.id.textview);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("CLICKED !!!!!!!!!");
            }
        });
    }


}
