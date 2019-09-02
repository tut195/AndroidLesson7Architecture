package com.babenkovladimir.androidlesson7architecture.bottomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.viewPager.fragments.FirstFragment;
import com.babenkovladimir.androidlesson7architecture.viewPager.fragments.bankcards.UserLoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class BottomNvigationActivity extends AppCompatActivity {

  @BindView(R.id.bottom_navigation)
  BottomNavigationView bnw;

  @BindView(R.id.container)
  FrameLayout mContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bottom_nvigation);

    ButterKnife.bind(this);

    bnw.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int menuItemId = menuItem.getItemId();

        switch (menuItemId) {
          case R.id.action_favorites:
            showFragment(FirstFragment.newInstance(1, "some"));
            return true;
          case R.id.action_schedules:
            showFragment(UserLoginFragment.newInstance());
            Toast.makeText(BottomNvigationActivity.this, "Second", Toast.LENGTH_SHORT).show();
            return true;
          case R.id.action_music:
            showFragment(FirstFragment.newInstance(1, "Third"));
            Toast.makeText(BottomNvigationActivity.this, "Thierd", Toast.LENGTH_SHORT).show();

            return true;
        }

        return false;
      }
    });
  }

  private void showFragment(Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
  }
}
