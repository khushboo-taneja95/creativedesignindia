package com.letsdowebsite.creativedesignindia.Adapter;


import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.creativedesignindia.MembershipLink;
import com.letsdowebsite.creativedesignindia.MyListData;
import com.letsdowebsite.creativedesignindia.OverviewLink;
import com.letsdowebsite.creativedesignindia.R;

import java.security.AccessController;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    private MyListData[] listdata;
    Context context;
    View view;



    // RecyclerView recyclerView;
    public VideosAdapter(MyListData[] listdata, Context context) {

        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View listItem = layoutInflater.inflate( R.layout.videos, parent, false );
        ViewHolder viewHolder = new ViewHolder( listItem );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.txtTitle1.setText( listdata[position].getDescription() );
        holder.imageView.setImageResource( listdata[position].getImgId() );

        holder.txtTitle1.setOnClickListener( new View.OnClickListener() {

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
        public TextView txtTitle1;

        public ViewHolder(View itemView) {
            super( itemView );
            itemView.setOnClickListener( this );

            this.txtTitle1 = (TextView) itemView.findViewById( R.id.txtTitle1 );
            this.imageView = (ImageView) itemView.findViewById( R.id.imageView );
            imageView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v ) {
                    int pos = getAdapterPosition();
                    AccessController view;
                if (pos == 0)
               context.startActivity( new Intent( context, OverviewLink.class ) );
          if (pos == 1)
             context. startActivity(new Intent(context, MembershipLink.class));


                }

            });
            return ;
        }

        @Override
        public void onClick(View v) {

        }
    }


}
