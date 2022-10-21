package com.example.mylife2;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {LifePojo.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    public abstract LifeDao lifeDao();
    private static AppDatabase INSTANCE;
    public static AppDatabase getDbInstance(Context applicationContext){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(applicationContext.getApplicationContext(), AppDatabase.class,"DB_NAME")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
            Log.d(TAG, "getDbInstance: ");
        }
        return INSTANCE;
    }
}
