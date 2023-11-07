package com.yusuf.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yusuf.quizapp.databinding.ActivityMainBinding
import com.yusuf.quizapp.db.FlagDao

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dao: FlagDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        dao = FlagDao(this@MainActivity)

        //insertDatas()

        setContentView(binding.root)
    }

    fun insertDatas (){
       dao.insertFlag("Türkiye","turkiye")
        dao.insertFlag("Almanya","almanya")
        dao.insertFlag("İtalya","italya")
        dao.insertFlag("Slovenya","slovenya")
        dao.insertFlag("Slovakya","slovakya")
        dao.insertFlag("Estonya","estonya")
        dao.insertFlag("Rusya","rusya")
        dao.insertFlag("Bulgaristan","bulgaristan")
        dao.insertFlag("Bosna Hersek","bosnahersek")
        dao.insertFlag("Fransa","fransa")
        dao.insertFlag("Hollanda","hollanda")
        dao.insertFlag("İspanya","ispanya")
        dao.insertFlag("Norveç","norvec")



    }

}