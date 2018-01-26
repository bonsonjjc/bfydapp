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

public class VerifyModel {

    private HttpUtils httpUtils;

    @Inject
    public VerifyModel(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public Observable<Result<User>> verify(String mobile, String type) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA001");
        map.put("mobile", mobile);
        map.put("type", type);
        return httpUtils.post(map, User.class)
                .subscribeOn(Schedulers.io());
    }
}
