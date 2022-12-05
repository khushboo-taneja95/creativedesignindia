package com.letsdowebsite.creativedesignindia.Adapter;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.creativedesignindia.Arrival;
import com.letsdowebsite.creativedesignindia.FreeDesign;
import com.letsdowebsite.creativedesignindia.Kid;
import com.letsdowebsite.creativedesignindia.Men;
import com.letsdowebsite.creativedesignindia.MyListData;
import com.letsdowebsite.creativedesignindia.Offer1;
import com.letsdowebsite.creativedesignindia.Permium;
import com.letsdowebsite.creativedesignindia.R;
import com.letsdowebsite.creativedesignindia.Women;

import java.security.AccessController;


public class OffersAdapter  extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {
    private MyListData[] listdata;
    Context context;
    View view;



    // RecyclerView recyclerView;
    public OffersAdapter(MyListData[] listdata, Context context) {

        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View listItem = layoutInflater.inflate( R.layout.special, parent, false );
        ViewHolder viewHolder = new ViewHolder( listItem );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.textView.setText( listdata[position].getDescription() );
        holder.imageView.setImageResource( listdata[position].getImgId() );

        holder.textView.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        } );

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super( itemView );
            itemView.setOnClickListener( this );

            this.textView = (TextView) itemView.findViewById( R.id.textView );
            this.imageView = (ImageView) itemView.findViewById( R.id.imageView );
            imageView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v ) {
                    int pos = getAdapterPosition();
                    AccessController view;
                    if (pos == 0)
                        context.startActivity( new Intent( context, FreeDesign.class ) );
                    if (pos == 1)
                        context. startActivity(new Intent(context, Arrival.class));
                    if (pos == 2)
                        context. startActivity(new Intent(context, Men.class));
                    if (pos == 3)
                        context. startActivity(new Intent(context, Women.class));
                    if (pos == 4)
                        context. startActivity(new Intent(context, Kid.class));
                    if (pos == 5)
                        context. startActivity(new Intent(context, Permium.class));
                  if (pos == 6)
                     context. startActivity(new Intent(context, Offer1.class));


                }

            });
            return ;
        }

        @Override
        public void onClick(View v) {

        }
    }


}

