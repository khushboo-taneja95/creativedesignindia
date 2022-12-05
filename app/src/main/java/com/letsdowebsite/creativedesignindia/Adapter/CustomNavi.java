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
import com.letsdowebsite.creativedesignindia.ArrivalNavi;
import com.letsdowebsite.creativedesignindia.FreeNavi;
import com.letsdowebsite.creativedesignindia.MensNavi;
import com.letsdowebsite.creativedesignindia.R;
import com.letsdowebsite.creativedesignindia.WomensNavi;
import com.letsdowebsite.creativedesignindia.kidsssNavi;

import java.util.ArrayList;


public class CustomNavi extends RecyclerView.Adapter<CustomNavi.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
         //   this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {
                        Intent intent = new Intent( context, FreeNavi.class );
                        context.startActivity( intent );
                    } if (getPosition()==1) {
                      Intent intent = new Intent( context, ArrivalNavi.class );
                      context.startActivity( intent );
                  } if (getPosition()==2) {
                        Intent intent = new Intent( context, MensNavi.class );
                        context.startActivity( intent );
                    }
                    if (getPosition()==3)
                    {
                        Intent intent = new Intent( context, WomensNavi.class );
                        context.startActivity( intent );
                    } if (getPosition()==4)
                    {
                        Intent intent = new Intent( context, kidsssNavi.class );
                        context.startActivity( intent );
                    }
                }
            });
        }
    }

    public CustomNavi(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productnavi, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

     //   TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

      //  textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

