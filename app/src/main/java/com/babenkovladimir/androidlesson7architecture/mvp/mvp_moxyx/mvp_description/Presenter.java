package com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.mvp_description;

public abstract class Presenter<V extends MyView> {

  private MyView mView;

  void attachView(MyView view){
    mView = view;
  }

  void detachView(){
    mView = null;
  }


}
