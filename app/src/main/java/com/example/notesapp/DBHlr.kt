package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlr(context: Context? ) : SQLiteOpenHelper(context, "details.db", null, 1) {
    val sql :SQLiteDatabase = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table notes(Note text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedata(s1:String){
        val cv = ContentValues()
        cv.put("Note",s1)
        sql.insert("notes",null,cv)
    }
}