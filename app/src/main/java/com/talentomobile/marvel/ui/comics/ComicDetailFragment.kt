package com.talentomobile.marvel.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talentomobile.marvel.databinding.FragmentComicDetailBinding
import com.talentomobile.marvel.ui.common.BaseFragment
import com.talentomobile.marvel.ui.common.bindContentImage
import com.talentomobile.marvel.ui.common.extensions.EXTRA_COMIC_ID
import com.talentomobile.marvel.ui.common.extensions.visible
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ComicDetailFragment: BaseFragment() {
    private lateinit var binding: FragmentComicDetailBinding

    private val viewModel: ComicDetailViewModel by viewModel {
        parametersOf(arguments?.getInt(EXTRA_COMIC_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModelObservers(viewModel)

        initViews()
        initListener()
        initObservers()
    }

    private fun initViews(){

    }

    private fun initListener(){
        binding.includeRetry.retryButton.setOnClickListener {
            viewModel.getDetail()
        }
    }

    private fun initObservers(){
        viewModel.detail.observe(viewLifecycleOwner) {
            binding.includeRetry.mainLayout.visible(false)
            binding.includeEmptyList.mainLayout.visible(false)
            binding.image.bindContentImage(it.thumbnail?.getLargeStandard())
            binding.title.text = it.title
            binding.title2.text = it.description
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.includeRetry.mainLayout.visible(true)
            binding.image.visible(false)
            binding.title.visible(false)
            binding.title2.visible(false)
            binding.title3.visible(false)
        }
    }
}