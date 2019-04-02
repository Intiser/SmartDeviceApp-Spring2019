package com.example.teacher.playstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.teacher.playstore.Main2Activity;
import com.example.teacher.playstore.MainActivity;
import com.example.teacher.playstore.R;
import com.example.teacher.playstore.model.Application;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    ArrayList<Application> dataset = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(ArrayList<Application> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_app_list, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Application application = dataset.get(i);
        holder.imageView.setImageResource(application.getProfileImage());
        holder.titleText.setText(application.getName());
        holder.developerNameText.setText(application.getDeveloper().getName());
        holder.ratingText.setText(application.getRating() + "");
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main2Activity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        RelativeLayout layout;
        ImageView imageView;
        TextView titleText;
        TextView developerNameText;
        TextView ratingText;

        public Holder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imageView = itemView.findViewById(R.id.imageview_app);
            titleText = itemView.findViewById(R.id.textview_app_name);
            developerNameText = itemView.findViewById(R.id.textview_app_developer_name);
            ratingText = itemView.findViewById(R.id.textview_app_rating);
        }
    }

}
