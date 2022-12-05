package com.letsdowebsite.creativedesignindia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
   ImageView imgicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu );

      //  GridView gridView=(GridView) findViewById( R.id.gridview );
       // gridView.setAdapter( (ListAdapter) new LinearLayoutManager( this ) );

        imgicon = (ImageView) findViewById( R.id.back );
        imgicon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu.this.finish();
            }
        });
    }
}
