package com.arifinmnur.VegetaApp;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SayurandanBuahFragment extends Fragment {
    CoordinatorLayout.Behavior behavior;
    private ArrayList<SayurandanBuah> sayurandanBuahs = new ArrayList<>();
    private RecyclerView recyclerView;
    private SayurandanBuahAdapter mAdapter;

    public SayurandanBuahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycle_main_layout, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        sayurandanBuahs = new ArrayList<>();
        sayurandanBuahs.add(new SayurandanBuah("Anggur", "Buah", R.drawable.buah_anggur));
        sayurandanBuahs.add(new SayurandanBuah("Apel", "Buah", R.drawable.buah_apel));
        sayurandanBuahs.add(new SayurandanBuah("Jeruk", "Buah", R.drawable.buah_jeruk));
        sayurandanBuahs.add(new SayurandanBuah("Mangga", "Buah", R.drawable.buah_mangga));
        sayurandanBuahs.add(new SayurandanBuah("Pisang", "Buah", R.drawable.buah_pisang));
        sayurandanBuahs.add(new SayurandanBuah("Strawberry", "Buah", R.drawable.buah_strawberry));

        sayurandanBuahs.add(new SayurandanBuah("Bawang Putih", "Sayuran", R.drawable.sayuran_bawangputih));
        sayurandanBuahs.add(new SayurandanBuah("Cabe", "Sayuran", R.drawable.sayuran_cabe));
        sayurandanBuahs.add(new SayurandanBuah("Jagung", "Sayuran", R.drawable.sayuran_jagung));
        sayurandanBuahs.add(new SayurandanBuah("Wortel", "Sayuran", R.drawable.sayuran_wortel));
        sayurandanBuahs.add(new SayurandanBuah("Brokoli", "Sayuran", R.drawable.sayuran_brokoli));
        sayurandanBuahs.add(new SayurandanBuah("Bayam", "Sayuran", R.drawable.sayuran_bayam));

        mAdapter = new SayurandanBuahAdapter(sayurandanBuahs);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                SayurandanBuah sayurandanBuah = sayurandanBuahs.get(position);
                Toast.makeText(getActivity().getApplicationContext(), sayurandanBuah.getNamaBuah() + " is selected!", Toast.LENGTH_SHORT).show();
                DetailActivity.navigate(getActivity(), view.findViewById(R.id.imageRX), sayurandanBuah);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }



}
