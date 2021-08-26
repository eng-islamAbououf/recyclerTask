package com.alahly.afshaapp.Adapter

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alahly.afshaapp.Models.DataModel
import com.alahly.afshaapp.MyRecycler
import com.alahly.afshaapp.R
import de.hdodenhof.circleimageview.CircleImageView
import android.view.View.SCALE_X as SCALE_X2
import de.hdodenhof.circleimageview.CircleImageView.SCALE_X as SCALE_X1

class DataAdapter(data:ArrayList<DataModel>, private var myRecycler: MyRecycler ,private var context: Context): RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    private var myData : ArrayList<DataModel> = data
    private var size:Int = data.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(myHolder: MyViewHolder, position: Int) {

        val dataModel: DataModel = myData.get(position)
        myHolder.myImage.setImageResource(dataModel.photo)
        myHolder.myImage.setOnClickListener {
            myRecycler.getPos(position)
            Toast.makeText(context,dataModel.name ,Toast.LENGTH_SHORT).show()
        }
        myHolder.myName.text = dataModel.name

    }

    override fun getItemCount(): Int {
        return size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val myImage : CircleImageView = itemView.findViewById(R.id.my_image)
        val myName : TextView = itemView.findViewById(R.id.my_name)
    }
}