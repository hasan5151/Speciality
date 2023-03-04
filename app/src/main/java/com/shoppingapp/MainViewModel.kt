package com.shoppingapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
   private val _name = MutableLiveData<String>()
    val name get() = _name
    fun onSetname(name: String?){
        _name.value = name

    }
}