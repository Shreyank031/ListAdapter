package com.shrey.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shrey.listadapter.databinding.ItemViewBinding


class ProgrammingAdapter :
//pass DIFFUTIL object
    ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DIFFUTIL()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        // Inflate the item view layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        //It retrieves the ProgrammingItem object corresponding to the given position using the getItem method of the ListAdapter.
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ProgrammingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //ItemViewBinding.bind(itemView) initializes an ItemViewBinding instance by binding it to
        // the root view (itemView) of the layout inflated in onCreateViewHolder. This allows you to access
        // the views within the layout file using the ItemViewBinding instance.
        private val binding: ItemViewBinding = ItemViewBinding.bind(itemView)

        fun bind(item: ProgrammingItem) {
            // Bind data to the views using the ItemViewBinding instance
            binding.txtName.text = item.name
            binding.txtInitial.text = item.initial
        }
    }

    //We need to pass implementation of DiffUtil to compare 2 lists. So let's create a class to implement it
    class DIFFUTIL : DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            // Check if the items represent the same object in the list
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            // Check if the items represent the same object in the list
            return oldItem == newItem
        }
    }

}