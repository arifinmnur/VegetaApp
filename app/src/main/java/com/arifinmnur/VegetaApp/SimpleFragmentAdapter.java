package com.arifinmnur.VegetaApp;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Home", "Order", "List" ,"About"};

    private int[] imageResId = {
            R.drawable.ic_home_white_48dp,
            R.drawable.ic_local_grocery_store_white_48dp,
            R.drawable.ic_library_books_white_48dp,
            R.drawable.ic_person_pin_white_48dp};


    private Context context;

    public SimpleFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    public SimpleFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:return new BlankFragment();
            case 1:return new BlankFragment();
            case 2:return new SayurandanBuahFragment();
            case 3:return new AboutFragment();
        }
        //return PageFragment.newInstance(position + 1);
        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString("   " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }





}
