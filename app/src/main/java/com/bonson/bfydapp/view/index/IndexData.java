package com.bonson.bfydapp.view.index;

import com.bonson.bfydapp.http.HttpUtils;
import com.bonson.bfydapp.model.bean.Heart;
import com.bonson.bfydapp.model.bean.Motion;
import com.bonson.bfydapp.model.bean.Result;
import com.bonson.bfydapp.model.bean.Sleep;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class IndexData {
    private HttpUtils httpUtils;

    @Inject
    public IndexData(HttpUtils httpUtils) {
        this.httpUtils = httpUtils;
    }

    public Observable<Result<List<Motion>>> motion(String device) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA015");
        map.put("feid", device);
        return httpUtils.postList(map, Motion.class)
                .subscribeOn(Schedulers.io());
    }

    public Observable<Result<List<Sleep>>> sleep(String device) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA013");
        map.put("feid", device);
        return httpUtils.postList(map, Sleep.class)
                .subscribeOn(Schedulers.io());
    }

    public Observable<Result<List<Heart>>> heart(String device) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("action", "CWA048");
        map.put("feid", device);
        return httpUtils.postList(map, Heart.class)
                .subscribeOn(Schedulers.io());
    }
}
