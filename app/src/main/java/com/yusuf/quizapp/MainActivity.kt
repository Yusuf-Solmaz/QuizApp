package com.yusuf.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.yusuf.quizapp.databinding.ActivityMainBinding
import com.yusuf.quizapp.db.DbHelper
import com.yusuf.quizapp.db.Flag
import com.yusuf.quizapp.db.FlagDao

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        copyDb()

        setContentView(binding.root)
    }

    fun copyDb(){
        val copyHelper = DatabaseCopyHelper(this@MainActivity)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }
        catch (e: Exception){
            e.localizedMessage?.let { Log.e("DB ERROR", it) }
        }
    }
}