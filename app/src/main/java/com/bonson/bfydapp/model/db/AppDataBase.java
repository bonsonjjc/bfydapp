package com.bonson.bfydapp.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.bonson.bfydapp.model.bean.User;


/**
 * Created by zjw on 2018/1/2.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    public static AppDataBase build(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "db").allowMainThreadQueries().build();
    }
}
