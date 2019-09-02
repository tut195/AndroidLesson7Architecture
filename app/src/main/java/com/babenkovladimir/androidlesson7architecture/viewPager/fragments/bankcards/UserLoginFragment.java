package com.babenkovladimir.androidlesson7architecture.viewPager.fragments.bankcards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.babenkovladimir.androidlesson7architecture.R;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginContract;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.UserLoginPresenter;
import com.babenkovladimir.androidlesson7architecture.mvp.mvp_user_login.entity.User;

public class UserLoginFragment extends Fragment implements UserLoginContract.View {

  // Static

  public static final String FRAGMENT_TITLE = "BankCards";

  public static UserLoginFragment newInstance() {
    UserLoginFragment fragment = new UserLoginFragment();
    return fragment;
  }

  // Public

  private UserLoginContract.Presenter mPresenter;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Init presenter
    mPresenter = new UserLoginPresenter();
    mPresenter.attachView(this);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_bank_cards, container, false);

    view.findViewById(R.id.btLogin).setOnClickListener(viewwwww -> mPresenter.onButtonLoginClick());

    return view;
  }

  @Override
  public void showWarningPopup() {
    new AlertDialog.Builder(requireContext())
        .setTitle("Warning")
        .setMessage("Some fields are not valid")
        .setCancelable(true)
        .show();
  }

  @Override
  public void showSuccessPopup() {
    new AlertDialog.Builder(requireContext())
        .setTitle("Congrats!")
        .setMessage("You shell pass!")
        .setCancelable(true)
        .show();
  }

  @Override
  public void updateFields(User user) {

  }

  @Override
  public void navigateNextScreen() {

  }
}
