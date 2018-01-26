package com.bonson.bfydapp.view.forget;

import android.app.Application;
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
public class ForgetViewModel extends AndroidViewModel {
    public ObservableField<String> mobile = new ObservableField<>("");
    public ObservableField<String> verify = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    @Inject
    ForgetModel forgetModel;

    @Inject
    public ForgetViewModel(Application application) {
        super(application);
    }

    @Override
    protected void onCreate() {

    }

    public void forget() {
        if (TextUtils.isEmpty(mobile.get())) {
            view.toast("请输入手机号码");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            view.toast("请输入密码");
            return;
        }
        if (TextUtils.isEmpty(verify.get())) {
            view.toast("请输入验证码");
            return;
        }
        Disposable disposable = forgetModel.forget(mobile.get(), password.get(), verify.get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
                        view.start("");
                    }
                }, e -> {
                    view.toast("出错了");
                    e.printStackTrace();
                });
        compositeDisposable.add(disposable);
    }
}
