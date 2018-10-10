package com.issam.drmas.sharewishises.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.issam.drmas.sharewishises.models.HomeModel
import android.view.View
import android.widget.TextView
import com.issam.drmas.sharewishises.R
import kotlinx.android.synthetic.main.activity_splash_screen.view.*
import kotlinx.android.synthetic.main.rwo_homeadpter_text.view.*

class HomeAdapter(val data: List<HomeModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {

        val TEXT = 1;
        val IMAGE=2;
        val VIDEO=3
    }

    override fun getItemCount(): Int {
        return data.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)

          when(viewType){
              TEXT-> return TextViewHolder(layoutInflater.inflate(R.layout.rwo_homeadpter_text, parent, false))
              IMAGE-> ImageViewHolder(layoutInflater.inflate(R.layout.rwo_homeadpter_image, parent, false))
              VIDEO-> VideoViewHolder(layoutInflater.inflate(R.layout.rwo_homeadpter_video, parent, false))
          }

        return object : RecyclerView.ViewHolder(View(parent?.context)){}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder?.itemViewType){

            TEXT-> showTextView(holder as TextViewHolder, position)
            IMAGE-> showImageView(holder as ImageViewHolder, position)
            VIDEO-> showVideoView(holder as VideoViewHolder, position)
        }
    }

    private fun showVideoView(videoViewHolder: VideoViewHolder, position: Int) {

    }

    private fun showImageView(imageViewHolder: ImageViewHolder, position: Int) {

    }

    private fun showTextView(textViewHolder: TextViewHolder, position: Int) {
        textViewHolder.textContent.setText(data[position].content)
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].viewType
    }

    class TextViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textContent: TextView = view.textViewRow
    }
    class ImageViewHolder(view: View) :RecyclerView.ViewHolder(view){}
    class VideoViewHolder(view: View) :RecyclerView.ViewHolder(view){}
}