package com.example.recyclerview.language.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel : ViewModel(){
    val languageList:MutableList<String> = mutableListOf<String>("java","golang","kotlin")
    val languageLiveData : MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

        fun addLanguage(name:String) {

            languageList.add(name)
            languageLiveData.value = languageList
            println(languageLiveData.value?.joinToString())
        }
    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}