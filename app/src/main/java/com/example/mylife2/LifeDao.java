package com.example.mylife2;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LifeDao {
    @Query("SELECT * FROM LifePojo")
    List<LifePojo> getAllInfo();

    @Insert
            void insertLife(LifePojo... lifes);
}
