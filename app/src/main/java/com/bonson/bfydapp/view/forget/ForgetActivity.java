package com.bonson.bfydapp.view.forget;

import android.os.Bundle;

import com.bonson.bfydapp.R;
import com.bonson.bfydapp.databinding.ActivityForgetBinding;
import com.bonson.bfydapp.view.register.VerifyViewModel;
import com.bonson.resource.activity.BaseDaggerActivity;

import javax.inject.Inject;

/**
 * Created by zjw on 2017/12/29.
 */

public class ForgetActivity extends BaseDaggerActivity<ActivityForgetBinding> {
    @Inject
    ForgetViewModel viewModel;

    @Inject
    VerifyViewModel verifyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindingLayout(R.layout.activity_forget);

        binding.setViewModel(viewModel);
        binding.setVerifyViewModel(verifyViewModel);
        setViewModel(viewModel,verifyViewModel);

        binding.toolbar.setTitle("找回密码");
        binding.toolbar.getTvLeft().setOnClickListener(view -> finish());

        verifyViewModel.verifyEnable.set(true);
        verifyViewModel.verifyText.set(getString(R.string.verify));
    }
}
