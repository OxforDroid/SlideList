package com.slide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

public class Main2Activity extends FragmentActivity {

    ViewPager pager;
    PagerAdapter pagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);
        pagerTabStrip.setDrawFullUnderline(true);

        TitleAdapter titleAdapter = new TitleAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(titleAdapter);
        mViewPager.setCurrentItem(0);
    }

    public class TitleAdapter extends FragmentPagerAdapter {
        private final String titles[] = getResources().getStringArray(R.array.data2);

        private final Fragment frags[] = new Fragment[titles.length];

        public TitleAdapter(FragmentManager fm) {
            super(fm);
            frags[0] = new dikie1();
            frags[1] = new dikie2();
            frags[2] = new dikie3();
            frags[3] = new dikie4();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return frags[position];
        }

        @Override
        public int getCount() {
            return frags.length;
        }
    }

}

