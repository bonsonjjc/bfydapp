package com.bonson.bfydapp.di;

import com.bonson.bfydapp.module.ForgetModule;
import com.bonson.bfydapp.module.IndexModule;
import com.bonson.bfydapp.module.LoginModule;
import com.bonson.bfydapp.module.RegisterModule;
import com.bonson.bfydapp.view.forget.ForgetActivity;
import com.bonson.bfydapp.view.index.IndexActivity;
import com.bonson.bfydapp.view.login.LoginActivity;
import com.bonson.bfydapp.view.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = ForgetModule.class)
    abstract ForgetActivity forgetActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = IndexModule.class)
    abstract IndexActivity indexActivity();
}
