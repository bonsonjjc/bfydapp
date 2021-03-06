package com.bonson.bfydapp.view.register;

import com.bonson.bfydapp.http.HttpUtils;
import com.bonson.bfydapp.model.bean.Result;
import com.bonson.bfydapp.model.bean.User;
import com.bonson.library.utils.security.Md5Utils;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel {

    private HttpUtils httpUtils;

    @Inject
    public RegisterModel(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public Observable<Result<User>> register(String mobile, String password, String verify) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA002");
        map.put("mobile", mobile);
        map.put("password", Md5Utils.toMD5(password));
        map.put("verify", verify);
        return httpUtils.post(map, User.class)
                .subscribeOn(Schedulers.io());
    }
}
