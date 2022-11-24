package com.umutakpinar.countriesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umutakpinar.countriesapp.model.Country

class CountryViewModel : ViewModel(){
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country1 = Country("Turkey","Asia","Ankara","TRY","Turkish","asdas.com")
        countryLiveData.value = country1
    }
}


