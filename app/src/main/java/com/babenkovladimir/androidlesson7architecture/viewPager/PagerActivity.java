package com.babenkovladimir.androidlesson7architecture.viewPager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.viewPager.fragments.FirstFragment;
import com.babenkovladimir.androidlesson7architecture.viewPager.fragments.bankcards.UserLoginFragment;
import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pager);

    MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());

    ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
    adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
    vpPager.setAdapter(adapterViewPager);

//    vpPager.setPageTransformer(false, new ViewPager.PageTransformer() {
//      @Override
//      public void transformPage(View page, float position) {
//        int pageWidth = view.getWidth();
//        int pageHeight = view.getHeight();
//
//        if (position < -1) { // [-Infinity,-1)
//          // This page is way off-screen to the left.
//          view.setAlpha(0);
//        } else if(position <= 1){ // Page to the left, page centered, page to the right
//          // modify page view animations here for pages in view
//        } else { // (1,+Infinity]
//          // This page is way off-screen to the right.
//          view.setAlpha(0);
//        }
//      }
//    });

  }

  // My Pager Adapter

  public static class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    private List<String> fragmentTitleList;

    public MyPagerAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);

      fragmentTitleList = new ArrayList<>();

      fragmentTitleList.add(UserLoginFragment.FRAGMENT_TITLE);
      fragmentTitleList.add(FirstFragment.FRAGMENT_TITLE);
      fragmentTitleList.add(FirstFragment.FRAGMENT_TITLE);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
      return NUM_ITEMS;
    }

    // Returns the fragment to display for that page


    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0: // Fragment # 0 - This will show FirstFragment
          return UserLoginFragment.newInstance();
        case 1: // Fragment # 0 - This will show FirstFragment different title
          return FirstFragment.newInstance(1, "Page # 2");
        case 2: // Fragment # 1 - This will show SecondFragment
          return FirstFragment.newInstance(1, "Page # 3");
        default:
          return null;
      }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
      return fragmentTitleList.get(position);
    }

  }
}
