package com.example.ch15_220509

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ch15_220509.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =when(item.itemId){
        R.id.menu_add_save->{
            val inputData=binding.addEditView.text.toString()
            val db=MyDBHelper(this).writableDatabase
            db.execSQL("insert into TODO_TB(todo) values(?)", arrayOf<String>(inputData))
            db.close() //DB에 insert

            val intent= intent //현재 activity가 가진 intent
            intent.putExtra("result", inputData)
            setResult(Activity.RESULT_OK, intent)
            finish() // 데이터를 받아감
            true
        }
        else-> true
    }
}