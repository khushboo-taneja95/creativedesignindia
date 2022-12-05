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


import com.letsdowebsite.creativedesignindia.Adapter.Become;
import com.letsdowebsite.creativedesignindia.Adapter.CustAdapter;
import com.letsdowebsite.creativedesignindia.Adapter.CustomAdapter;
import com.letsdowebsite.creativedesignindia.Adapter.OffAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



/**
 * Created by Dell on 5/24/2018.
 */

public class HomeFragment extends Fragment {
    private CustomAdapter horizontalAdapter;
    private CustAdapter horizontal;
    private OffAdapter hori;
    private ArrayList<Arraylist> horizontalList;
    private Become hor;

    private RecyclerView horizontal_recycler_view;
    private ViewPager mPager;
    View view;

    Context context;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.s, R.drawable.slide1 , R.drawable.sacdu};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        view = inflater.inflate(R.layout.activity_home, null);
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
     //  indicator.setViewPager(mPager);

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
        for (int i = 0; i < MyData.Arrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.Arrey[i],
                    MyData.draw[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recyler);
            hor = new Become(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(hor);


        }



        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i],
                    MyData.drawableArray[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview);
            horizontalAdapter = new CustomAdapter(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontalAdapter);

        }


            horizontalList = new ArrayList<Arraylist>();
            for (int i = 0; i < MyData.nameArrey.length; i++) {
                horizontalList.add(new Arraylist(
                        MyData.nameArrey[i],
                        MyData.drawableArrey[i]
                ));

                horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview1);
                horizontal = new CustAdapter(horizontalList);
                LinearLayoutManager horizontalLayoutManagaer
                        = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

                horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
                horizontal_recycler_view.setAdapter(horizontal);

            }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.name.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.name[i],
                    MyData.drawable[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview2);
            hori = new OffAdapter(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(hori);

        }
        }



    }









