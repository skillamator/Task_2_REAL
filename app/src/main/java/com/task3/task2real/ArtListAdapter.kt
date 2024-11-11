package com.task3.task2real

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.task3.task2real.databinding.ListItemArtBinding

class ArtHolder(
   private val binding: ListItemArtBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(art: Art) {
        binding.artTitle.text = art.title
        binding.artDate.text = art.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${art.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.artSolved.visibility = if (art.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}


class ArtListAdapter(
    private val arts: List<Art>) :RecyclerView.Adapter<ArtHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemArtBinding.inflate(inflater, parent, false)
        return ArtHolder(binding)
    }


    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        val art = arts[position]
        holder.bind(art)
    }

    override fun getItemCount() = arts.size

}