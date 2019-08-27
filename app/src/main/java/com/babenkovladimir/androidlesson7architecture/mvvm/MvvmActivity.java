package com.babenkovladimir.androidlesson7architecture.mvvm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.babenkovladimir.androidlesson7architecture.R;

public class MvvmActivity extends AppCompatActivity {

  MyViewModel mModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mvvm);

    initViewModel();
  }

  private void initViewModel() {
    mModel = ViewModelProviders.of(this).get(MyViewModel.class);
  }
}
