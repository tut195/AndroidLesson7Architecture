package com.babenkovladimir.androidlesson7architecture.mvvm;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

  MyViewModel mModel;
  private Context mContext = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
//    mModel = ViewModelProviders.of(this, factory).get(MyViewModel.class);
    mModel = new ViewModelProvider(this).get(MyViewModel.class);//ViewModelProviders.of(this, factory).get(MyViewModel.class);
    binding.setViewModel(mModel);
    binding.setLifecycleOwner(this);
    getLifecycle().addObserver(mModel);

    setupListeners();
  }

  private void setupListeners() {
    mModel.someEvent.observe_(this, o -> new Builder(mContext)
        .setTitle("Warning!")
        .setMessage("Fields are not valid!")
        .setCancelable(true)
        .show());

    mModel.showSuccessPopupEvent.observe_(this, new Observer<Object>() {
          @Override
          public void onChanged(Object o) {
            new Builder(mContext)
                .setTitle(getByRes(R.string.congrats))
                .setMessage("You shell pass!")
                .setCancelable(true)
                .show();
          }
        }
    );
  }

  private String getByRes(int res) {
//    return this.getString(res);
    return mContext.getString(res);
  }

}
