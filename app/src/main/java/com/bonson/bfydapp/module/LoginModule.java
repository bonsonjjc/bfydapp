package com.bonson.bfydapp.module;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.view.login.LoginViewModel;
import com.bonson.resource.viewmodel.AndroidViewModel;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {

    @Binds
    @ActivityScope
    abstract AndroidViewModel viewModel(LoginViewModel loginViewModel);
}
