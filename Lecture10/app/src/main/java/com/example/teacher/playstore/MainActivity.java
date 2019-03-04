package com.example.teacher.playstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.example.teacher.playstore.adapter.AppListAdapter;
import com.example.teacher.playstore.model.Application;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Application> arrayList = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSampleData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AppListAdapter appListAdapter = new AppListAdapter(this, arrayList);
        recyclerView.setAdapter(appListAdapter);
    }

    void createSampleData() {
        Application app1 = new Application("Instagram", R.drawable.app1, "21MB");
        Application app2 = new Application("facebook", R.drawable.app2, "15MB");
        Application app3 = new Application("Messanger", R.drawable.app1, "165MB");
        Application app4 = new Application("Hangouts", R.drawable.app2, "210MB");
        Application app5 = new Application("Youtube", R.drawable.app1, "1.21MB");
        Application app6 = new Application("Gmail", R.drawable.app2, "210MB");
        Application app7 = new Application("WhatsApp", R.drawable.app1, "11MB");
        Application app8 = new Application("LinkedIn", R.drawable.app2, "1MB");
        Application app9 = new Application("SnapChat", R.drawable.app1, "0MB");
        arrayList.add(app1);
        arrayList.add(app2);
        arrayList.add(app3);
        arrayList.add(app4);
        arrayList.add(app5);
        arrayList.add(app6);
        arrayList.add(app7);
        arrayList.add(app8);
        arrayList.add(app9);
        arrayList.add(app1);
        arrayList.add(app2);
        arrayList.add(app3);
    }
}
