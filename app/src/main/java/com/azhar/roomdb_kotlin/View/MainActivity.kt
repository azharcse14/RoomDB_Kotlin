package com.azhar.roomdb_kotlin.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.azhar.roomdb_kotlin.Model.Contact
import com.azhar.roomdb_kotlin.Model.ContactDatabase
import com.azhar.roomdb_kotlin.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,
        ContactDatabase::class.java,
        "contactDB").build()

        GlobalScope.launch{
            database.contactDao().insertContact(Contact(0, "Sins", "012844751564"))
        }
    }
}