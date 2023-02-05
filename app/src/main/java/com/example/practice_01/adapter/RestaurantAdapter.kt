package com.example.practice_01.adapter

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.practice_01.Items
import com.example.practice_01.R
import com.example.practice_01.databinding.RestaurantItemBinding

class RestaurantAdapter(val clickListener: (Items) -> Unit) : ListAdapter<Items, RestaurantAdapter.ViewHolder>(
    diffUtil
) {

    inner class ViewHolder(var binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Items) = with(binding) {
            foodNameTextView.text = restaurant.PTR_COM_NM
            titleTextView.text = restaurant.PTR_PROM_TITLE
            gradeTextView.text = restaurant.RVW_STAR.toString()
            reviewCountTextView.text = restaurant.PTR_REVIEW_CNT.toString()

            if (restaurant.PTR_PRO_IMG.isNotEmpty()) {
                Glide.with(thumbnailImageView)
                    .load(restaurant.PTR_PRO_IMG)
                    .transform(CenterCrop(), RoundedCorners(dpToPx(thumbnailImageView.context, 19)))
                    .into(thumbnailImageView)
            }

            binding.root.setOnClickListener {
                clickListener(restaurant)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RestaurantItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(
                oldItem: Items,
                newItem: Items
            ): Boolean {
                return oldItem.PTR_ID == newItem.PTR_ID
            }

            override fun areContentsTheSame(
                oldItem: Items,
                newItem: Items
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}