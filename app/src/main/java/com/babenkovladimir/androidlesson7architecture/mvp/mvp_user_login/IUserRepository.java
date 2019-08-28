package com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login;

import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

public interface IUserRepository {

  Long saveUserToDb(User user);

}
