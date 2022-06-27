package com.talentomobile.marvel.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.coroutineScope
import androidx.paging.LoadState
import com.talentomobile.domain.comics.Comic
import com.talentomobile.marvel.databinding.FragmentComicsBinding
import com.talentomobile.marvel.ui.comics.adapter.ComicsAdapter
import com.talentomobile.marvel.ui.common.BaseFragment
import com.talentomobile.marvel.ui.common.EventObserver
import com.talentomobile.marvel.ui.common.extensions.visible
import com.talentomobile.marvel.ui.common.states.ListState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment : BaseFragment() {
    private lateinit var binding: FragmentComicsBinding
    private val viewModel: ComicsViewModel by viewModel()
    private val adapter = ComicsAdapter(::onItemSelected, ::onAdapterEmpty)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicsBinding.inflate(layoutInflater)
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

    private fun onItemSelected(item: Comic) {
        navigate(ComicsFragmentDirections.actionComicsFragmentToComicDetailFragment(item.id))
    }

    private fun onAdapterEmpty() {
        binding.includeEmptyList.mainLayout.visible(true)
    }
}