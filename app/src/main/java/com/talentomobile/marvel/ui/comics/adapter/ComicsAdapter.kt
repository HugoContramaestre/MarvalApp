package com.talentomobile.marvel.ui.comics.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.talentomobile.domain.comics.Comic
import com.talentomobile.marvel.R
import com.talentomobile.marvel.databinding.ItemComicBinding
import com.talentomobile.marvel.ui.common.EmptyListener
import com.talentomobile.marvel.ui.common.BaseListAdapter
import com.talentomobile.marvel.ui.common.extensions.bindingInflate

typealias OnComicItemSelected = (Comic) -> Unit

class ComicsAdapter (
    private val onItemSelected: OnComicItemSelected? = null,
    onEmptyListener: EmptyListener? = null,
): BaseListAdapter<Comic, ComicViewHolder>(
    diffCallback = UIMODEL_COMPARATOR,
    skeletonLayoutRes = R.layout.item_comic,
    onEmptyListener = onEmptyListener
) {
   companion object{
       private val UIMODEL_COMPARATOR = object: DiffUtil.ItemCallback<Comic>(){
           override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean = false
           override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean = false
       }
   }

    override fun getPlaceholderItem(): Comic {
        return Comic(
            id = -1,
            digitalId = null,
            title = null,
            issueNumber = null,
            variantDescription = null,
            description = null,
            modified = null,
            isbn = null,
            upc = null,
            diamondCode = null,
            ean = null,
            issn = null,
            format = null,
            pageCount = null,
            textObjects = emptyList(),
            resourceUri = null,
            urls = emptyList(),
            series = null,
            variants = emptyList(),
            collections = emptyList(),
            collectedIssues = emptyList(),
            dates = emptyList(),
            prices = emptyList(),
            thumbnail = null,
            images = emptyList(),
            creators = null,
            characters = null,
            stories = null,
            events = null
        )
    }

    override fun onCreateNormalViewHolder(parent: ViewGroup): ComicViewHolder =
        ComicViewHolder(parent.bindingInflate(R.layout.item_comic, false))

    override fun onBindNormalViewHolder(holder: ComicViewHolder, position: Int, item: Comic) {
        holder.dataBinding.item = item
        holder.dataBinding.root.setOnClickListener { onItemSelected?.invoke(item) }
    }
}

class ComicViewHolder(val dataBinding: ItemComicBinding) :
        RecyclerView.ViewHolder(dataBinding.root)