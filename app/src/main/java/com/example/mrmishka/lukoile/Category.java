package com.example.mrmishka.lukoile;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mrmishka.lukoile.maps.MapsAZS;
import com.example.mrmishka.lukoile.promotion.Promotions;

public class Category extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

      //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.container);




        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setOnTabSelectedListener(this);
    //    setSupportActionBar(toolbar);
     //   getSupportActionBar().setTitle("КАРТА КЛИЕНТА");
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {

            case 0:
        //        getSupportActionBar().setTitle("КАРТА КЛИЕНТА");

                break;
            case 1:
        //        getSupportActionBar().setTitle("СПИСОК АЗС");
                break;
            case 2:
       //         getSupportActionBar().setTitle("АКЦИИ");
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:

                    CustomerCard card = new CustomerCard();
                    return card;
                case 1:

                    MapsAZS mapsAzs = new MapsAZS();
                    return mapsAzs;
                case 2:

                    Promotions promo = new Promotions();
                    return promo;

                default:
                    return null;


            }

        }

        @Override
        public int getCount() {

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "КАРТА КЛИЕНТА";

                case 1:

                    return "СПИСОК АЗС";
                case 2:

                    return "АКЦИИ";

            }
            return null;
        }
    }
}
