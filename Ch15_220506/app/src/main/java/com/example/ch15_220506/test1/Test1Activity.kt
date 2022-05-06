package com.example.ch15_220506.test1

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch15_220506.R
import com.example.ch15_220506.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    val table_name="USER_TB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val db=openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
        val sql="create table $table_name(" +
                "_id integer primary key autoincrement," +
                "name text not null," +
                "phone text)"
        try {
            db.execSQL(sql) // 테이블 생성됨
        }catch (e:Exception){
            e.printStackTrace()
        }

        binding.insertButton.setOnClickListener {
            // val sql="insert into $table_name(name, phone) values(?,?)"
            val name=binding.etName.text.toString()
            val phone=binding.etPhone.text.toString()
            // db.execSQL(sql, arrayOf(name, phone))

            val values = ContentValues()
            values.put("name", name)
            values.put("phone", phone)
            db.insert(table_name, null, values)
            binding.etName.setText("")
            binding.etPhone.setText("")
        }

        binding.queryButton.setOnClickListener {
            binding.tvResult.setText("")
            val sql="select * from $table_name"
            val cursor=db.rawQuery(sql, null)
            //val cursor=db.query(table_name, arrayOf("name","phone"), null, null, null, null, null)

            while(cursor.moveToNext()){
                val id=cursor.getInt(0)
                val name=cursor.getString(1)
                val phone=cursor.getString(2)
                // binding.tvResult.append("name:${name}, phone:${phone} \n")
                binding.tvResult.append("id:${id}, name:${name}, phone:${phone} \n")
            }
        }

        binding.updateButton.setOnClickListener {
            val name=binding.etName.text.toString()
            val phone=binding.etPhone.text.toString()
            val values=ContentValues()

            values.put("name", name)
            values.put("phone", phone)

            db.update(table_name, values, "_id=?", arrayOf("2"))
        }

        binding.deleteButton.setOnClickListener {
            db.delete(table_name, "_id=?", arrayOf("1"))
        }
    }
}