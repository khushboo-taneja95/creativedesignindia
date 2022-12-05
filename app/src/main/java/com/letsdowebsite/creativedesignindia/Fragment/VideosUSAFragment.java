package com.letsdowebsite.creativedesignindia.Fragment;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsdowebsite.creativedesignindia.Adapter.VideosUSAAdapter;
import com.letsdowebsite.creativedesignindia.MyListData;
import com.letsdowebsite.creativedesignindia.R;


public class VideosUSAFragment extends Fragment {
    private View view;
    Context ctx;

    MyListData[] myListData = new MyListData[] {
            new MyListData("Overview Of CDI Footwear Solution", R.drawable.imgusa),
            new MyListData("How To Buy Membership In CDI Footwear Solution", R.drawable.img1usa),



    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.cartimage, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.recyclerView);
        VideosUSAAdapter adapter = new VideosUSAAdapter(myListData , getActivity());
        metrostationlist.setHasFixedSize(true);
        metrostationlist.setAdapter(adapter);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

        
        return view;


    }
}