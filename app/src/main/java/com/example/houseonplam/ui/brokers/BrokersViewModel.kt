package com.example.houseonplam.ui.brokers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrokersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is brokers Fragment"
    }
    val text: LiveData<String> = _text
}