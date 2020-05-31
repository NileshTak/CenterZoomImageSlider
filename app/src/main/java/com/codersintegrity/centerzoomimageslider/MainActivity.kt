package com.codersintegrity.centerzoomimageslider

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.custom_homescreen_fruits_product.view.*


class MainActivity : AppCompatActivity() {


    val colorList: MutableList<String> = ArrayList()
    val adapter = GroupAdapter<ViewHolder>()
    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById<RecyclerView>(R.id.rvOffer)

        dummyStrings()

        setUpRecyclerView()
    }


    private fun dummyStrings(): List<String>? {
        colorList.add("#354045")
        colorList.add("#20995E")
        colorList.add("#76FF03")
        colorList.add("#E26D1B")
        colorList.add("#911717")
        colorList.add("#9C27B0")
        colorList.add("#FFC107")
        colorList.add("#01579B")
        return colorList
    }

    private fun setUpRecyclerView() {

        for (i in 0..colorList.size-1) {
            adapter.add(InnerClass(colorList.get(i)))
        }
        rv.layoutManager = CenterZoomLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv.adapter = adapter
        rv.adapter!!.notifyDataSetChanged()
        rv.scheduleLayoutAnimation()

    }


    inner class InnerClass(var imgList: String) : Item<ViewHolder>() {
        override fun getLayout(): Int {
            return R.layout.custom_homescreen_fruits_product
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {

            viewHolder.itemView.ivProductImg.setBackgroundColor(Color.parseColor(imgList))

            }
        }
    }
