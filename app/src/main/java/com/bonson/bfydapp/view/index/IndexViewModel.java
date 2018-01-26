package com.bonson.bfydapp.view.index;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.bonson.bfydapp.di.ActivityScope;
import com.bonson.bfydapp.model.bean.Heart;
import com.bonson.bfydapp.model.bean.Menu;
import com.bonson.bfydapp.model.bean.Motion;
import com.bonson.bfydapp.model.bean.Sleep;
import com.bonson.bfydapp.model.bean.User;
import com.bonson.bfydapp.utils.TablesUtils;
import com.bonson.resource.viewmodel.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@ActivityScope
public class IndexViewModel extends AndroidViewModel {
    public final ObservableInt mode = new ObservableInt(1);
    public final ObservableInt type = new ObservableInt(1);

    public final ObservableList<Menu> menus = new ObservableArrayList<>();
    public final ObservableList<Table> tables = new ObservableArrayList<>();

    private final List<Motion> motions = new ArrayList<>();
    private final List<Sleep> sleeps = new ArrayList<>();
    private final List<Heart> hearts = new ArrayList<>();

    private User user;

    @Inject
    IndexData indexData;

    @Inject
    public IndexViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCreate() {
        user = User.user;
        for (Menu menu : user.getMenu()) {
            switch (menu.getFname()) {
                case "消息中心":
                    menu.setIcon("ico_xxtx");
                    break;
                case "运动圈":
                    menu.setIcon("ico_ydq");
                    break;
                case "我的亲友":
                    menu.setIcon("ico_wdqy");
                    break;
                default:
                    menu.setIcon("ico_sz");
            }
        }
        menus.addAll(user.getMenu());
        motion();
    }

    public void motion() {
        type.set(1);
        if (!isNetWork()) {
            view.toast("网络不可用");
        }
        if (!motions.isEmpty()) {
            tables.clear();
            for (Motion motion : motions) {
                tables.add(TablesUtils.motion(motion));
            }
            return;
        }
        view.load();
        Disposable disposable = indexData.motion("305")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.dismiss();
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
                        motions.clear();
                        motions.addAll(it.getBody());
                        tables.clear();
                        for (Motion motion : motions) {
                            tables.add(TablesUtils.motion(motion));
                        }
                    }
                }, e -> {
                    view.dismiss();
                    e.printStackTrace();
                });
        compositeDisposable.add(disposable);
    }

    public void sleep() {
        type.set(2);
        if (!isNetWork()) {
            view.toast("网络不可用");
        }
        if (!sleeps.isEmpty()) {
            tables.clear();
            for (Sleep motion : sleeps) {
                tables.add(TablesUtils.sleep(motion));
            }
            return;
        }
        Disposable disposable = indexData.sleep("305")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.dismiss();
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
                        sleeps.clear();
                        sleeps.addAll(it.getBody());
                        tables.clear();
                        for (Sleep sleep : sleeps) {
                            tables.add(TablesUtils.sleep(sleep));
                        }
                    }
                }, e -> {
                    view.dismiss();
                    e.printStackTrace();
                });
        compositeDisposable.add(disposable);
    }

    public void heart() {
        type.set(3);
        if (!isNetWork()) {
            view.toast("网络不可用");
        }
        if (!isNetWork()) {
            view.toast("网络不可用");
        }
        if (!hearts.isEmpty()) {
            tables.clear();
            for (Heart heart : hearts) {
                tables.add(TablesUtils.heart(heart));
            }
            return;
        }
        Disposable disposable = indexData.heart("305")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    view.dismiss();
                    view.toast(it.getMsg());
                    if (it.getCode().equals("0")) {
                        hearts.clear();
                        hearts.addAll(it.getBody());
                        tables.clear();
                        if (!hearts.isEmpty()) {
                            for (Heart heart : hearts) {
                                tables.add(TablesUtils.heart(heart));
                            }
                            return;
                        }
                    }
                }, e -> {
                    view.dismiss();
                    e.printStackTrace();
                });
        compositeDisposable.add(disposable);
    }
}
