package com.talentomobile.marvel.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talentomobile.marvel.databinding.FragmentCharacterDetailBinding
import com.talentomobile.marvel.ui.common.BaseFragment
import com.talentomobile.marvel.ui.common.bindContentImage
import com.talentomobile.marvel.ui.common.extensions.EXTRA_CHARACTER_ID
import com.talentomobile.marvel.ui.common.extensions.visible
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment: BaseFragment() {
    private lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel: CharacterDetailViewModel by viewModel {
        parametersOf(arguments?.getInt(EXTRA_CHARACTER_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
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
            binding.title.text = it.name
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