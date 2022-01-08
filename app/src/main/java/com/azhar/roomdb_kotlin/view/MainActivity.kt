package com.azhar.roomdb_kotlin.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.azhar.roomdb_kotlin.databinding.ActivityMainBinding
import com.azhar.roomdb_kotlin.model.Contact
import com.azhar.roomdb_kotlin.model.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        database = Room.databaseBuilder(applicationContext,
//        ContactDatabase::class.java,
//        "contactDB").build()

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch{
            database.contactDao().insertContact(Contact(0, "Sins", "012844751564"))
        }

        binding.helloWorldTvId.setOnClickListener{
            database.contactDao().getContact().observe(this, Observer{
                Log.d("db_test", it.toString())
            })
        }

    }
}