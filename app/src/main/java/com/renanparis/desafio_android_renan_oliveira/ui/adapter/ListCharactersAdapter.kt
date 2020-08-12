package com.renanparis.desafio_android_renan_oliveira.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.data.model.Character
import com.renanparis.desafio_android_renan_oliveira.extensions.setImage
import kotlinx.android.synthetic.main.item_list_characters.view.*

class ListCharactersAdapter (var onItemClickListener: (character: Character?) -> Unit = {}) :
    PagedListAdapter<Character, ListCharactersAdapter.ViewHolder>(diff) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_characters, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener {
            onItemClickListener(character)
        }
    }


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val nameText = item.item_name_character
        private val image = item.item_image_character


        fun bind(character: Character?) {
            nameText.text = character?.name
            image.setImage("${character?.thumbnail?.path}/standard_medium.${character?.thumbnail?.extension}")
        }
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }
}