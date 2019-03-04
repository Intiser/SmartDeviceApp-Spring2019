package com.example.teacher.playstore.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.teacher.playstore.R;
import com.example.teacher.playstore.model.Application;

import java.util.ArrayList;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.Holder> {


    LayoutInflater inflater;
    Context context;
    ArrayList<Application> datalist = new ArrayList<>();
    int selectedPosition = 0;

    public AppListAdapter(Context context, ArrayList<Application> datalist) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_app_list, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder viewHolder, final int i) {
        Application application = datalist.get(i);
        viewHolder.imageView.setImageResource(application.getImageRes());
        viewHolder.titleTextView.setText(application.getName());
        viewHolder.sizeTextView.setText(application.getSize());
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = i;
                notifyDataSetChanged();
            }
        });
        if(selectedPosition == i){
            viewHolder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
        }
        else{
            viewHolder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleTextView;
        TextView sizeTextView;
        RelativeLayout layout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imageView =  itemView.findViewById(R.id.imageview_app);
            titleTextView = itemView.findViewById(R.id.textview_app_name);
            sizeTextView = itemView.findViewById(R.id.textview_app_size);
        }
    }
}
