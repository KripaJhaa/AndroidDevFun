package com.example.kripajha.recyclerproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    String DataSet[];

    MyAdapter(String dataSet[]) {
        this.DataSet = dataSet;
    }


    //for attaching View to the recycler view [View Holder]
    // maintaining Separations of concern
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(DataSet[position]);
    }

    @Override
    public int getItemCount() {
        return DataSet.length;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.itemlay;
    }
}
