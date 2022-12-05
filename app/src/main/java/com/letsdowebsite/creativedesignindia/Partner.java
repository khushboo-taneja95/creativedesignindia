package com.letsdowebsite.creativedesignindia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;


public class Partner extends AppCompatActivity {

    private WebView mWebview;
    ImageView lo, back;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.partner );
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
        mWebview.loadUrl( "https://cdifootwearsolution.com/vendor-registration" );
        swipe.setRefreshing( true );
        mWebview.setWebViewClient( new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebview.loadUrl( "file:///android_asset/error.html" );
            }
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Partner.this);
                builder.setMessage(R.string.notification_error_ssl_cert_invalid);
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing( false );

                mWebview.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('header-grid')[0].style.display='none'; " +
                        "})()");

                mWebview.loadUrl("javascript:(function() { " +
                        "var bread = document.getElementsByClassName('breadcrumb-box')[0].style.display='none'; " +
                        "})()");
            }
        });

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


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mWebview.canGoBack()) {
                    mWebview.goBack();
                } else {
                    Intent intent = new Intent(Partner.this, USA.class);
                    startActivity(intent);
                }
            }
        });
    }


    public void onBackPressed() {
        if (mWebview.canGoBack()) {
            mWebview.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }

}
