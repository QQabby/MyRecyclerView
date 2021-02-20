package com.qq.myrecyclerview

import android.os.Build.VERSION_CODES.P
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
 * 验证场景二
 *
 */
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerview.setHasFixedSize(true)
        recyclerview.layoutParams.height = (resources.displayMetrics.density * 340).toInt()
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

                Log.i("qq","RecyclerView 场景二 onCreateViewHolder");
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,false)
            return object : RecyclerView.ViewHolder(view){}
        }
        override fun getItemCount(): Int {
            return mStrings.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.i("qq","RecyclerView 场景二 onBindViewHolder $position");

            val textView = holder.itemView as TextView
            //设置RV中第一个item高度为30px,其它都为60px
            if(position == 0){
                textView.layoutParams.height = (resources.displayMetrics.density * 30).toInt()
            }else{
                textView.layoutParams.height = (resources.displayMetrics.density * 60).toInt()
            }

            textView.text = mStrings[position]
            ColorUtil.setPaintColor(textView,position)
        }

        override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

            Log.i("qq","RecyclerView 场景二 发生回收 "+(holder.itemView as TextView).text)
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
