package com.atd.atdmobileapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atd.atdmobileapp.api.MyQuotesApi
import com.atd.atdmobileapp.models.myquotes.*
import com.atd.atdmobileapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class MyQuotesRepository @Inject constructor(private val myQuotesApi: MyQuotesApi) {

    private val _QuotesLiveData = MutableLiveData<NetworkResult<MyQuotesData>>()
    val myQuotesLiveData :LiveData<NetworkResult<MyQuotesData>>
    get() = _QuotesLiveData

    val quotesStatusLiveData = MutableLiveData<NetworkResult<QuoteStatusResponse>>()
    val createQuotesLiveData = MutableLiveData<NetworkResult<CreateRetailQuoteResponse>>()
    val updateQuoteLiveData = MutableLiveData<NetworkResult<MyQuotesData>>()

    suspend fun getMyQuotes(myQuotesRequest: MyQuotesRequest){
        _QuotesLiveData.postValue(NetworkResult.Loading())
        val response =myQuotesApi.getMyQuotess(myQuotesRequest)
        handleResponse(response)
    }

    private fun handleResponse(response: Response<MyQuotesData>) {
        if (response.isSuccessful && response.body() != null) {
            _QuotesLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            val errorObj = response.message()
            _QuotesLiveData.postValue(NetworkResult.Error(errorObj.toString()))
        } else {
            _QuotesLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun getRetailQuoteStatus(locationNumber: String){
        quotesStatusLiveData.postValue(NetworkResult.Loading())
        val response = myQuotesApi.getRetailQuoteStatus(locationNumber)
        handleResponseQuoteStatus(response)
    }

    private fun handleResponseQuoteStatus(response: Response<QuoteStatusResponse>) {
        if (response.isSuccessful && response.body() != null) {
            quotesStatusLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            println("Login Error ${response.code()} ${response.message()}")
            quotesStatusLiveData.postValue(NetworkResult.Error("${response.code()} ${response.message()}"))
        } else if (response.body() == null) {
            quotesStatusLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun createRetailQuote(createQuoteRequest: CreateQuoteRequest){
        createQuotesLiveData.postValue(NetworkResult.Loading())
        val response = myQuotesApi.createRetailQuote(createQuoteRequest)
        handleResponseCreateQuote(response)
    }

    private fun handleResponseCreateQuote(response: Response<CreateRetailQuoteResponse>) {
        if (response.isSuccessful && response.body() != null) {
            createQuotesLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            println("Login Error ${response.code()} ${response.message()}")
            createQuotesLiveData.postValue(NetworkResult.Error("${response.code()} ${response.message()}"))
        } else if (response.body() == null) {
            createQuotesLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }

    suspend fun updateRetailQuote(updateRequestBody: UpdateRequestBody){
        updateQuoteLiveData.postValue(NetworkResult.Loading())
        val response = myQuotesApi.updateRetailQuote(updateRequestBody)
        handleResponseUpdateQuote(response)
    }

    private fun handleResponseUpdateQuote(response: Response<MyQuotesData>) {
        if (response.isSuccessful && response.body() != null) {
            updateQuoteLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {
            println("Login Error ${response.code()} ${response.message()}")
            updateQuoteLiveData.postValue(NetworkResult.Error("${response.code()} ${response.message()}"))
        } else if (response.body() == null) {
            updateQuoteLiveData.postValue(NetworkResult.Error("something went wrong"))
        }
    }
}