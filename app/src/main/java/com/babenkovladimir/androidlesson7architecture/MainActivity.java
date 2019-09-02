package com.babenkovladimir.androidlesson7architecture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson7architecture.bottomnavigationview.BottomNvigationActivity;
import com.babenkovladimir.androidlesson7architecture.mvp.MvpActivity;
import com.babenkovladimir.androidlesson7architecture.mvvm.MvvmActivity;
import com.babenkovladimir.androidlesson7architecture.navigation_drawer.NavigationDrawerActivity;
import com.babenkovladimir.androidlesson7architecture.viewPager.PagerActivity;

public class MainActivity extends AppCompatActivity {

  // Variables

  @BindView(R.id.btMvpActivity)
  Button mMvpBt;

  @BindView(R.id.btMvvmActivity)
  Button mMvvmBt;

  @BindView(R.id.btViewPagerActivity)
  Button mViewPagerActivity;

  @BindView(R.id.btNavigationDrawerActivity)
  Button mNavigationDrawer;

  @BindView(R.id.btBottomNavigation)
  Button mBottomNavigationButton;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    setupUI();
  }

  private void setupUI() {
    mMvpBt.setOnClickListener(view -> startActivity(new Intent(this, MvpActivity.class)));
    mMvvmBt.setOnClickListener(view -> startActivity(new Intent(this, MvvmActivity.class)));

    mViewPagerActivity.setOnClickListener(view -> {
      startActivity(new Intent(MainActivity.this, PagerActivity.class));
    });

    mNavigationDrawer.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
      }
    });

    mBottomNavigationButton.setOnClickListener(view -> startActivity(new Intent(this, BottomNvigationActivity.class)));

  }
}
