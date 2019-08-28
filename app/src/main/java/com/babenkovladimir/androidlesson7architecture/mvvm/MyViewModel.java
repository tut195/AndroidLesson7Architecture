package com.babenkovladimir.androidlesson7architecture.mvvm;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel implements LifecycleObserver {


  LiveData<String> mLogin = new MutableLiveData<>();

  private ObservableField<String> password = new ObservableField<String>();


  public ObservableField<String> getPassword() {
    return password;
  }

  public void setPassword(ObservableField<String> password) {
    this.password = password;
  }

  SingleLiveEvent<Object> someEvent = new SingleLiveEvent<>();

  @OnLifecycleEvent(Event.ON_CREATE)
  public void onC() {
    Log.d("TAGAA", "on viewModel Create");
  }

  @OnLifecycleEvent(Event.ON_DESTROY)
  public void onD() {
    Log.d("TAGAA", "on viewModel Destroy");
  }


  public void onButtonLoginClick() {
    someEvent.call();

  }

}
