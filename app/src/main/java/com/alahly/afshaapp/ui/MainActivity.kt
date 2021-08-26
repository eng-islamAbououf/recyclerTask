package com.alahly.afshaapp.ui

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.alahly.afshaapp.Adapter.DataAdapter
import com.alahly.afshaapp.Models.DataModel
import com.alahly.afshaapp.MyRecycler
import com.alahly.afshaapp.R
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() ,MyRecycler ,View.OnClickListener {

    lateinit var myAdapter : DataAdapter
    lateinit var myRecyclerView: RecyclerView
    lateinit var myImageView: CircleImageView
    lateinit var linearLayout : LinearLayout
    var data : ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillData()
        fillData()

        initView()

        myImageView.setOnClickListener(this)
        linearLayout.setOnClickListener(this)
    }


    fun initView(){
        myImageView = findViewById(R.id.my_popup_image)
        linearLayout = findViewById(R.id.my_layout)
        myAdapter = DataAdapter(data,this ,this)
        myRecyclerView = findViewById(R.id.my_recycler)
        myRecyclerView.adapter = myAdapter
    }

    fun fillData(){
        data.add(DataModel("Ma3lol", R.drawable.maalol))
        data.add(DataModel("Solia", R.drawable.zaghlol))
        data.add(DataModel("Afsha", R.drawable.elqadia))
        data.add(DataModel("Afsha2 ", R.drawable.elqadiam))
        data.add(DataModel("El 3aw", R.drawable.elqadiamom))
        data.add(DataModel("El qadia momken ?", R.drawable.elqadiamomke))
        data.add(DataModel("Al tase3a", R.drawable.eltasaa))
    }

    override fun getPos(pos: Int) {
        myImageView.setImageResource(data.get(pos).photo)
        myImageView.visibility = ImageView.VISIBLE
        linearLayout.visibility = LinearLayout.VISIBLE
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.my_layout ,
            R.id.my_popup_image -> {
                myImageView.visibility = ImageView.GONE
                linearLayout.visibility = LinearLayout.GONE
            }
        }
    }

}