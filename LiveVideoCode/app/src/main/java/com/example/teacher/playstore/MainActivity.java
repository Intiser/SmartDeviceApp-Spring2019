package com.example.teacher.playstore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.teacher.playstore.adapter.CustomAdapter;
import com.example.teacher.playstore.model.Application;
import com.example.teacher.playstore.model.Developer;
import com.example.teacher.playstore.model.Review;
import com.example.teacher.playstore.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Application> dataset = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSampleData();
        initRecyclerView();
    }

    void initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CustomAdapter adapter = new CustomAdapter(dataset, this);
        recyclerView.setAdapter(adapter);
    }

    void createSampleData() {
        // Application : name, developer, image resource, <review>
        // Developer : name, email, contract, address,
        // Review : Rating Comment
        Application app1 = new Application("Home Design Makeover", getDeveloper(), R.drawable.pic1, getSampleReviews());
        dataset.add(app1);
        Application app2 = new Application("Monopoly Bingo", getDeveloper(), R.drawable.pic2, getSampleReviews());
        dataset.add(app2);
        Application app3 = new Application("Home Design Makeover", getDeveloper(), R.drawable.pic3, getSampleReviews());
        dataset.add(app3);
        for (int i = 0; i < 10; i++) {
            dataset.add(app1);
            dataset.add(app2);
            dataset.add(app3);
        }

    }

    ArrayList<Review> getSampleReviews() {
        ArrayList<Review> arrayList = new ArrayList<>();

        User user = new User(getResources().getString(R.string.review1_person));
        Review review1 = new Review(user, 3.0, getResources().getString(R.string.review1_comment));
        arrayList.add(review1);

        User user1 = new User(getResources().getString(R.string.review2_person));
        Review review2 = new Review(user1, 2.0, getResources().getString(R.string.review2_comment));
        arrayList.add(review2);

        User user2 = new User(getResources().getString(R.string.review3_person));
        Review review3 = new Review(user2, 4.0, getResources().getString(R.string.review3_comment));
        arrayList.add(review3);

        arrayList.add(review1);
        arrayList.add(review2);
        arrayList.add(review3);

        return arrayList;
    }

    Developer getDeveloper() {
        return new Developer("Storm8 Studios", "storm@gmail.com", "+8801715896324", "Banani Road 14");
    }


    private String getStringR(int id) {
        return getResources().getString(id);
    }


}
