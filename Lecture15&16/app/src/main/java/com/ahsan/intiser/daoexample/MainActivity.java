package com.ahsan.intiser.daoexample;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    EditText yearText;
    EditText booksText;

    Button submitButton;
    Button refreshButton;

    RecyclerView recyclerView;
    ListAdapter adapter;

    final AppDataBaseManager appDataBaseManager = DataBaseManager.getSharedInstance().getAppDataBaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name_text);
        yearText = findViewById(R.id.year_text);
        booksText = findViewById(R.id.book_text);
        submitButton = findViewById(R.id.button);
        refreshButton = findViewById(R.id.refresh_button);
        recyclerView = findViewById(R.id.recyclerview);
        initButton();
        initRecyclerView();
    }

    void initButton(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeInputAndProcess();
            }
        });
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
    }

    void initRecyclerView(){

        adapter = new ListAdapter(this, new ArrayList<Writer>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        updateData();

    }

    void updateData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                 Writer[] writers = appDataBaseManager.daoWriter().getAllWriter();
                 ArrayList<Writer> allWriters = new ArrayList<Writer>();
                 for(int i=0;i<writers.length;i++){
                     allWriters.add(writers[i]);
                 }
                 showDataToListView(allWriters);

            }
        }).start();
    }

    void showDataToListView(final ArrayList<Writer> allWriters){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                adapter.setAllItems(allWriters);
            }
        });
    }

    void takeInputAndProcess(){
        String writer_uid = UUID.randomUUID().toString();
        String writer_name = nameText.getText().toString();
        String writer_birth =    yearText.getText().toString();
        String writer_books = booksText.getText().toString();

        nameText.setText("");
        yearText.setText("");
        booksText.setText("");

        Writer writer = new Writer();
        writer.setUniqueId(writer_uid);
        writer.setName(writer_name);
        writer.setBirthYear(writer_birth);
        writer.setBooks(writer_books);

        callDataBaseInsertMethod(writer);
    }

    void callDataBaseInsertMethod(final Writer writer){
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDataBaseManager.daoWriter().insertWriter(writer);
                int cnt = appDataBaseManager.daoWriter().count();
                Log.d("TAG", "run: " + cnt);
            }
        }).start();
    }

}


/**
 *   add room persistence to the gradle
 *
 *
 *
 **/