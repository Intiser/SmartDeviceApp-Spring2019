package com.ahsan.intiser.daoexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Intiser on 11/30/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {

    Context context;
    ArrayList<Writer>allItems;
    LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<Writer> allItems) {
        this.context = context;
        this.allItems = allItems;
        inflater = LayoutInflater.from(context);
    }

    public void setAllItems(ArrayList<Writer> allItems) {
        this.allItems = allItems;
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.textView.setText(allItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
