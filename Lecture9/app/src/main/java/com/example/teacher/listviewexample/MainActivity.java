package com.example.teacher.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.teacher.listviewexample.adapter.MyAdapter;
import com.example.teacher.listviewexample.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Post> data ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = findViewById(R.id.listview);
        createSampleData();
        MyAdapter adapter = new MyAdapter(this,R.layout.item_list, data);
        listView.setAdapter(adapter);
    }

    void createSampleData(){
        data = new ArrayList<>();
        Post post1 = new Post(R.drawable.pic1,"Jeetu", "Tiktok Ar Bhalo Lage Nah" );
        Post post2 = new Post(R.drawable.pic2, "Nazmul", "Haha Haha Ha Ha...... Kono Chele Friend Nai");
        Post post3 = new Post(R.drawable.pic1, "Arnob Bhai", "Njai Kalke Exam ase 4Tay chere Den");
        Post post4 = new Post(R.drawable.pic2, "Miraz", "Review Group e Apnader Rakha Jabena. Manush SHanti Moto Comment Korte Parena");
        data.add(post1);
        data.add(post2);
        data.add(post3);
        data.add(post4);
        Post post5 = new Post(R.drawable.pic1,"Jeetu", "Tiktok Ar Bhalo Lage Nah" );
        Post post6 = new Post(R.drawable.pic2, "Nazmul", "Haha Haha Ha Ha...... Kono Chele Friend Nai");
        Post post7 = new Post(R.drawable.pic1, "Arnob Bhai", "Njai Kalke Exam ase 4Tay chere Den");
        Post post8 = new Post(R.drawable.pic2, "Miraz", "Review Group e Apnader Rakha Jabena. Manush SHanti Moto Comment Korte Parena");
        data.add(post5);
        data.add(post6);
        data.add(post7);
        data.add(post8);


    }
}
