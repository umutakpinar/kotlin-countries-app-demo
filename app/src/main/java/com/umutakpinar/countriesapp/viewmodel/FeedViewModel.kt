package com.umutakpinar.countriesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umutakpinar.countriesapp.model.Country

class FeedViewModel : ViewModel(){
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val country1 = Country("Turkey","Asia","Ankara","TRY","Turkish","www.something.com")
        val country2 = Country("France","Europe","Italy","EUR","French","www.something.com")
        val country3 = Country("Germany","Europe","Berlin","EUR","Deustche","www.something.com")

        val countryList = arrayListOf<Country>(country1,country2,country3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
}
