package com.bonson.bfydapp.view.login;

import android.os.Bundle;
import android.view.View;

import com.bonson.bfydapp.R;
import com.bonson.bfydapp.app.Route;
import com.bonson.bfydapp.databinding.ActivityLoginBinding;
import com.bonson.resource.activity.BaseDaggerActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseDaggerActivity<ActivityLoginBinding> {
    @Inject
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindingLayout(R.layout.activity_login);
        binding.setViewModel(viewModel);
        setViewModel(viewModel);
    }

    public void forget(View view) {
        start(Route.forget);
    }

    public void register(View view) {
        start(Route.register);
    }

}
