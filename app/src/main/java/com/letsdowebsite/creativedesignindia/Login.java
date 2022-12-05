package com.letsdowebsite.creativedesignindia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class Login   extends AppCompatActivity {
    private WebView mWebview;

    ImageView home , back;
    SwipeRefreshLayout swipe;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    android.support.design.widget.BottomNavigationView BottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login );



        home = (ImageView) findViewById( R.id.home );
        back = (ImageView) findViewById( R.id.back );
        back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Login.this, Splash.class );
                startActivity( intent );
            }
        } );



        swipe = (SwipeRefreshLayout) findViewById( R.id.swipe );
        swipe.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        } );

        WebAction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.brower, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!mWebview.canGoBack()) {
            menu.getItem(1).setEnabled(false);
        } else {
            menu.getItem(1).setEnabled(true);
        }

        if (!mWebview.canGoForward()) {
            menu.getItem(2).setEnabled(false);
        } else {
            menu.getItem(2).setEnabled(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                mWebview.loadUrl( "https://creativedesignindia.in/login" );
                break;
            case R.id.action_back:
                if (mWebview.canGoBack()) {
                    mWebview.goBack();
                }
                break;
            case R.id.action_forward:
                if (mWebview.canGoForward()) {
                    mWebview.goForward();
                }
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    public void WebAction() {

        mWebview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);

        mWebview.loadUrl( "https://creativedesignindia.in/login" );
        swipe.setRefreshing( true );

        mWebview.setWebViewClient( new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mWebview.loadUrl( "file:///android_asset/error.html" );

            }



            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                invalidateOptionsMenu();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebview.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                invalidateOptionsMenu();
            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing( false );
                initInstances();
                super.onPageFinished(view, url);
                invalidateOptionsMenu();

            }


            private void initInstances() {

                com.github.clans.fab.FloatingActionButton menu1,menu2  ;


                menu1 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.subFloatingMenu1) ;
                menu2 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.subFloatingMenu2) ;



                menu1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData( Uri.parse("tel:87440 99657"));
                        startActivity(intent);
                    }
                });

                menu2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent( Login.this, Download.class );
                        startActivity( i );
                    }
                });



                drawerLayout = (DrawerLayout) findViewById( R.id.drawerLayout );
                drawerToggle = new ActionBarDrawerToggle(
                        Login.this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
                drawerLayout.setDrawerListener( drawerToggle );

                BottomNavigationView = (android.support.design.widget.BottomNavigationView) findViewById( R.id.bottom_navigation );
                BottomNavigationView.setOnNavigationItemSelectedListener(
                        new BottomNavigationView.OnNavigationItemSelectedListener() {
                            @Override

                            public boolean onNavigationItemSelected(MenuItem menuItem) {
                                int id = menuItem.getItemId();
                                switch (id) {
                                    case R.id.nav_membership:
                                        startActivity( new Intent( Login.this, Membership.class ) );
                                        break;
                                    case R.id.nav_supplier:
                                        startActivity( new Intent( Login.this, Supplier.class ) );
                                        break;
                                    case R.id.nav_login:
                                        startActivity( new Intent( Login.this, Login.class ) );
                                        break;

                                }
                                return false;
                            }
                        } );
            }
        } );

        mWebview.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }


        });
    }


}




