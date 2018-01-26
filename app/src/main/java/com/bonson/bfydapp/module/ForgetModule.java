package com.bonson.bfydapp.module;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.view.forget.ForgetViewModel;
import com.bonson.bfydapp.view.register.VerifyViewModel;
import com.bonson.resource.viewmodel.AndroidViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by zjw on 2017/12/29.
 */

@Module
public abstract class ForgetModule {
    @Binds
    @ActivityScope
    abstract AndroidViewModel viewModel(ForgetViewModel viewModel);

    @Binds
    @ActivityScope
    abstract AndroidViewModel verifyModel(VerifyViewModel viewModel);
}
