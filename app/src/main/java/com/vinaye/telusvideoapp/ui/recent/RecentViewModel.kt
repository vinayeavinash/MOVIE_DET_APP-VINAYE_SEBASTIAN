package com.vinaye.telusvideoapp.ui.recent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Coming  Soon"
    }
    val text: LiveData<String> = _text
}