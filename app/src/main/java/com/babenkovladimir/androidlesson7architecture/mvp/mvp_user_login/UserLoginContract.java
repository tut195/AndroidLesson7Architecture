package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login;

import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

public interface UserLoginContract {

  interface View {

    void showWarningPopup();

    void showSuccessPopup();

    void updateFields(User user);

    void navigateNextScreen();
  }

  interface Presenter {

    void changeLogin(String login);

    void changePassword(String password);

    void attachView(UserLoginContract.View view);

    void detachView();

    void onButtonLoginClick();
  }
}
