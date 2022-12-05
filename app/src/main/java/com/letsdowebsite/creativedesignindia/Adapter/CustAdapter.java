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
import com.letsdowebsite.creativedesignindia.Arrival;
import com.letsdowebsite.creativedesignindia.Kid;
import com.letsdowebsite.creativedesignindia.Men;
import com.letsdowebsite.creativedesignindia.R;
import com.letsdowebsite.creativedesignindia.Women;

import java.util.ArrayList;


public class CustAdapter extends RecyclerView.Adapter<CustAdapter.MyViewHolder> {

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
                        Intent intent = new Intent( context, Arrival.class );
                        context.startActivity( intent );

                    } if (getPosition()==1)
                {
                    Intent intent = new Intent( context, Men.class );
                    context.startActivity( intent );

                } if (getPosition()==2)
                {
                    Intent intent = new Intent( context, Women.class );
                    context.startActivity( intent );

                } if (getPosition()==3)
                {
                    Intent intent = new Intent( context, Kid.class );
                    context.startActivity( intent );

                }

                }
            });
        }
    }

    public CustAdapter(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public CustAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prod, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        CustAdapter.MyViewHolder myViewHolder = new CustAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CustAdapter.MyViewHolder holder, final int listPosition) {

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

