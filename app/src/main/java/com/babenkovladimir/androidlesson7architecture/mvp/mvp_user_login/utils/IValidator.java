package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.utils;

public interface IValidator {

  boolean isUserLoginValid(String login);

  boolean isPasswordValid(String password);

}
