package com.babenkovladimir.androidlesson7architecture.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_moxyx.UserLoginMoxyActivity;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_survive_rotate.IntroActivity;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginActivity;

public class MvpActivity extends AppCompatActivity {

  // Variables

  @BindView(R.id.btSimpleMvpExample)
  Button btSimpleMvpExampleButton;

  @BindView(R.id.btUserLoginMVP)
  Button btLoginMvpButton;

  @BindView(R.id.btUserLoginMoxyMvp)
  Button mBtLoginMvpMoxyButton;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mvp);

    ButterKnife.bind(this);

    setupUI();
  }

  // Private

  private void setupUI() {
    btSimpleMvpExampleButton.setOnClickListener(view -> startActivity(new Intent(this, IntroActivity.class)));
    btLoginMvpButton.setOnClickListener(view -> startActivity(new Intent(this, UserLoginActivity.class)));
    mBtLoginMvpMoxyButton.setOnClickListener(view -> startActivity(new Intent(this, UserLoginMoxyActivity.class)));
  }
}
