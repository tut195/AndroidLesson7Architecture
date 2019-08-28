package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login;

import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract.Presenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract.View;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.utils.IValidator;

public class UserLoginPresenter implements Presenter {

  // MyView

  UserLoginContract.View mView;

  // Model

  private User mUser;

  private IUserRepository mRepository;
  private IValidator mValidator;

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
        mView.showWarningPopup();
      }
    } else {
      mRepository.saveUserToDb(mUser);
      mView.showSuccessPopup();
//      mView.navigateNextScreen();
      // TODO use User fields
    }
  }

  // Private

  private Boolean areFieldsValid() {
//    return (mValidator.isUserLoginValid(mUser.getLogin())  && mValidator.isPasswordValid(mUser.getPassword()));
    return (mUser.getLogin().length() > 3 && mUser.getPassword().length() > 3);
  }

  private void updateView() {
    if (mView != null) {
      mView.updateFields(mUser);
    }
  }
}
