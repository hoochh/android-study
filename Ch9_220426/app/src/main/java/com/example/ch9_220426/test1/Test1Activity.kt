package com.example.ch9_220426.test1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.ch9_220426.R
import com.example.ch9_220426.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    lateinit var binding: ActivityTest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        
        registerForContextMenu(binding.button) //ContextMenu를 어디에 붙일 것인지
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater=this.menuInflater
        if(v==binding.button){
            inflater.inflate(R.menu.context_menu, menu) //context_menu에 menu를 붙임
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemTextRed -> {
                binding.textView2.setTextColor(Color.RED)
                return true
            }
            R.id.itemTextGreen -> {
                binding.textView2.setTextColor(Color.GREEN)
                return true
            }
            R.id.itemTextBlue -> {
                binding.textView2.setTextColor(Color.BLUE)
                return true
            }
        }

        return super.onContextItemSelected(item)
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var inflater=menuInflater
        inflater.inflate(R.menu.menu1, menu)
        var menuItem=menu?.findItem(R.id.menu_search)
        val searchView=menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener( object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO("Not yet implemented")
                binding.textView2.setText("onQueryTextChange: ${newText}")
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //TODO("Not yet implemented")
                binding.textView2.setText("onQueryTextSubmit: ${query}")
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemRed -> {
                binding.textView2.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemGreen -> {
                binding.textView2.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemBlue -> {
                binding.textView2.setBackgroundColor(Color.BLUE)
                return true
            }

            R.id.sizeEx -> {
                binding.textView2.setTextSize(binding.textView2.textSize*2)
                return true
            }
            R.id.sizeSub -> {
                binding.textView2.textSize=(binding.textView2.textSize*0.1f)
                return true
            }
        }

        return false // 위 메뉴 중 선택하지 않은 경우는 false 반환되어 아무것도 실행되지 않게
    }
}