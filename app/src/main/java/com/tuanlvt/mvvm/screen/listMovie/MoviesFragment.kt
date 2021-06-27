package com.tuanlvt.mvvm.screen.listMovie

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.tuanlvt.mvvm.R
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.databinding.FragmentMoviesBinding
import com.tuanlvt.mvvm.screen.detail.DetailFragment
import com.tuanlvt.mvvm.screen.listMovie.adapter.MoviesAdapter
import com.tuanlvt.mvvm.utils.OnItemClickListener
import com.tuanlvt.mvvm.utils.base.BaseFragment
import com.tuanlvt.mvvm.utils.ext.addFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>(), OnItemClickListener<Movie> {

    private var adapter: MoviesAdapter? = null

    override val viewModel: MoviesViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentMoviesBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.lifecycleOwner = this.viewLifecycleOwner
        viewBinding.viewModel = viewModel
    }

    override fun bindView() {
        adapter = MoviesAdapter().apply {
            registerItemClickListener(this@MoviesFragment)
        }
        recyclerViewMovie.adapter = adapter
    }

    override fun onStop() {
        adapter?.unRegisterItemClickListener()
        super.onStop()
    }

    override fun registerLiveData() = with(viewModel) {
        super.registerLiveData()
        movies.observe(viewLifecycleOwner, Observer(::updateMovies))
    }

    override fun onItemViewClick(item: Movie, position: Int) {
        addFragment(R.id.layoutContainer, DetailFragment.newInstance(item))
    }

    private fun updateMovies(movies: MutableList<Movie>) {
        adapter?.updateData(movies)
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}
