package com.example.ch9_220426.test4

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.*
import com.example.ch9_220426.R
import com.example.ch9_220426.databinding.ActivityTest4Binding
import com.example.ch9_220426.databinding.MovieItemBinding
import com.example.ch9_220426.test3.MyAdapter
import com.example.ch9_220426.test3.MyViewHolder

class Test4Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayPoster = arrayOf(R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10)
        val arrayTitle = arrayOf("써니","완득이","괴물","라디오 스타!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!","비열한 거리","왕의 남자","아일랜드",
            "웰컴 투 동막골","헬보이","백 투더 퓨처")
        val arrayRating = arrayOf(4.5f,4.3f,3.7f,5.0f,4.6f,4.3f,3.3f,3.8f,4.8f,4.1f)
        // 객체 배열로 만들어 보낼 수 있음
        // adapter에 만들어도 되지만 데이터를 adapter에 전달
        
        // 수평 리니어레이아웃
//        val layoutManager=LinearLayoutManager(this)
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        
        // 그리드 레이아웃
//        val layoutManager=GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

//        val layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView2.layoutManager= LinearLayoutManager(this) //layoutManager
        binding.recyclerView2.adapter= MyMovieAdapter(arrayPoster, arrayTitle, arrayRating)

        // 리사이클러 뷰를 꾸밀 때 사용
//        binding.recyclerView2.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        binding.recyclerView2.addItemDecoration(MyDecoration(this))
    }
}

class MyDecoration(val context:Context):RecyclerView.ItemDecoration(){
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(BitmapFactory.decodeResource(context.resources,R.drawable.stadium),0f,0f, null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index=parent.getChildAdapterPosition(view)+1
        if(index%3==0)
            outRect.set(10,10,10,60)
        else
            outRect.set(10,10,10,0)
        view.setBackgroundColor(Color.WHITE)
        ViewCompat.setElevation(view,30.0f)
    }
}

class MyMovieViewHolder(val binding:MovieItemBinding):RecyclerView.ViewHolder(binding.root)

class MyMovieAdapter(val arrayPoster:Array<Int>, val arrayTitle:Array<String>, val arrayRating:Array<Float>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyMovieViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as com.example.ch9_220426.test4.MyMovieViewHolder).binding
        binding.poster.setImageResource(arrayPoster[position])
        binding.tvTitle.text="제목 : ${arrayTitle[position]}"
        binding.tvRating.text="평점 : ${arrayRating[position]}"
    }

    override fun getItemCount(): Int {
        return arrayTitle.size
    }
}
