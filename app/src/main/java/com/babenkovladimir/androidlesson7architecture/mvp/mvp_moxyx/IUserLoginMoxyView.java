package com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx;

import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.base.BaseMoxyView;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

//public interface IUserLoginMoxyView extends MvpView {
public interface IUserLoginMoxyView extends BaseMoxyView {

  void showWarningMessage();

  void showSuccessPopup();

  void updateFields(User user);

}
