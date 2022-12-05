package com.letsdowebsite.creativedesignindia.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.letsdowebsite.creativedesignindia.Adapter.MenuAdapter;
import com.letsdowebsite.creativedesignindia.ArrivalNavi;
import com.letsdowebsite.creativedesignindia.FreeNavi;
import com.letsdowebsite.creativedesignindia.MensNavi;
import com.letsdowebsite.creativedesignindia.R;
import com.letsdowebsite.creativedesignindia.TodayNavi;
import com.letsdowebsite.creativedesignindia.WomensNavi;
import com.letsdowebsite.creativedesignindia.kidsssNavi;


public class MenuFragment extends Fragment {
    private View view;
    static View.OnClickListener myOnClickListener;
    private GridView gridView;
    private Context mcontext;


    String[] web = {"FREE DESIGN","NEW ARRIVALS","MENS","WOMENS ","KIDS ","TODAY'S SPECIAL"};
    int[] imageId = {R.drawable.fre,  R.drawable.naw,  R.drawable.menss,
            R.drawable.womennnn,   R.drawable.kiddssa , R.drawable.todayy };

    private int[] Imageid;


    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_menu, viewGroup, false);
        gridView = (GridView)view.findViewById(R.id.gridview);

        gridView.setAdapter(new MenuAdapter(mcontext,web,imageId));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                //  pass intent
                if(position==0) {
                    Intent intent = new Intent( mcontext, FreeNavi.class);
                    startActivity( intent );
                }
                    else if(position==1) {
                    Intent intent = new Intent( mcontext, ArrivalNavi.class);
                    startActivity( intent );
                }
                 else if(position==2) {
                    Intent intent = new Intent( mcontext, MensNavi.class);
                    startActivity( intent );
                        }
                else if(position==3) {
                    Intent intent = new Intent( mcontext, WomensNavi.class);
                    startActivity( intent );
                }
                else if(position==4) {
                    Intent intent = new Intent( mcontext, kidsssNavi.class);
                    startActivity( intent );
                }
                else if(position==5) {
                    Intent intent = new Intent( mcontext, TodayNavi.class);
                    startActivity( intent );
                }
            }
        });

        return view;
    }

}




