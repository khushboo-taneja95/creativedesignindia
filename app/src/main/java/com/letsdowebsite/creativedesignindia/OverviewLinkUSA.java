package com.letsdowebsite.creativedesignindia;

import android.content.Intent;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.creativedesignindia.Adapter.Video3Adapter;

import java.util.Vector;

public class OverviewLinkUSA extends AppCompatActivity {

    private ImageView back, lo;
    SwipeRefreshLayout swipe;
    TextView next , pre;
    ImageView img;

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.overlinkusa );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youtubeVideos.add( new YouTubeVideos( "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WadR9saJ8p0\" frameborder=\"0\" allowfullscreen></iframe>" ) );


        Video3Adapter videoAdapter = new Video3Adapter( youtubeVideos );

        recyclerView.setAdapter( videoAdapter );


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(OverviewLinkUSA.this, USA.class);
                    startActivity(intent);
                }

        });



    }
}

