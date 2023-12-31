package com.yusuf.quizapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context): SQLiteOpenHelper(context,"flag",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table if not exists flag (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, flag_name TEXT,flag_url TEXT  )")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if  exists flag")
        onCreate(db)
    }
}