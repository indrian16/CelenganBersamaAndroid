package io.indrian.celenganbersama.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.indrian.celenganbersama.R
import io.indrian.celenganbersama.data.models.Saving

class SavingAdapter : RecyclerView.Adapter<SavingAdapter.ViewHolder>() {

    private val savings: List<Saving> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.saving_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.bind(savings[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(saving: Saving) {}
    }
}