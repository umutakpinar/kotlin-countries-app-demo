package com.umutakpinar.countriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.umutakpinar.countriesapp.R
import com.umutakpinar.countriesapp.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*
import kotlinx.android.synthetic.main.fragment_country.view.*

class CountryFragment : Fragment() {
    private lateinit var countryViewModel : CountryViewModel
    private var countryUuid : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryViewModel = ViewModelProviders.of(this@CountryFragment).get(CountryViewModel::class.java)
        countryViewModel.getDataFromRoom()

        arguments?.let{ //eğer gelen argümanlar boş değilse CountryFragmentsArgs sınıfından Bundle'ı çek
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        observeLiveData()

    }

    private fun observeLiveData(){
        countryViewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let{
                countryName.text = country.countryName
                countryCapital.text = country.countryCapital
                countryRegion.text = country.countryRegion
                countryCurrency.text = country.countryCurrency
                countryLanguage.text = country.countryLanguage
                /*burada image da eklemekg gerek ancak image bilgisi yok bizde henüz dummy data var*/
            }
        })
    }

}





