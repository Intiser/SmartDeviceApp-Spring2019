package com.kitegames.firstoneasynctask;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by developerios on 12/21/17.
 */

public class HttpGetPost extends Activity {
    private static String TAG = HttpGetPost.class.getName();

    private final static int MY_PERMISSIONS_REQUEST_INTERNET = 100;

    OkHttpClient client;
    MediaType json;
    GetTask get;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        findViewById(R.id.makeRequestButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new GetTask().execute("make request");
//            }
//        });

        client = new OkHttpClient();
        json = MediaType.parse("application/json; charset=utf-8");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPermission();
            }
        });


    }



    void callPermission(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_INTERNET);

            }
        } else {
            get = new GetTask();
            get.execute();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "onRequestPermissionsResult: yes "  );

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }



    public class GetTask extends AsyncTask<String,String,String>{

        private Exception exception;

        protected String doInBackground(String...url) {

            try {
                String getResponse = get("https://pixabay.com/api/?key=7465948-a3a3b94191491194b5f1d08b8&q=yellow+flowers&image_type=photo&pretty=true&orientation=vertical&per_page=100");
                Log.d(TAG, "doInBackground: " + getResponse);
                return  getResponse;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String s) {
            Log.d(" " , "onPostExecute: " + s);
        }

        protected String get(String url)throws IOException{
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }




}
