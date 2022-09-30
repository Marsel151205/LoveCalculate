package com.example.lovecalculate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculate.api.LoveApi
import com.example.lovecalculate.models.LoveModel
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

class Repository @Inject constructor(private val api: LoveApi) {

    fun getLoveModelMutableLiveData(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val loveModel: MutableLiveData<LoveModel> = MutableLiveData()
        api.getCalculateLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    loveModel.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }
        })
        return loveModel
    }
}