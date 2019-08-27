package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login;

import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract.Presenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract.View;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

public class UserLoginPresenter implements Presenter {

  // View

  UserLoginContract.View mView;

  // Model

  private User mUser;

  // Constructor

  public UserLoginPresenter() {
    mUser = new User();

  }

  // Implementation

  @Override
  public void changeLogin(String login) {
    mUser.setLogin(login);
  }

  @Override
  public void changePassword(String password) {
    mUser.setPassword(password);
  }

  @Override
  public void attachView(View view) {
    mView = view;
    updateView();
  }

  @Override
  public void detachView() {
    mView = null;
  }

  @Override
  public void onButtonLoginClick() {
    if (!areFieldsValid()) {
      if (mView != null) {
        mView.showWarningMessage();
      }
    } else {
      mView.showSuccessPopup();
      // TODO use User fields
    }
  }

  // Private

  private Boolean areFieldsValid() {
    return (mUser.getLogin().length() > 3 && mUser.getPassword().length() > 3);
  }

  private void updateView() {
    if (mView != null) {
      mView.updateFields(mUser);
    }
  }
}
