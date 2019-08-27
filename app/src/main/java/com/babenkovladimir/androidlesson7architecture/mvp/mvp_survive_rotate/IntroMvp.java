package com.babenkovladimir.androidlesson7architecture.mvp.mvp_survive_rotate;

interface IntroMvp {

  interface View {

    void updateCount(int count);
  }

  interface Presenter {

    void attachView(View view);

    void detachView();

    void incrementValue();

    void decrementValue();
  }
}
