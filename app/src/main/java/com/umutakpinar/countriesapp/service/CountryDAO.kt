package com.umutakpinar.countriesapp.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.umutakpinar.countriesapp.model.Country

@Dao
interface CountryDAO {
    /*INSERT*/
    //Insert işlemi için otoamtik insert yapabiliyor zaten biziö tablomuz vs yoktu tableName falan vermemiştik
    @Insert
    suspend fun insertAll(vararg countries: Country) : List<Long>

    /* SELECT ALL */
    //Ancak select işlemlerinde where clause falan kullanılabileceği için burada sadece @SSelect diyerek kurtulamıyoruz
    //query'i de yazmmamız bekleniyor o nedenle!
    @Query("SELECT * FROM country")
    suspend fun getALlCountries() : List<Country>

    /* SELECT WHERE ID == X */
    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    /* DELETE ALL */
    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

    /* DELETE WHERE ID == X */
    @Query("DELETE FROM country WHERE uuid = :countryId")
    suspend fun deleteCountry(countryId : Int)
}

