package com.example.lovecalculate.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.lovecalculate.App
import com.example.lovecalculate.R
import com.example.lovecalculate.data.models.LoveModel
import com.example.lovecalculate.databinding.FragmentHistoryBinding
import com.example.lovecalculate.ui.adapters.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint

class HistoryFragment : Fragment() {

    private lateinit var binding : FragmentHistoryBinding
    private var adapter = HistoryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appDataBase.loveDao().getAll().observe( requireActivity(), Observer {
            adapter = HistoryAdapter(it as ArrayList<LoveModel>)
            binding.recyclerViewHistory.adapter = adapter
        })
    }
}