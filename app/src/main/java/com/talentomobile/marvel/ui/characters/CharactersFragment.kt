package com.talentomobile.marvel.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.coroutineScope
import androidx.paging.LoadState
import com.talentomobile.domain.common.Character
import com.talentomobile.marvel.databinding.FragmentCharactersBinding
import com.talentomobile.marvel.ui.characters.adapter.CharactersAdapter
import com.talentomobile.marvel.ui.common.BaseFragment
import com.talentomobile.marvel.ui.common.EventObserver
import com.talentomobile.marvel.ui.common.extensions.visible
import com.talentomobile.marvel.ui.common.states.ListState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val viewModel: CharactersViewModel by viewModel()
    private val adapter = CharactersAdapter(::onItemSelected, ::onAdapterEmpty)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!this::binding.isInitialized) {
            binding = FragmentCharactersBinding.inflate(layoutInflater)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModelObservers(viewModel)

        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        initAdapter()
    }

    private fun initListeners() {
        binding.includeRetry.retryButton.setOnClickListener {
            viewModel.getList()
        }
    }

    private fun initObservers() {
        viewModel.listState.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                ListState.Done -> {
                    binding.recyclerView.visible(true)
                    binding.recyclerView.suppressLayout(false)
                    binding.includeEmptyList.mainLayout.visible(false)
                    binding.includeRetry.mainLayout.visible(false)
                }
                ListState.Empty -> {
                    binding.recyclerView.visible(false)
                    binding.recyclerView.suppressLayout(false)
                    binding.includeEmptyList.mainLayout.visible(true)
                    binding.includeRetry.mainLayout.visible(false)
                    adapter.clearItems()
                }
                ListState.Error -> {
                    binding.recyclerView.visible(false)
                    binding.recyclerView.suppressLayout(false)
                    binding.includeEmptyList.mainLayout.visible(false)
                    binding.includeRetry.mainLayout.visible(true)
                    adapter.clearItems()
                }
                ListState.Loading -> {
                    adapter.showPlaceholders()
                    //sharedViewModel.handleLoading(true)
                    binding.recyclerView.visible(true)
                    binding.recyclerView.suppressLayout(true)
                    binding.includeEmptyList.mainLayout.visible(false)
                    binding.includeRetry.mainLayout.visible(false)
                }
            }
        })

        viewModel.list.observe(viewLifecycleOwner, EventObserver {
            adapter.submitList(it)
        })
    }

    private fun initAdapter() {
        with(binding) {
            recyclerView.adapter = adapter
        }
    }

    private fun onItemSelected(item: Character) {
        navigate(CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(item.id))
    }

    private fun onAdapterEmpty() {
        binding.includeEmptyList.mainLayout.visible(true)
    }

}