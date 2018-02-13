package com.programmic.twechy.githublap.Local_Repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.programmic.twechy.githublap.Local_Model.Login.Local_LoginUser;
import com.programmic.twechy.githublap.Local_Model.User.Local_User;
import com.programmic.twechy.githublap.Local_Repository.Dao.Dao_User;

@Database(entities = {Local_User.class, Local_LoginUser.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase _INSTANCE;

    public static UserDatabase getINSTANCE(Context context) {

        if (_INSTANCE == null) {

            _INSTANCE = Room.databaseBuilder(context, UserDatabase.class,
                    "cars.db").build();
        }
        return _INSTANCE;
    }

    public static void destroyDatabase() {
        if (_INSTANCE != null) {
            _INSTANCE = null;
        }
    }

    public abstract Dao_User userDao();
}
