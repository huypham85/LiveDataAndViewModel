package com.example.livedataandviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.livedataandviewmodel.databinding.FragmentControlBinding

class ControlFragment : Fragment() {
    lateinit var medalViewModel: MedalViewModel
    private lateinit var binding : FragmentControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentControlBinding.inflate(inflater,container,false)
        val view = binding.root
        medalViewModel = ViewModelProviders.of(requireActivity()).get(MedalViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMedal()
        binding.btnGoldMinus.setOnClickListener {
            medalViewModel.numGoldMedal.value = medalViewModel.numGoldMedal.value!!.minus(1)
            displayMedal()
        }
        binding.btnGoldPlus.setOnClickListener {
            medalViewModel.numGoldMedal.value = medalViewModel.numGoldMedal.value!!.plus(1)
            displayMedal()
        }
        binding.btnSilverMinus.setOnClickListener {
            medalViewModel.numSilverMedal.value = medalViewModel.numSilverMedal.value!!.minus(1)
            displayMedal()
        }
        binding.btnSilverPlus.setOnClickListener {
            medalViewModel.numSilverMedal.value = medalViewModel.numSilverMedal.value!!.plus(1)
            displayMedal()
        }
        binding.btnBronzeMinus.setOnClickListener {
            medalViewModel.numBronzeMedal.value = medalViewModel.numBronzeMedal.value!!.minus(1)
            displayMedal()
        }
        binding.btnBronzePlus.setOnClickListener {
            medalViewModel.numBronzeMedal.value = medalViewModel.numBronzeMedal.value!!.plus(1)
            displayMedal()
        }

    }
    fun displayMedal(){
        binding.txtCountGold.text = medalViewModel.numGoldMedal.value.toString()
        binding.txtCountSilver.text = medalViewModel.numSilverMedal.value.toString()
        binding.txtCountBronze.text = medalViewModel.numBronzeMedal.value.toString()
    }

}