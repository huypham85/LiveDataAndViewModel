package com.example.livedataandviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.livedataandviewmodel.databinding.FragmentSummaryBinding


class SummaryFragment : Fragment() {
    private lateinit var binding: FragmentSummaryBinding
    lateinit var medalViewModel: MedalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSummaryBinding.inflate(inflater,container,false)
        val view = binding.root
        medalViewModel = ViewModelProviders.of(requireActivity()).get(MedalViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medalViewModel.numGoldMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
        medalViewModel.numSilverMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
        medalViewModel.numBronzeMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
    }
    fun displayMedal(){
        var totalMedal: Int = medalViewModel.numGoldMedal.value!!.plus(medalViewModel.numSilverMedal.value!!).plus(medalViewModel.numBronzeMedal.value!!)
        binding.txtSum.text = totalMedal.toString()
    }
}