package com.portfolio.sameh.portfolio;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sameh on 6/6/2015.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>  {

    private ArrayList<CardModel> mDataset;

     private IMyViewHolderClicks clickListener;

    static Context ctx;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView description;
        LinearLayout image;
        public ViewHolder(View v) {
            super(v);
            description = (TextView) v.findViewById(R.id.info_text);
            image = (LinearLayout) v.findViewById(R.id.app_image);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v,getAdapterPosition());
        }

    }



    public RecycleAdapter(ArrayList<CardModel> myDataset,Context context) {
        ctx = context;
        mDataset = myDataset;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.description.setText(mDataset.get(position).getDescription());
        holder.image.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING);
        String[]colors = ctx.getResources().getStringArray(R.array.card_color);
        holder.image.setBackgroundColor(Color.parseColor(colors[position]));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setOnItemClickListener(final IMyViewHolderClicks listener){
        this.clickListener = listener;

    }
}
