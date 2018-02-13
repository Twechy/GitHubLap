package com.programmic.twechy.githublap.Local_Repository.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.programmic.twechy.githublap.Local_Model.User.Local_User;

import java.util.List;

import io.reactivex.Single;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface Dao_User {

    @Query("SELECT * FROM users")
    Single<List<Local_User>> getAll();

    @Query("SELECT * FROM users WHERE mId IN (:userIds)")
    List<Local_User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE name LIKE :firstName AND "
            + "last_name LIKE :lastName LIMIT 1")
    Local_User findByName(String firstName, String lastName);

    @Insert(onConflict = REPLACE)
    List<Long> insertAll(List<Local_User> users);

    @Delete
    void delete(Local_User user);

}
