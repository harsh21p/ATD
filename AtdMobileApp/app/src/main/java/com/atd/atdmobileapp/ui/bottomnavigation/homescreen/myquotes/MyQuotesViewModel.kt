package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atd.atdmobileapp.models.myquotes.*

import com.atd.atdmobileapp.repository.MyQuotesRepository
import com.atd.atdmobileapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MyQuotesViewModel @Inject constructor(private val myQuotesRepository: MyQuotesRepository) :ViewModel() {


    val myQuotesResponseLiveData : LiveData<NetworkResult<MyQuotesData>>
        get() = myQuotesRepository.myQuotesLiveData
    fun getMyQuotess(myQuotesRequest: MyQuotesRequest){
        viewModelScope.launch {
            myQuotesRepository.getMyQuotes(myQuotesRequest)
        }
    }

    val quotesStatusLiveData : LiveData<NetworkResult<QuoteStatusResponse>>
    get() = myQuotesRepository.quotesStatusLiveData

    fun getRetailQuoteStatus(locationNumber : String){
        viewModelScope.launch {
            myQuotesRepository.getRetailQuoteStatus(locationNumber)
        }
    }

    val createQuoteLiveData : LiveData<NetworkResult<CreateRetailQuoteResponse>>
        get() = myQuotesRepository.createQuotesLiveData

    fun createRetailQuote(createQuoteRequest: CreateQuoteRequest){
        viewModelScope.launch {
            myQuotesRepository.createRetailQuote(createQuoteRequest)
        }
    }

    val updateQuoteLiveData : LiveData<NetworkResult<MyQuotesData>>
        get() = myQuotesRepository.updateQuoteLiveData

    fun updateRetailQuote(updateRequestBody: UpdateRequestBody){
        viewModelScope.launch {
            myQuotesRepository.updateRetailQuote(updateRequestBody)
        }
    }
}