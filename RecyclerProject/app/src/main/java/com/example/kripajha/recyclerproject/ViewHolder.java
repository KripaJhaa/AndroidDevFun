package com.example.kripajha.recyclerproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

// ViewHolder is type of holder used by recycler view to bind the items to its layout
public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    ViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.itemName);
    }
}
