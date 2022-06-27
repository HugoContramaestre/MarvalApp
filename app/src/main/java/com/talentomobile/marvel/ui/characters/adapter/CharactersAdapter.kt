package com.talentomobile.marvel.ui.characters.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.talentomobile.domain.common.Character
import com.talentomobile.marvel.R
import com.talentomobile.marvel.databinding.ItemCharacterBinding
import com.talentomobile.marvel.ui.common.EmptyListener
import com.talentomobile.marvel.ui.common.BaseListAdapter
import com.talentomobile.marvel.ui.common.extensions.bindingInflate

typealias OnCharacterItemSelected = (Character) -> Unit

class CharactersAdapter(
    private val onItemSelected: OnCharacterItemSelected? = null,
    onEmptyListener: EmptyListener? = null,
): BaseListAdapter<Character, CharactersViewHolder>(
    diffCallback = UIMODEL_COMPARATOR,
    skeletonLayoutRes = R.layout.item_character,
    onEmptyListener = onEmptyListener,
) {

    override fun onBindNormalViewHolder(
        holder: CharactersViewHolder,
        position: Int,
        item: Character
    ) {
        holder.dataBinding.item = item
        holder.dataBinding.root.setOnClickListener { onItemSelected?.invoke(item) }
    }

    companion object {
        private val UIMODEL_COMPARATOR = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = false
            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = false
        }
    }

    override fun getPlaceholderItem(): Character {
        return Character(
            id = -1,
            name = null,
            description = null,
            modified = null,
            resourceUri = null,
            urls = emptyList(),
            thumbnail = null,
            comics = null,
            stories = null,
            events = null,
            series = null
        )
    }

    override fun onCreateNormalViewHolder(parent: ViewGroup): CharactersViewHolder =
        CharactersViewHolder(parent.bindingInflate(R.layout.item_character, false))

}

class CharactersViewHolder(val dataBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(dataBinding.root)