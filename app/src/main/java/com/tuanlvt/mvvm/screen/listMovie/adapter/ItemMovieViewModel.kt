package com.tuanlvt.mvvm.screen.listMovie.adapter

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.tuanlvt.mvvm.BR
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.utils.OnItemClickListener

class ItemMovieViewModel(private val itemClickListener: OnItemClickListener<Movie>? = null) : BaseObservable() {

    @Bindable
    var movie: Movie? = null

    fun setData(data: Movie?) {
        data?.let {
            movie = it
            notifyPropertyChanged(BR.movie)
        }
    }

    fun onItemClicked(view: View) {
        itemClickListener?.let { listener ->
            movie?.let {
                listener.onItemViewClick(it)
            }
        }
    }
}
