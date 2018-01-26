package com.bonson.bfydapp.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bonson.bfydapp.model.bean.User;

@Dao
public interface UserDao {
    @Query("select * from user")
    User user();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long save(User user);

    @Delete
    int delete(User user);
}
