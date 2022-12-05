package com.letsdowebsite.creativedesignindia;

import android.content.Intent;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewMore extends AppCompatActivity {

    private WebView mWebview;
    ImageView lo, back;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.specials );
        TextView marque = (TextView) this.findViewById(R.id.marque_scrolling_text);
        marque.setSelected(true);

        swipe = (SwipeRefreshLayout) findViewById( R.id.swipe );
        swipe.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        } );

        WebAction();
    }
    public void WebAction() {

        mWebview = (WebView) findViewById( R.id.webview );
        mWebview.getSettings().setJavaScriptEnabled( true );
        mWebview.getSettings().setAppCacheEnabled( true );
        mWebview.loadUrl( "https://cdifootwearsolution.com/new-products/" );
        swipe.setRefreshing( true );
        mWebview.setWebViewClient( new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mWebview.loadUrl( "file:///android_asset/error.html" );

            }




            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing( false );

                lo = (ImageView) findViewById( R.id.lo );
                lo.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction( Intent.ACTION_SEND );
                        sendIntent.putExtra( Intent.EXTRA_TEXT,
                                "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus" );
                        sendIntent.setType( "text/plain" );
                        startActivity( sendIntent );
                    }
                } );


                back = (ImageView) findViewById( R.id.back );
                back.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent( ViewMore.this, USA.class );
                        startActivity( intent );
                    }
                } );
            }
        } );
    }
}
