package com.tuanlvt.mvvm.screen.detail

import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.tuanlvt.mvvm.data.model.Movie
import com.tuanlvt.mvvm.databinding.FragmentDetailBinding
import com.tuanlvt.mvvm.utils.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentDetailBinding.inflate(inflater)

    override fun setUpView() {
        viewBinding.lifecycleOwner = this.viewLifecycleOwner
        viewBinding.viewModel = viewModel
        buttonImageBack.setOnClickListener { parentFragmentManager.popBackStack() }
    }

    override fun bindView() {
        arguments?.run {
            val data: Movie? = getParcelable(ARGUMENT_MOVIE)
            viewModel.setMovie(data)
        }
    }

    override fun registerLiveData() {}

    companion object {
        const val ARGUMENT_MOVIE = "ARGUMENT_MOVIE"

        fun newInstance(movie: Movie?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_MOVIE to movie)
        }
    }
}
