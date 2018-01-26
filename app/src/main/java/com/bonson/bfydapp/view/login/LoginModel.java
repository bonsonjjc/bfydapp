package com.bonson.bfydapp.view.login;

import com.bonson.bfydapp.model.bean.Result;
import com.bonson.bfydapp.model.bean.User;
import com.bonson.bfydapp.http.HttpUtils;
import com.bonson.library.utils.security.Md5Utils;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel {
    private HttpUtils httpUtils;

    @Inject
    public LoginModel(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public Observable<Result<User>> login(String mobile, String password) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA003");
        map.put("mobile", mobile);
        map.put("password", Md5Utils.toMD5(password));
        return httpUtils.post(map, User.class)
                .subscribeOn(Schedulers.io());
    }
}
