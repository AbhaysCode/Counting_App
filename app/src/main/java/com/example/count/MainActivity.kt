package com.example.count

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerView:RecyclerView
class MainActivity : AppCompatActivity(), NumItemsClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CountingAdapter(fetchData(),this)
    }

    private fun fetchData(): ArrayList<Int> {
        var num = ArrayList<Int>()
        for (i in 0 until 100){
            num.add(i)
        }
        return num
    }

    override fun NumItemListener(item: Number) {
        Toast.makeText(this,"Item Clicked is $item",Toast.LENGTH_SHORT).show()
    }
}