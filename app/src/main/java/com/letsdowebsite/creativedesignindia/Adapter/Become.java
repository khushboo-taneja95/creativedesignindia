package com.letsdowebsite.creativedesignindia.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.letsdowebsite.creativedesignindia.Arraylist;
import com.letsdowebsite.creativedesignindia.MembershipUSA;
import com.letsdowebsite.creativedesignindia.Partner;
import com.letsdowebsite.creativedesignindia.R;

import java.util.ArrayList;


public class Become extends RecyclerView.Adapter<Become.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        pl.droidsonroids.gif.GifImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
           // this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            final Context context = itemView.getContext();
            this.imageViewIcon = (pl.droidsonroids.gif.GifImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {
                        Intent intent = new Intent( context, Partner.class );
                        context.startActivity( intent );

                    } if (getPosition()==1)
                {
                    Intent intent = new Intent( context, MembershipUSA.class );
                    context.startActivity( intent );

                }
                }
            });
        }
    }

    public Become(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public Become.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.become, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        Become.MyViewHolder myViewHolder = new Become.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final Become.MyViewHolder holder, final int listPosition) {

     //   TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        pl.droidsonroids.gif.GifImageView imageView = holder.imageViewIcon;

     //   textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

