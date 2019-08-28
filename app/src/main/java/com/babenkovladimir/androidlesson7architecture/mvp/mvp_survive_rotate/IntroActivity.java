package com.babenkovladimir.androidlesson7architecture.mvp.mvp_survive_rotate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.babenkovladimir.androidlesson7architecture.R;


public class IntroActivity extends AppCompatActivity implements IntroMvp.View {

  private TextView output;

  private IntroMvp.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro2);
    bindViews();
    attachPresenter();
    Log.d("TAGA","on create" + this.hashCode());
  }

  private void attachPresenter() {
    presenter = (IntroMvp.Presenter) getLastCustomNonConfigurationInstance();
    if (presenter == null) {
      presenter = new IntroPresenter();
    }
    presenter.attachView(this);
    Log.d("TAGA","presenter hash code - "+ presenter.hashCode());
  }

  @Override
  protected void onDestroy() {
    presenter.detachView();
    super.onDestroy();

    Log.d("TAGA","on destroy" + this.hashCode());
  }

  @Override
  public Object onRetainCustomNonConfigurationInstance() {
    return presenter;
  }

  private void bindViews() {
    output = (TextView) findViewById(R.id.presenter_details);
  }

  public void incrementButtonPressed(View view) {
    presenter.incrementValue();
  }

  public void decrementButtonPressed(View view) {
    presenter.decrementValue();
  }

  @Override
  public void updateCount(final int count) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        output.setText("Counter: = " + count);
      }
    });
  }
}
