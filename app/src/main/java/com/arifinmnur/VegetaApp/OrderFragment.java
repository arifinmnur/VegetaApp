package com.arifinmnur.VegetaApp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    View rootView;

    String[] listBuah = {
            "Anggur", "Apel", "Jeruk", "Mangga", "Pisang", "StrawBerry"
    };

    String[] listSayuran = {
            "Bawang Putih", "Cabe", "Jagung", "Wortel", "Brokoli", "Bayam"
    };

    ArrayList<String> buahArrayList;
    ArrayList<String> sayuranArrayList;
    Spinner sItems;
    Spinner sItems2;
    TextView nama;
    TextView berat;
    TextView jenis;
    TextView jenisKiriman;
    TextView hargaTotaltv;

    CardView cd;
    CardView report;
    TextInputEditText ti_nama;
    TextInputEditText ti_berat;


    RadioButton jenkirKilat;
    RadioButton jenkirRegular;
    RadioButton jenkirEkonomi;
    String buahselected;
    String sayuranSelected;

    double HargajenkirKilat=5000,
        HargaJenkirRegular=3000,
        HargaJenkirEkonomi=1000;

    double hargaTotal=0,
            hargakilo=5000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_order, container, false);
        nama = (TextView) rootView.findViewById(R.id.rptNama);
        jenis = (TextView) rootView.findViewById(R.id.rptJenisBuah);
        berat = (TextView) rootView.findViewById(R.id.rptBerat);
        jenisKiriman = (TextView) rootView.findViewById(R.id.rptJenisKiriman);
        hargaTotaltv=(TextView) rootView.findViewById(R.id.rptHargaTotal);

        jenkirKilat = (RadioButton) rootView.findViewById(R.id.jenkirKilat);
        jenkirRegular = (RadioButton) rootView.findViewById(R.id.jenkirRegular);
        jenkirEkonomi = (RadioButton) rootView.findViewById(R.id.jenkirEkonomi);

        cd = (CardView) rootView.findViewById(R.id.orderLayout);
        report = (CardView) rootView.findViewById(R.id.detailOrder);
        ti_nama = (TextInputEditText) rootView.findViewById(R.id.txInputNama);
        ti_berat = (TextInputEditText) rootView.findViewById(R.id.txInputBerat);


        buahArrayList = new ArrayList<String>();
        for (int i = 0; i < listBuah.length; i++) {
            buahArrayList.add(listBuah[i]);
        }

        sayuranArrayList = new ArrayList<String>();
        for (int i = 0; i < listSayuran.length; i++) {
            sayuranArrayList.add(listSayuran[i]);
        }


        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Pilih");
        spinnerArray.add("Buah");
        spinnerArray.add("Sayuran");

        adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems = (Spinner) rootView.findViewById(R.id.spinnerJenis);
        sItems.setAdapter(adapter);

        ArrayList<String> spinnerArrayBuah = new ArrayList<String>();
        spinnerArrayBuah.add("Pilih");


        adapter2 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArrayBuah);
        sItems2 = (Spinner) rootView.findViewById(R.id.spinnerJenisdrop);
        sItems2.setAdapter(adapter2);

        // Spinner click listener
        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                buahselected = String.copyValueOf(parent.getItemAtPosition(position)
                        .toString().toCharArray());
                if (buahselected.equalsIgnoreCase("buah")) {
                    dynamicDropdown(buahArrayList);
                } else if (buahselected.equalsIgnoreCase("Sayuran")) {
                    dynamicDropdown(sayuranArrayList);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sItems2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sayuranSelected = String.copyValueOf(parent.getItemAtPosition(position)
                        .toString().toCharArray());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btOrder = (Button) rootView.findViewById(R.id.btOrder);
        btOrder.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Order telah diKirim", Toast.LENGTH_SHORT).show();

                nama.setText(ti_nama.getText());
                berat.setText(ti_berat.getText());
                jenis.setText(buahselected + " = " + sayuranSelected);

                int berat = Integer.parseInt(ti_berat.getText().toString());
                hargaTotal=hargakilo*berat;

                if (jenkirKilat.isChecked()) {
                    jenisKiriman.setText(jenkirKilat.getText()+" - Rp."+HargajenkirKilat);
                    hargaTotal+=HargajenkirKilat;
                }
                if (jenkirRegular.isChecked()) {
                    jenisKiriman.setText(jenkirRegular.getText()+" - Rp."+HargaJenkirRegular);
                    hargaTotal+=HargaJenkirRegular;
                }
                if (jenkirEkonomi.isChecked()) {
                    jenisKiriman.setText(jenkirRegular.getText()+" - Rp."+HargaJenkirEkonomi);
                    hargaTotal+=HargaJenkirEkonomi;
                }

                hargaTotaltv.setText(String.valueOf(hargaTotal));


                cd.setVisibility(View.GONE);
                report.setVisibility(View.VISIBLE);
            }
        });

        Button btFinnish = (Button) rootView.findViewById(R.id.btFininsh);
        btFinnish.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Order telah diKirim", Toast.LENGTH_SHORT).show();

                ti_nama.setText("");
                ti_berat.setText("");
                jenkirEkonomi.setChecked(false);
                jenkirRegular.setChecked(false);
                jenkirKilat.setChecked(false);
                sItems.setSelection(0);
                sItems2.setAdapter(adapter2);


                CardView cd = (CardView) rootView.findViewById(R.id.orderLayout);
                cd.setVisibility(View.VISIBLE);
                CardView report = (CardView) rootView.findViewById(R.id.detailOrder);
                report.setVisibility(View.GONE);
            }
        });
        return rootView;
    }

    public void dynamicDropdown(ArrayList<String> arrayList) {
        adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, arrayList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) rootView.findViewById(R.id.spinnerJenisdrop);
        sItems2.setAdapter(adapter);
    }
}
