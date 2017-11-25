package com.arifinmnur.VegetaApp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

public class MainActivity extends AppCompatActivity {
    private int[] imageResId = {
            R.drawable.ic_home_white_48dp,
            R.drawable.ic_local_grocery_store_white_48dp,
            R.drawable.ic_library_books_white_48dp,
            R.drawable.ic_account_circle_white_48dp};

    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_category);
        getSupportActionBar().setElevation(0);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Set the adapter onto the view pager
        viewPager.setAdapter(new SimpleFragmentAdapter(getSupportFragmentManager(), MainActivity.this));


        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // configure icons


        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);

        }
    }


}
