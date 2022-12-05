package com.letsdowebsite.creativedesignindia;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.letsdowebsite.creativedesignindia.Fragment.MenuFragment;
import com.letsdowebsite.creativedesignindia.Fragment.VideosFragment;


public class INDIA extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tvTitle;
    Fragment fragment = null;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    public static TextView tv;
    private static long back_pressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        tvTitle = (TextView) findViewById( R.id.tvTitle );
        fragment = new HomeNavi();
        fragmentReplace(fragment);


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();
        BottomNavigationView navigation = (BottomNavigationView) findViewById( R.id.bottom_navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById( R.id.bottom_navigation );


        bottomNavigationView.setOnNavigationItemSelectedListener
                ( new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        int id = item.getItemId();

                        if (id == R.id.navigation_home) {
                            fragment = new HomeNavi();
                            fragmentReplace(fragment);
                            tvTitle.setText( "Home" );

                        }
                        else if (id == R.id.navigation_menu) {
                            Intent i = new Intent( INDIA.this, CartNavi.class );
                            startActivity( i );

                        } else if (id == R.id.navigation_membership) {
                            Intent i = new Intent( INDIA.this, MembershipINDIA.class );
                            startActivity( i );

                         //   Intent i = new Intent( INDIA.this, PayUActivity.class );
                       //   startActivity( i );
                        }

                        return false;

                    }
                } );

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        fragment = new HomeNavi();
        fragmentReplace( fragment );
        navigationView.setItemIconTintList( null );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText( this, "Press once BACK again to exit!", Toast.LENGTH_SHORT ).show();
            }
            back_pressed = System.currentTimeMillis();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_navi, menu);

        return true;
    }

    @Override
    protected void onResume() {
        invalidateOptionsMenu();
        super.onResume();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent sendInt = new Intent(Intent.ACTION_SEND);
            sendInt.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            sendInt.putExtra(Intent.EXTRA_TEXT, "Creative Design India\n\""+getString(R.string.app_name)+"\" \nhttps://play.google.com/store/apps/details?id=");
            sendInt.setType("text/plain");
            startActivity(Intent.createChooser(sendInt, "Share"));
            return true;
        }
        return super.onOptionsItemSelected( item );
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeNavi();
            fragmentReplace(fragment);
            tvTitle.setText( "Home" );

        } else if (id == R.id.nav_menu) {
            fragment = new MenuFragment();
            fragmentReplace( fragment );
            tvTitle.setText( "Menu" );

        } else if (id == R.id.nav_supplier) {
            Intent i = new Intent( INDIA.this, Supplier.class );
            startActivity( i );


        } else if (id == R.id.nav_raw) {
            Intent i = new Intent( INDIA.this, RawMaterial.class );
            startActivity( i );

        } else if (id == R.id.nav_membership) {
      Intent i = new Intent( INDIA.this, MembershipINDIA.class );
        startActivity( i );

        } else if (id == R.id.nav_login) {
            Intent i = new Intent( INDIA.this, LoginNavi.class );
            startActivity( i );

        } else if (id == R.id.nav_help) {
            tvTitle.setText( "Help" );
            fragment = new VideosFragment();
            fragmentReplace( fragment );


        } else if (id == R.id.nav_men) {
            Intent i = new Intent( INDIA.this, MenNavi.class );
            startActivity( i );

        }
        else if (id == R.id.nav_women) {
            Intent i = new Intent( INDIA.this, WomenNavi.class );
            startActivity( i );

        }
        else if (id == R.id.nav_kid) {
            Intent i = new Intent( INDIA.this, KidNavi.class );
            startActivity( i );

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void fragmentReplace(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }
}
