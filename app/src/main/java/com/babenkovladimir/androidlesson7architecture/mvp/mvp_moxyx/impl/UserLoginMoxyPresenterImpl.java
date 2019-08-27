package com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.impl;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.IUserLoginMoxyPresenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.IUserLoginMoxyView;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.base.BaseMoxyPresenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

@InjectViewState
public class UserLoginMoxyPresenterImpl extends BaseMoxyPresenter<IUserLoginMoxyView> implements IUserLoginMoxyPresenter {

  // Model

  private User mUser;

  public UserLoginMoxyPresenterImpl() {
    mUser = new User();

  }

  @StateStrategyType(AddToEndSingleStrategy.class)
  @Override
  public void changeLogin(String login) {
    mUser.setLogin(login);
  }

  @StateStrategyType(AddToEndSingleStrategy.class)
  @Override
  public void changePassword(String password) {
    mUser.setPassword(password);
  }

  @StateStrategyType(AddToEndSingleStrategy.class)
  @Override
  public void onButtonLoginClick() {

    if (!areFieldsValid()) {
      getViewState().showWarningMessage();
    } else {
      getViewState().showSuccessPopup();
      // TODO use User fields
    }

  }

  // Private

  private Boolean areFieldsValid() {
    return (mUser.getLogin().length() > 3 && mUser.getPassword().length() > 3);
  }
}
