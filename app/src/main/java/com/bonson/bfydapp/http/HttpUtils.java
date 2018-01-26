package com.bonson.bfydapp.http;

import com.bonson.bfydapp.model.ApiServer;
import com.bonson.bfydapp.model.bean.Head;
import com.bonson.bfydapp.model.bean.Result;
import com.bonson.bfydapp.model.bean.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpUtils {
    public ApiServer apiServer;
    private Gson gson;

    @Inject
    public HttpUtils(ApiServer apiServer, Gson gson) {
        this.apiServer = apiServer;
        this.gson = gson;
    }

    public <T> Observable<Result<T>> post(Object bean, Class<T> cls) {
        return Observable.create(it -> {
            final Result<T> result = new Result<>();
            Call<JsonObject> call = apiServer.get(bean);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    JsonObject json = response.body();
                    if (json == null) {
                        result.setCode("-1");
                        result.setMsg("数据解析错误");
                        it.onNext(result);
                        it.onComplete();
                        return;
                    }
                    if (json.has("head")) {
                        JsonObject head = json.getAsJsonObject("head");
                        Head head1 = gson.fromJson(head, Head.class);
                        result.setCode(head1.getRtnCode());
                        result.setMsg(head1.getRtnMsg());
                    }
                    if ("0".equals(result.getCode())) {
                        if (json.has("body")) {
                            JsonElement body = json.get("body");
                            if (!body.isJsonArray()) {
                                T user = gson.fromJson(body, cls);
                                result.setBody(user);
                            }
                        }
                    }
                    it.onNext(result);
                    it.onComplete();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    t.printStackTrace();
                    if (t instanceof TimeoutException) {
                        result.setCode("-1");
                        result.setMsg("网络错误,连接超时");
                    } else {
                        result.setCode("-2");
                        result.setMsg("网络错误,无法连接服务器");
                    }
                    it.onNext(result);
                    it.onComplete();
                }
            });
            it.setDisposable(new Disposable() {
                @Override
                public void dispose() {
                    if (call.isExecuted()) {
                        call.cancel();
                    }
                }

                @Override
                public boolean isDisposed() {
                    return call.isExecuted();
                }
            });
        });
    }

    public <T> Observable<Result<List<T>>> postList(Object bean, Class<T> cls) {
        return Observable.create(it -> {
            final Result<List<T>> result = new Result<>();
            Call<JsonObject> call = apiServer.get(bean);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    JsonObject json = response.body();
                    if (json == null) {
                        result.setCode("-1");
                        result.setMsg("数据解析错误");
                        it.onNext(result);
                        it.onComplete();
                        return;
                    }
                    if (json.has("head")) {
                        JsonObject head = json.getAsJsonObject("head");
                        Head head1 = gson.fromJson(head, Head.class);
                        result.setCode(head1.getRtnCode());
                        result.setMsg(head1.getRtnMsg());
                    }
                    if ("0".equals(result.getCode())) {
                        if (json.has("body")) {
                            JsonElement body = json.get("body");
                            if (body.isJsonArray()) {
                                TypeToken<T> typeToken = TypeToken.get(cls);
                                T[] o = gson.fromJson(body, TypeToken.getArray(typeToken.getType()).getType());
                                result.setBody(Arrays.asList(o));
                            }
                        }
                    }
                    it.onNext(result);
                    it.onComplete();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    t.printStackTrace();
                    if (t instanceof TimeoutException) {
                        result.setCode("-1");
                        result.setMsg("网络错误,连接超时");
                    } else {
                        result.setCode("-2");
                        result.setMsg("网络错误,无法连接服务器");
                    }
                    it.onNext(result);
                    it.onComplete();
                }
            });
            it.setDisposable(new Disposable() {
                @Override
                public void dispose() {
                    if (call.isExecuted()) {
                        call.cancel();
                    }
                }

                @Override
                public boolean isDisposed() {
                    return call.isExecuted();
                }
            });
        });
    }


}


