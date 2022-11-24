package com.umutakpinar.countriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutakpinar.countriesapp.R

class CountryFragment : Fragment() {
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

        arguments?.let{ //eğer gelen argümanlar boş değilse CountryFragmentsArgs sınıfından Bundle'ı çek
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }


        //Burası test amaçlı oluşturulmuştu!
        /*gotoFirst.setOnClickListener {
            val action = CountryFragmentDirections.actionCountryFragmentToFeedFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
    }

}





