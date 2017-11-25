package com.arifinmnur.VegetaApp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }

    ArrayAdapter<String> adapter;
    View rootView;

    String[] listBuah={
       "Anggur","Apel","Jeruk","Mangga","Pisang","StrawBerry"
    };

    String[] listSayuran={
            "Bawang Putih","Cabe","Jagung","Wortel","Brokoli","Bayam"
    };

    ArrayList<String> buahArrayList;
    ArrayList<String> sayuranArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_order, container, false);

        buahArrayList = new ArrayList<String>();
        for(int i=0;i<listBuah.length;i++) {
            buahArrayList.add(listBuah[i]);
        }

        sayuranArrayList = new ArrayList<String>();
        for(int i=0;i<listSayuran.length;i++) {
            sayuranArrayList.add(listSayuran[i]);
        }



        ArrayList<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Pilih");
        spinnerArray.add("Buah");
        spinnerArray.add("Sayuran");

        adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) rootView.findViewById(R.id.spinnerJenis);
        sItems.setAdapter(adapter);

        ArrayList<String> spinnerArrayBuah =  new ArrayList<String>();
        spinnerArrayBuah.add("Pilih");




        adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArrayBuah);
        Spinner sItems2 = (Spinner) rootView.findViewById(R.id.spinnerJenisdrop);
        sItems2.setAdapter(adapter);

        // Spinner click listener
        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                String selected = String.copyValueOf(parent.getItemAtPosition(position)
                        .toString(). toCharArray());
                if (selected.equalsIgnoreCase("buah")) {
                    dynamicDropdown(buahArrayList);
                }
                else if (selected.equalsIgnoreCase("Sayuran")) {
                    dynamicDropdown(sayuranArrayList);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }
 public void dynamicDropdown(ArrayList<String> arrayList){
     adapter = new ArrayAdapter<String>(
             getActivity(), android.R.layout.simple_spinner_item, arrayList);

     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     Spinner sItems2 = (Spinner) rootView.findViewById(R.id.spinnerJenisdrop);
     sItems2.setAdapter(adapter);
 }
}
