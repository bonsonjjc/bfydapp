package com.bonson.bfydapp.view.register;

import android.app.Application;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.resource.viewmodel.AndroidViewModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by zjw on 2017/12/29.
 */
@ActivityScope
public class RegisterViewModel extends AndroidViewModel {
    public final ObservableField<String> mobile = new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");
    public final ObservableField<String> verify = new ObservableField<>("");
    public final ObservableBoolean isAgree = new ObservableBoolean(false);

    @Inject
    RegisterModel registerModel;

    @Inject
    public RegisterViewModel(Application application) {
        super(application);
    }

    @Override
    protected void onCreate() {

    }

    public void register() {
        if (TextUtils.isEmpty(mobile.get())) {
            view.toast("请输入手机号码");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            view.toast("请输入手机密码");
            return;
        }
        if (TextUtils.isEmpty(verify.get())) {
            view.toast("请输入手机验证码");
            return;
        }
        if (!isAgree.get()) {
            view.toast("您还未同意用户协议");
            return;
        }
        if (!isNetWork()) {
            view.toast("网络不可用");
            return;
        }
        view.load();
        Disposable disposable = registerModel.register(mobile.get(), password.get(), verify.get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.dismiss();
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
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
