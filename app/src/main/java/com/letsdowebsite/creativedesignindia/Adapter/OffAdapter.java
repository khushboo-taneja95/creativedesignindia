package com.letsdowebsite.creativedesignindia.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.creativedesignindia.Arraylist;
import com.letsdowebsite.creativedesignindia.CDIDash;
import com.letsdowebsite.creativedesignindia.R;

import java.util.ArrayList;


public class OffAdapter extends RecyclerView.Adapter<OffAdapter.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
          //  this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {
                        Intent intent = new Intent( context, CDIDash.class );
                        context.startActivity( intent );

                }

                }
            });
        }
    }

    public OffAdapter(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public OffAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productt, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        OffAdapter.MyViewHolder myViewHolder = new OffAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final OffAdapter.MyViewHolder holder, final int listPosition) {

     //   TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

     //   textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

