package com.bonson.bfydapp.di;

import android.app.Application;

import com.bonson.bfydapp.app.App;
import com.bonson.bfydapp.model.db.UserDao;
import com.google.gson.Gson;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;

/**
 * Created by zjw on 2017/12/29.
 */
@Singleton
@Component(modules = {
        AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<App> {
    UserDao userDao();

    OkHttpClient client();

    Gson gson();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
