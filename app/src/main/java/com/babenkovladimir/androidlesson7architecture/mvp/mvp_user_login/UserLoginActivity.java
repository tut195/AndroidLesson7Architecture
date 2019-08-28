package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract.Presenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

public class UserLoginActivity extends AppCompatActivity implements UserLoginContract.View {

  // Variables

  @BindView(R.id.etUserLogin)
  EditText mUserLogin;

  @BindView(R.id.etPassword)
  EditText mPassword;

  @BindView(R.id.btLogin)
  Button mLoginBt;

  Presenter mPresenter;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_login);
    ButterKnife.bind(this);

    attachPresenter();
    setupListeners();
  }

  private void attachPresenter() {
    mPresenter = (Presenter) getLastCustomNonConfigurationInstance();
    if (mPresenter == null) {
      mPresenter = new UserLoginPresenter();
    }

    mPresenter.attachView(this);
    Log.d("TAGA","presenter hash code - "+ mPresenter.hashCode());
  }

  @Override
  public Object onRetainCustomNonConfigurationInstance() {
    return mPresenter;
  }

  private void setupListeners() {

    mUserLogin.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void afterTextChanged(Editable editable) {
        mPresenter.changeLogin(editable.toString());
      }
    });

    mPassword.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void afterTextChanged(Editable editable) {
        mPresenter.changePassword(editable.toString());
      }
    });

    mLoginBt.setOnClickListener(view -> mPresenter.onButtonLoginClick());

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }

  // MyView implementation

  @Override
  public void showWarningPopup() {
    new AlertDialog.Builder(this)
        .setTitle("Warning")
        .setMessage("Some fields are not valid")
        .setCancelable(true)
        .show();
  }

  @Override
  public void showSuccessPopup() {
    new AlertDialog.Builder(this)
        .setTitle("Congrats!")
        .setMessage("You shell pass!")
        .setCancelable(true)
        .show();
  }

  @Override
  public void updateFields(User user) {
    mUserLogin.setText(user.getLogin());
  }

  @Override
  public void navigateNextScreen() {
    startActivity(new Intent("tel:+38050 - - - "));
  }
}
