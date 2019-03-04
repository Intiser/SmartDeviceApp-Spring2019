package com.example.teacher.listviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teacher.listviewexample.R;
import com.example.teacher.listviewexample.model.Post;

import java.util.List;



public class MyAdapter extends ArrayAdapter<Post> {


    LayoutInflater inflater;
    List<Post> data;

    public MyAdapter( Context context, int resource,  List<Post> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        data = objects;

    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view  =  inflater.inflate(R.layout.item_list, parent, false);
        ImageView imageView =  view.findViewById(R.id.imageview);
        Post post = data.get(position);
        imageView.setImageResource(post.getImageRes());
        TextView textViewTitle = view.findViewById(R.id.textview_title);
        TextView textViewDescription = view.findViewById(R.id.textview_description);
        textViewTitle.setText(post.getTitle());
        textViewDescription.setText(post.getDescription());
        return view;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
