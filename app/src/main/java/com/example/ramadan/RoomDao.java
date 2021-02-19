package com.example.ramadan;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;



import java.util.List;

@Dao
public interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleData(Model_Room cartdb);

    @Update
    void updateSingleData(Model_Room cartdb);

    @Delete
    void DeleteSingleData(Model_Room cartdb);

    @Query("SELECT * FROM ramadan")
    LiveData<List<Model_Room>> getAllData();

    @Query("DELETE FROM ramadan ")
    void deleteAll();



}
