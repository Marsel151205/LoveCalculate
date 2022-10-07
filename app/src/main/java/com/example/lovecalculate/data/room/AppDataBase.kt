package com.example.lovecalculate.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculate.data.dao.Dao
import com.example.lovecalculate.data.models.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun loveDao(): Dao

}