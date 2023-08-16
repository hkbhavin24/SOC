package com.example.soc.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.soc.Model_Class.Banner_Model_class

class BannerDatabase(context: Context?) : SQLiteOpenHelper(context, "banner.db", null, 1) {
    var context = context
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql =
            "CREATE TABLE banner (bannerid INTEGER PRIMARY KEY AUTOINCREMENT,banner_type INTEGER)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        fun insertdata(banner_type: Int) {
            var db = writableDatabase
            var value = ContentValues()
            value.put("banner_type", banner_type)

            var iss = db.insert("banner", null, value)
            if (iss.toInt() == -1) {
                Toast.makeText(context, "data is not inserted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "data inserted", Toast.LENGTH_SHORT).show()
            }

        }

        @SuppressLint("Range")
        fun showData(): ArrayList<Banner_Model_class> {

            var modellist = ArrayList<Banner_Model_class>()
            var db = readableDatabase
            var sql = "SELECT * FROM banner"
            var cursor = db.rawQuery(sql, null)
            cursor.moveToFirst()
            for (x in 0..cursor.count - 1) {
                var banner_id = cursor.getInt(0)
                var banner_type = cursor.getInt(cursor.run { getColumnIndex("banner_type") })
                var model = Banner_Model_class(banner_id, banner_type)
                modellist.add(model)
                cursor.moveToNext()
            }

            return modellist
        }

    }

    fun updatedata(bannerid: Int) {
        var db = writableDatabase
        var values = ContentValues()

        db.update("banner", values, "bannerid = $bannerid", null)
    }

    fun deleteData(bannerid: Int) {
        var db = writableDatabase
        db.delete("banner", "bannerid=$bannerid", null)
    }
}
