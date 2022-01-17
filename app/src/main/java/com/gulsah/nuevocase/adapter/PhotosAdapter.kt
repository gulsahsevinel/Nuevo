package com.gulsah.nuevocase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.nuevocase.databinding.RowPhotosBinding
import com.gulsah.nuevocase.model.Photos
import com.gulsah.nuevocase.view.FirstViewFragmentDirections
import com.squareup.picasso.Picasso

class PhotosAdapter(private var photosList: List<Photos>) :
    RecyclerView.Adapter<PhotosAdapter.PhotosCardHolder>() {

    inner class PhotosCardHolder(rowPhotosBinding: RowPhotosBinding) :
        RecyclerView.ViewHolder(rowPhotosBinding.root) {
        var cardView: RowPhotosBinding = rowPhotosBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosCardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = RowPhotosBinding.inflate(layoutInflater, parent, false)
        return PhotosCardHolder(layout)
    }

    override fun onBindViewHolder(holder: PhotosCardHolder, position: Int) {
        val photo = photosList[position + 1]
        holder.cardView.tvTitle.text = photo.title
        Picasso.get().load(photo.thumbnailUrl).into(holder.cardView.ivPhoto)
        holder.cardView.cardViewList.setOnClickListener {
            val transition = FirstViewFragmentDirections.firstViewFragmentToSecondViewFragment(photo)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int = photosList.size
}