package com.letsdowebsite.creativedesignindia;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.letsdowebsite.creativedesignindia.Adapter.CustNa;
import com.letsdowebsite.creativedesignindia.Adapter.CustNavi;
import com.letsdowebsite.creativedesignindia.Adapter.CustomNavi;
import com.letsdowebsite.creativedesignindia.Adapter.OfferAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Dell on 5/24/2018.
 */

public class HomeNavi extends Fragment {
    private CustomNavi horizontalAdapter;
    private CustNavi horizontal;
    private OfferAdapter hori;
    private CustNa hor;


    private ArrayList<Arraylist> horizontalList;


    private RecyclerView horizontal_recycler_view;
    private ViewPager mPager;
    View view;

    Context context;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.sl, R.drawable.salide , R.drawable.slideq};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    // getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.home_navi, null);
        context = this.getActivity();
        context = this.getActivity();
        init();

        return view;

    }

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(getActivity(), XMENArray));
      // indicator = view.findViewById(R.id.indicator);
        // indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 2000);

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyDataNavi.nameArrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyDataNavi.nameArrey[i],
                    MyDataNavi.drawableArrey[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview);
            horizontalAdapter = new CustomNavi(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontalAdapter);
        }



        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyDataNavi.nameArray.length; i++) {
            horizontalList.add(new Arraylist(
                    MyDataNavi.nameArray[i],
                    MyDataNavi.drawableArray[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview1);
            horizontal = new CustNavi(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontal);

        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyDataNavi.Arrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyDataNavi.Arrey[i],
                    MyDataNavi.draw[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview3);
            hor = new CustNa(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(hor);

        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyDataNavi.name.length; i++) {
            horizontalList.add(new Arraylist(
                    MyDataNavi.name[i],
                    MyDataNavi.drawable[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview2);
            hori = new OfferAdapter(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(hori);

        }
    }


}







