package com.example.henry.mycalculator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by UMARU on 7/27/2016.
 */


public class SwiperCalculatorActivity extends ActionBarActivity {
    ViewPager SwipePage; //Layout manager that allows user to swipe left and right through pages
    CustomAdapter mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipePage = new ViewPager(this);
        SwipePage.setId(R.id.container);
        setContentView(SwipePage);
        mCustomAdapter = new CustomAdapter(this, SwipePage);
        SwipePage.setAdapter(mCustomAdapter);
    }
    //class CustomAdapter defined in SwiperCalculatorActivity
    public static class CustomAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
        interface FragmentFactory {
            Fragment createFragment();
        }

        class ExpressionCalculatorFragmentFactory implements FragmentFactory {
            public Fragment createFragment() {
                return new ExpressionCaculatorFragment();
            }
        }

        class ConverterFragmentFactory implements FragmentFactory {
            public Fragment createFragment() {
                return new ConverterFragment();
            }
        }

        private Context mContext;
        private ViewPager SwipePage;
        private static ArrayList<FragmentFactory> mFragments;
        private Integer fragmentIndex = 0;


        public CustomAdapter(FragmentActivity activity, ViewPager pager) {

            super(activity.getSupportFragmentManager());
            mContext = activity;
            SwipePage = pager;
            SwipePage.setAdapter(this);
            SwipePage.addOnPageChangeListener(this);
            mFragments = new ArrayList<>(); //implicitly type FragmentFactory
            mFragments.add(new ConverterFragmentFactory() );
            mFragments.add(new ExpressionCalculatorFragmentFactory());
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if ( positionOffsetPixels < 20 || position != fragmentIndex ){
                return ;
            }
            fragmentIndex = (fragmentIndex + 1 ) % mFragments.size();
            SwipePage.setCurrentItem( fragmentIndex );
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position).createFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
