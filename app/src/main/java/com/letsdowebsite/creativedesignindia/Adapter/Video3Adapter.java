package com.letsdowebsite.creativedesignindia.Adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


import com.letsdowebsite.creativedesignindia.R;
import com.letsdowebsite.creativedesignindia.YouTubeVideos;

import java.util.List;

public class Video3Adapter extends RecyclerView.Adapter<Video3Adapter.VideoViewHolder> {

    List<YouTubeVideos> youtubeVideoList;

    public Video3Adapter() {
    }

    public Video3Adapter(List<YouTubeVideos> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @Override
    public Video3Adapter.VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.video3, parent, false);

        return new Video3Adapter.VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Video3Adapter.VideoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );

    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {

            } );
        }
    }
}
