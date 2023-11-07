package com.yusuf.quizapp.db

import android.content.ContentValues
import android.content.Context

class FlagDao(context: Context) {
    private val dbHelper = DbHelper(context)

    fun insertFlag(
        flagName: String,
        flagUrl:String,

    ){
        val dbx = dbHelper.writableDatabase
        val values = ContentValues()

        values.put("flag_name",flagName)
        values.put("flag_url",flagUrl)


        dbx.insertOrThrow("flag",null,values)
        dbx.close()
    }

    fun get5Flag():ArrayList<Flag>{

        val flagList = ArrayList<Flag>()
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM flag ORDER BY RANDOM() LIMIT 5",null)

        while (cursor.moveToNext()){
            val flag = Flag(cursor.getInt(cursor.getColumnIndex("id"))
                    ,cursor.getString(cursor.getColumnIndex("flag_name")),
                cursor.getString(cursor.getColumnIndex("flag_url")))

            flagList.add(flag)
        }
        return flagList
    }

    fun get3Flag(flag_id:Int):ArrayList<Flag>{

        val flagList = ArrayList<Flag>()
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM flag WHERE id != $flag_id ORDER BY RANDOM() LIMIT 3",null)

        while (cursor.moveToNext()){
            val flag = Flag(cursor.getInt(cursor.getColumnIndex("id"))
                ,cursor.getString(cursor.getColumnIndex("flag_name")),
                cursor.getString(cursor.getColumnIndex("flag_url")))

            flagList.add(flag)
        }
        return flagList
    }
}