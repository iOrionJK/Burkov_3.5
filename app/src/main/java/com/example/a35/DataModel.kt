package com.example.a35

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel:ViewModel() {
    val areSwapper : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}