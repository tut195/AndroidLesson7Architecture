package com.babenkovladimir.androidlesson7architecture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson7architecture.mvp.MvpActivity;
import com.babenkovladimir.androidlesson7architecture.mvvm.MvvmActivity;

public class MainActivity extends AppCompatActivity {

  // Variables

  @BindView(R.id.btMvpActivity)
  Button mMvpBt;

  @BindView(R.id.btMvvmActivity)
  Button mMvvmBt;

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
  }
}
