package com.bonson.bfydapp.module;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.view.index.IndexActivity;
import com.bonson.bfydapp.view.index.IndexViewModel;
import com.bonson.bfydapp.view.register.RegisterViewModel;
import com.bonson.bfydapp.view.register.VerifyViewModel;
import com.bonson.resource.viewmodel.AndroidViewModel;

import dagger.Binds;
import dagger.Module;

/**
 * Created by zjw on 2017/12/29.
 */
@Module
public abstract class IndexModule {

    @Binds
    @ActivityScope
    abstract AndroidViewModel viewModel(IndexViewModel viewModel);
}
