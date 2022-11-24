package com.umutakpinar.countriesapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.umutakpinar.countriesapp.R
import com.umutakpinar.countriesapp.model.Country
import com.umutakpinar.countriesapp.view.CountryFragmentDirections
import com.umutakpinar.countriesapp.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.recyler_row.view.*

class CountryAdapter(val CountryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    class CountryViewHolder(var view: View) : ViewHolder(view) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyler_row,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.countryName.text = CountryList[position].countryName
        holder.view.countryRegion.text = CountryList[position].countryRegion
        // Burada bir de görseli almamız gerek ancak şuan herahngi bir veri çekmediğimiz için şimdilik görselle çalışmıyoruz.
        //Aslında şöyle yazıalbilirdi mesela holder.view.countryImage.setImageResource() şeklinde!

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(position)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return CountryList.size
    }

    fun updateCountryList(newCountryList : List<Country>){
        CountryList.clear() //Listeler referans tip olduğu için eşitleyemem temizledim önce
        CountryList.addAll(newCountryList) // referans tip olduğu için eşitleyemem hepsini ekledim.
        notifyDataSetChanged() //Bu da datasetin değişştiğini adapter'e bildirmek için çağırılıyor ki verileri yeniden göstersin
    }
}



