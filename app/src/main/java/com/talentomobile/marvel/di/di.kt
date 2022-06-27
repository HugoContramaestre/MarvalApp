package com.talentomobile.marvel.di

import android.app.Application
import com.talentomobile.data.repository.MainRepository
import com.talentomobile.data.source.RemoteDataSource
import com.talentomobile.marvel.BuildConfig
import com.talentomobile.marvel.data.api.ApiClient
import com.talentomobile.marvel.data.api.ApiRemoteDataSource
import com.talentomobile.marvel.ui.characters.CharacterDetailFragment
import com.talentomobile.marvel.ui.characters.CharacterDetailViewModel
import com.talentomobile.marvel.ui.characters.CharactersFragment
import com.talentomobile.marvel.ui.characters.CharactersViewModel
import com.talentomobile.marvel.ui.comics.ComicDetailFragment
import com.talentomobile.marvel.ui.comics.ComicDetailViewModel
import com.talentomobile.marvel.ui.comics.ComicsFragment
import com.talentomobile.marvel.ui.comics.ComicsViewModel
import com.talentomobile.marvel.ui.common.SharedViewModel
import com.talentomobile.usecases.characters.GetCharacterDetailUseCase
import com.talentomobile.usecases.characters.GetCharactersUseCase
import com.talentomobile.usecases.comic.GetComicDetailUseCase
import com.talentomobile.usecases.comic.GetComicsUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
        androidContext(this@initDI)
        modules(appModule, dataModule, scopesModule)
    }
}

private val appModule = module {
    factory<RemoteDataSource> { ApiRemoteDataSource(get()) }
    single(named("baseUrl")) { BuildConfig.BASE_URL }
    single { ApiClient(get(named("baseUrl"))).service }
}

private val dataModule = module {
    factory { MainRepository(get()) }
}

private val scopesModule = module {
    scope<CharactersFragment> {
        viewModel { CharactersViewModel(get()) }
        scoped { GetCharactersUseCase(get()) }
    }
    scope<CharacterDetailFragment> {
        viewModel { (characterId: Int) -> CharacterDetailViewModel(characterId, get()) }
        scoped { GetCharacterDetailUseCase(get()) }
    }
    scope<ComicsFragment> {
        viewModel { ComicsViewModel(get()) }
        scoped { GetComicsUseCase(get()) }
    }
    scope<ComicDetailFragment> {
        viewModel { (comicId: Int) -> ComicDetailViewModel(comicId, get()) }
        scoped { GetComicDetailUseCase(get()) }
    }

    viewModel { SharedViewModel() }
}