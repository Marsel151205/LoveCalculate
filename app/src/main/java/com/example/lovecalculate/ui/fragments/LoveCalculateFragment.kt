package com.example.lovecalculate.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.App
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentLoveCalculateBinding
import com.example.lovecalculate.models.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculateFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                App.api.getCalculateLove(etFirstName.text.toString(), etSecondName.text.toString()).enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val model = response.body()
                        val bundle = Bundle()
                        bundle.putSerializable("model", model)
                        findNavController().navigate(R.id.loveResultFragment, bundle)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })
            }
        }
    }
}