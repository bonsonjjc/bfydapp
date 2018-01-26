package com.bonson.bfydapp.di;

import android.app.Application;
import android.content.Context;

import com.bonson.bfydapp.app.Const;
import com.bonson.bfydapp.model.ApiServer;
import com.bonson.bfydapp.model.db.AppDataBase;
import com.bonson.bfydapp.model.db.UserDao;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zjw on 2017/12/29.
 */
@Module
abstract class AppModule {
    @Binds
    abstract Context bindContext(Application application);

    @Singleton
    @Provides
    static OkHttpClient client() {
        return new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor())
                .writeTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(1L, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    static Retrofit.Builder providesRetrofitBuilder(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(Const.PATH)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @Singleton
    @Provides
    static ApiServer apiServer(Retrofit.Builder builder) {
        Retrofit build = builder.baseUrl(Const.PATH).build();
        return build.create(ApiServer.class);
    }

    @Provides
    @Singleton
    static Gson providesGson() {
        return new Gson();
    }



    @Singleton
    @Provides
    static AppDataBase providesAppDataBase(Context context) {
        return AppDataBase.build(context);
    }

    @Singleton
    @Provides
    static UserDao userDao(AppDataBase dataBase) {
        return dataBase.userDao();
    }
}
