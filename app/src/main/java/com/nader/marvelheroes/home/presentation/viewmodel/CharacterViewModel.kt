package com.nader.marvelheroes.home.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nader.marvelheroes.core.model.DataStatus
import com.nader.marvelheroes.core.model.SingleEvent
import com.nader.marvelheroes.core.model.Status
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import com.nader.marvelheroes.home.domain.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    var status = MutableLiveData<SingleEvent<DataStatus>>()
    var character = MutableLiveData<List<CharacterInfoModel>>()
    var comics = MutableLiveData<List<CharacterInfoModel>>()
    var events = MutableLiveData<List<CharacterInfoModel>>()
    var series = MutableLiveData<List<CharacterInfoModel>>()
    var stories = MutableLiveData<List<CharacterInfoModel>>()

    fun getCharacter(characterId: String) {
        viewModelScope.launch {
            characterUseCase.getCharacters(characterId).collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            character.postValue(characterModel)
                        }
                    }
                    Status.LOADING -> {
                        status.postValue(SingleEvent(DataStatus.DataLoading))
                    }
                    Status.ERROR -> {
                        status.postValue(SingleEvent(DataStatus.DataError(response.exception)))
                    }
                }

            }
        }
    }

    fun getCharactersComics(characterId: String) {
        viewModelScope.launch {
            characterUseCase.getCharactersComics(characterId).collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            comics.postValue(characterModel)
                        }
                    }
                    Status.LOADING -> {
                        status.postValue(SingleEvent(DataStatus.DataLoading))
                    }
                    Status.ERROR -> {
                        status.postValue(SingleEvent(DataStatus.DataError(response.exception)))
                    }
                }

            }
        }
    }

    fun getCharactersEvents(characterId: String) {
        viewModelScope.launch {
            characterUseCase.getCharactersEvents(characterId).collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            events.postValue(characterModel)
                        }
                    }
                    Status.LOADING -> {
                        status.postValue(SingleEvent(DataStatus.DataLoading))
                    }
                    Status.ERROR -> {
                        status.postValue(SingleEvent(DataStatus.DataError(response.exception)))
                    }
                }

            }
        }
    }

    fun getCharactersSeries(characterId: String) {
        viewModelScope.launch {
            characterUseCase.getCharactersSeries(characterId).collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            series.postValue(characterModel)
                        }
                    }
                    Status.LOADING -> {
                        status.postValue(SingleEvent(DataStatus.DataLoading))
                    }
                    Status.ERROR -> {
                        status.postValue(SingleEvent(DataStatus.DataError(response.exception)))
                    }
                }

            }
        }
    }

    fun getCharactersStories(characterId: String) {
        viewModelScope.launch {
            characterUseCase.getCharactersStories(characterId).collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            stories.postValue(characterModel)
                        }
                    }
                    Status.LOADING -> {
                        status.postValue(SingleEvent(DataStatus.DataLoading))
                    }
                    Status.ERROR -> {
                        status.postValue(SingleEvent(DataStatus.DataError(response.exception)))
                    }
                }

            }
        }
    }
}