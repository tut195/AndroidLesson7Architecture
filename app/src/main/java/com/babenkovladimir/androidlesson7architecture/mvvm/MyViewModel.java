package com.babenkovladimir.androidlesson7architecture.mvvm;

import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel implements LifecycleObserver {

  // Observable fields

  private ObservableField<String> password = new ObservableField<>();
  private ObservableField<String> login = new ObservableField<>();

  // Events

  SingleLiveEvent<Object> someEvent = new SingleLiveEvent<>();
  SingleLiveEvent<Object> showSuccessPopupEvent = new SingleLiveEvent<>();

  // Lifecycle

  @OnLifecycleEvent(Event.ON_CREATE)
  public void onC() {

    // Устанавилвает начальные значения пустыми, либо при валидации проверяем что поля не есть null
    password.set("");
    login.set("");

    Log.d("TAGAA", "on viewModel Create");
  }

  @OnLifecycleEvent(Event.ON_DESTROY)
  public void onD() {
    Log.d("TAGAA", "on viewModel Destroy");
  }

  // OnClick

  public void onButtonLoginClick() {
    if (!areFieldsValid()) {
      someEvent.call();
    } else {
      // TODO create new User and use it according business logic
      showSuccessPopupEvent.call();
    }
  }

  // Private

  private boolean areFieldsValid() {
    String passwordValue = password.get();
    String loginValue = login.get();

    return (passwordValue.length() > 3 && loginValue.length() > 3);
  }

  // Getters and setters

  public ObservableField<String> getPassword() {
    return password;
  }

  public void setPassword(ObservableField<String> password) {
    this.password = password;
  }

  public ObservableField<String> getLogin() {
    return login;
  }

  public void setLogin(ObservableField<String> login) {
    this.login = login;
  }

}
