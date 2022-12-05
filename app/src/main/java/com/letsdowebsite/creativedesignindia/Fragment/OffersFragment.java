package com.letsdowebsite.creativedesignindia.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsdowebsite.creativedesignindia.Adapter.OffersAdapter;
import com.letsdowebsite.creativedesignindia.MyListData;
import com.letsdowebsite.creativedesignindia.R;


public class OffersFragment extends Fragment {
    private View view;

    MyListData[] myListData = new MyListData[] {
            new MyListData("", R.drawable.freedesiggn),
            new MyListData("", R.drawable.newarrivala),
            new MyListData("", R.drawable.mann),
            new MyListData("", R.drawable.womanw),
            new MyListData("", R.drawable.kids),
            new MyListData("", R.drawable.premiumcus),
            new MyListData("", R.drawable.todays),

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.list_offers, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.recyclerView);
        OffersAdapter adapter = new OffersAdapter(myListData , getActivity());
        metrostationlist.setHasFixedSize(true);

        metrostationlist.setAdapter(adapter);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
