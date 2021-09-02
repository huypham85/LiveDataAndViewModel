package com.example.livedataandviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedalViewModel : ViewModel(){
    // subjects of model , use this class to share data between Fragments
    var numGoldMedal: MutableLiveData<Int> = MutableLiveData()
    var numSilverMedal: MutableLiveData<Int> = MutableLiveData()
    var numBronzeMedal: MutableLiveData<Int> = MutableLiveData()
    init {
        numGoldMedal.value = 0
        numSilverMedal.value =0
        numBronzeMedal.value =0
    }
}