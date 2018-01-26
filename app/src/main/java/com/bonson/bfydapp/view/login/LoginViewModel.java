package com.bonson.bfydapp.view.login;

import android.app.Application;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.bonson.bfydapp.app.Route;
import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.model.bean.User;
import com.bonson.bfydapp.model.db.UserDao;
import com.bonson.resource.viewmodel.AndroidViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@ActivityScope
public class LoginViewModel extends AndroidViewModel {
    public final ObservableField<String> mobile = new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");
    public final ObservableBoolean enable = new ObservableBoolean(true);
    public final ObservableBoolean auto = new ObservableBoolean(false);

    @Inject
    LoginModel loginServer;

    @Inject
    UserDao userDao;

    @Inject
    public LoginViewModel(Application application, LoginModel loginServer) {
        super(application);
        this.loginServer = loginServer;
    }

    @Override
    protected void onCreate() {
        mobile.set("15659149106");
        password.set("123456");
    }

    public void login() {
        if (TextUtils.isEmpty(mobile.get())) {
            view.toast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            view.toast("请输入密码");
            return;
        }
        if (!isNetWork()) {
            view.toast("网络不可用");
            return;
        }
        view.load();
        enable.set(false);
        Disposable disposable = loginServer.login(mobile.get(), password.get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.dismiss();
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
                        User user = userDao.user();
                        if (user != null)
                            userDao.delete(user);
                        userDao.save(it.getBody());
                        User.user = it.getBody();
                        view.start(Route.index);
                        view.back();
                    }
                }, e -> {
                    view.dismiss();
                    view.toast("出错了");
                    e.printStackTrace();
                });
        compositeDisposable.add(disposable);
    }
}
