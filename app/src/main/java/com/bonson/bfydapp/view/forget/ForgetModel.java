package com.bonson.bfydapp.view.forget;

import com.bonson.bfydapp.http.HttpUtils;
import com.bonson.bfydapp.model.bean.Result;
import com.bonson.bfydapp.model.bean.User;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ForgetModel {

    private HttpUtils httpUtils;

    @Inject
    public ForgetModel(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public Observable<Result<User>> forget(String mobile, String password, String verify) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA005");
        map.put("mobile", mobile);
        map.put("password", password);
        map.put("verify", verify);
        return httpUtils.post(map, User.class)
                .subscribeOn(Schedulers.io());
    }
}
