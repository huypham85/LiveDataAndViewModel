package com.example.livedataandviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.livedataandviewmodel.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var medalViewModel: MedalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root
        //mediaViewModel will secure the data of activity by using of()
        medalViewModel = ViewModelProviders.of(requireActivity()).get(MedalViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // this fragment is a observer, so it must be noticed about changes of value in context activity
        medalViewModel.numGoldMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
        medalViewModel.numSilverMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
        medalViewModel.numBronzeMedal.observe(requireActivity(), Observer<Int>{displayMedal()})
    }
    fun displayMedal(){
        binding.txtDetailGold.text = medalViewModel.numGoldMedal.value.toString()
        binding.txtDetailSilver.text = medalViewModel.numSilverMedal.value.toString()
        binding.txtDetailBronze.text = medalViewModel.numBronzeMedal.value.toString()

    }
}