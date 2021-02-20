package com.qq.myrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 验证场景一
 * 博客地址：https://juejin.cn/post/6930778648085528583#heading-4
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.setHasFixedSize(true)
        recyclerview.layoutParams.height = (resources.displayMetrics.density * 330).toInt()
        recyclerview.setItemViewCacheSize(0)
        recyclerview.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
            isItemPrefetchEnabled = false
        }
        val list:MutableList<String> = ArrayList()
        repeat(100){
            list.add("item $it")
        }
        recyclerview.adapter = MyAdapter(list)
    }

    inner class MyAdapter(val mStrings : MutableList<String>)
        : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

                Log.i("qq","RecyclerView 场景一 onCreateViewHolder");
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,false)
            return object : RecyclerView.ViewHolder(view){}
        }
        override fun getItemCount(): Int {
            return mStrings.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.i("qq","RecyclerView 场景一 onBindViewHolder $position");

            val textView = holder.itemView as TextView
            textView.layoutParams.height = (resources.displayMetrics.density * 60).toInt()
            textView.text = mStrings[position]
            ColorUtil.setPaintColor(textView,position)
        }

        override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

            Log.i("qq","RecyclerView 场景一 发生回收 "+(holder.itemView as TextView).text)
            super.onViewRecycled(holder)
        }

    }

    fun scroll20(view : View){

        recyclerview.scrollBy(0,(resources.displayMetrics.density * 20).toInt())
    }
    fun scroll40(view : View){
        recyclerview.scrollBy(0,(resources.displayMetrics.density * 40).toInt())
    }
    fun scroll80(view : View){
        recyclerview.scrollBy(0,(resources.displayMetrics.density * 80).toInt())
    }
}
