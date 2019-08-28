package com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.base.BaseMoxyActivity;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.impl.UserLoginMoxyPresenterImpl;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

//public class UserLoginMoxyActivity extends MvpAppCompatActivity implements IUserLoginMoxyView {
public class UserLoginMoxyActivity extends BaseMoxyActivity implements IUserLoginMoxyView {

  // Variables

  @BindView(R.id.etUserLogin)
  EditText mUserLogin;

  @BindView(R.id.etPassword)
  EditText mPassword;

  @BindView(R.id.btLogin)
  Button mLoginBt;

  @InjectPresenter
  UserLoginMoxyPresenterImpl mPresenter;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_login);

    ButterKnife.bind(this);
    setupListeners();
  }

  // Private

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

  // Implementation

// MyView implementation

  @Override
  public void showWarningMessage() {
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
}