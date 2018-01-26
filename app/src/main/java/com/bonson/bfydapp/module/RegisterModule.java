package com.bonson.bfydapp.module;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.view.register.RegisterViewModel;
import com.bonson.bfydapp.view.register.VerifyViewModel;
import com.bonson.resource.viewmodel.AndroidViewModel;

import dagger.Binds;
import dagger.Module;

/**
 * Created by zjw on 2017/12/29.
 */
@Module
public abstract class RegisterModule {

    @Binds
    @ActivityScope
    abstract AndroidViewModel viewModel(RegisterViewModel viewModel);

    @Binds
    @ActivityScope
    abstract AndroidViewModel verifyModel(VerifyViewModel viewModel);
}
