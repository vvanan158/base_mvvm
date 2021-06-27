package com.tuanlvt.mvvm.screen.listMovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tuanlvt.mvvm.R
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.databinding.ItemLayoutMovieBinding
import com.tuanlvt.mvvm.utils.OnItemClickListener

class MoviesAdapter : ListAdapter<Movie, MoviesAdapter.ItemViewHolder>(MovieDiffCallBack()) {

    private val movies = mutableListOf<Movie>()
    private var itemClickListener: OnItemClickListener<Movie>? = null

    fun updateData(newData: MutableList<Movie>?) {
        newData?.let {
            val callBack = MoviesDiffUtil(movies, it)
            val diffResult = DiffUtil.calculateDiff(callBack)
            diffResult.dispatchUpdatesTo(this)
            movies.clear()
            movies.addAll(it)
        }
    }

    fun registerItemClickListener(onItemClickListener: OnItemClickListener<Movie>) {
        itemClickListener = onItemClickListener
    }

    fun unRegisterItemClickListener() {
        itemClickListener = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ItemViewHolder {
        val binding =
                DataBindingUtil.inflate<ItemLayoutMovieBinding>(LayoutInflater.from(parent.context), R.layout.item_layout_movie, parent, false)
        return ItemViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class ItemViewHolder(private val binding: ItemLayoutMovieBinding,
                               private val itemClickListener: OnItemClickListener<Movie>?,
                               private val itemViewModel: ItemMovieViewModel = ItemMovieViewModel(itemClickListener)) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = itemViewModel
        }

        fun bind(movie: Movie?) {
            itemViewModel.setData(movie)
            binding.executePendingBindings()
        }
    }

    class MovieDiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
