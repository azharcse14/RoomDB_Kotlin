package com.azhar.roomdb_kotlin.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.azhar.roomdb_kotlin.model.util.Convertors

@Database(entities = [Contact::class], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class ContactDatabase: RoomDatabase() {


    abstract fun contactDao():ContactDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ContactDatabase::class.java,
                    "contactDB").build()
                }
            }

            return INSTANCE!!
        }
    }
}