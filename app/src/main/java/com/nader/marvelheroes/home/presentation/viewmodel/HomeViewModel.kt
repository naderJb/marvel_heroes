package com.nader.marvelheroes.home.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nader.marvelheroes.core.model.DataStatus
import com.nader.marvelheroes.core.model.SingleEvent
import com.nader.marvelheroes.core.model.Status
import com.nader.marvelheroes.home.data.model.CharacterModel
import com.nader.marvelheroes.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    var status = MutableLiveData<SingleEvent<DataStatus>>()
    var characters = MutableLiveData<List<CharacterModel>>()

    fun getCategories() {
        viewModelScope.launch {
            homeUseCase.getAllCharacters().collect { response ->
                when (response.status) {
                    Status.SUCCESS -> {
                        status.postValue(SingleEvent(DataStatus.DataLoaded))
                        response.data?.data?.results?.let { characterModel ->
                            characters.postValue(characterModel)
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