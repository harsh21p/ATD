package com.atd.atdmobileapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atd.atdmobileapp.models.CartDisplayValue
import com.atd.atdmobileapp.models.CartItem
import com.atd.atdmobileapp.models.myquotes.FilterOptionQuotes
import com.atd.atdmobileapp.models.productsearch.FilterOptions
import com.atd.atdmobileapp.models.vehicle.Fitment
import com.atd.atdmobileapp.utils.CalendarViewType
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext context: Context) :ViewModel() {
    private val selectedPositions = mutableSetOf<Int>()
    private val selectedItems = mutableSetOf<String>()

    private val selectedOtherPositions = mutableSetOf<Int>()
    private val selectedOtherItems = mutableSetOf<String>()

    private var preferredBrandList = listOf<String>()

    private var filterOptions: FilterOptions = FilterOptions()
    private var filterOptionsQuotes: FilterOptionQuotes = FilterOptionQuotes()

    private val _badgeCount = MutableLiveData<Int>()
    var licencePlateState = MutableLiveData<String>()
    var frequency = MutableLiveData<String>()

    val cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()
    val cartValuesToDisplay: MutableLiveData<CartDisplayValue> = MutableLiveData()

    private val _preferenceChanged = MutableLiveData<Boolean>()
    val preferenceChanged: LiveData<Boolean>
        get() = _preferenceChanged

    private val _cartItemDetails = MutableLiveData<CartItem>()
    val cartItemDetails: LiveData<CartItem> get() = _cartItemDetails

    private val _selectedCalendarView = MutableLiveData<CalendarViewType>()
    val selectedCalendarView: LiveData<CalendarViewType> = _selectedCalendarView

    fun setSelectedCalendarView(viewType: CalendarViewType) {
        _selectedCalendarView.value = viewType
    }

    fun updateCartItemDetails(cartItem: CartItem) {
        _cartItemDetails.value = cartItem
    }

    fun notifyPreferenceChanged() {
        _preferenceChanged.value = true
    }

    fun resetPreferenceChangedFlag() {
        _preferenceChanged.value = false
    }

    fun getSelectedPositions(): Set<Int> {
        return selectedPositions
    }

    fun setSelectedPositions(positions: Set<Int>) {
        selectedPositions.clear()
        selectedPositions.addAll(positions)
    }


    fun getSelectedPositionsItem(): Set<String> {
        return selectedItems
    }

    fun setSelectedPositionsItems(items: Set<String>) {
        selectedItems.clear()
        selectedItems.addAll(items)
    }

    fun getSelectedOtherPositions(): Set<Int> {
        return selectedOtherPositions
    }

    fun setSelectedOtherPositions(positions: Set<Int>) {
        selectedOtherPositions.clear()
        selectedOtherPositions.addAll(positions)
    }



    fun getSelectedOtherPositionsItem(): Set<String> {
        return selectedOtherItems
    }

    fun setSelectedOtherPositionsItems(items: Set<String>) {
        selectedOtherItems.clear()
        selectedOtherItems.addAll(items)
    }


    fun clearLiveDataForBrands(){
        selectedItems.clear()
        selectedOtherItems.clear()
        selectedPositions.clear()
        selectedOtherPositions.clear()
    }

    fun getSelectedPreferredBrand():List<String> {
        return preferredBrandList
    }

    fun setPreferredBrand(items: List<String>) {
        preferredBrandList = items
    }

    fun getFilterOptions():FilterOptions {
        return filterOptions
    }

    fun setFilterOptions(items: FilterOptions) {
        filterOptions = items
    }

    fun getFilterOptionsQuotes():FilterOptionQuotes {
        return filterOptionsQuotes
    }

    fun setFilterOptionsQuotes(items: FilterOptionQuotes) {
        filterOptionsQuotes = items
    }


    fun setLicencePlateState(items: String) {
        licencePlateState.value=items
    }

    fun setFrequencyState(items: String) {
        frequency.value=items
    }
    fun getFrequencyState() : MutableLiveData<String>{

        return frequency
    }
}