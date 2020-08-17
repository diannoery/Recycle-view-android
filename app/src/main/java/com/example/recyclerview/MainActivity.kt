package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.language.viewModel.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CustomClickListener {
    val LanguageViewModel by viewModels<LanguageViewModel>()
    lateinit var costumAdapter:LanguageRecycleAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        language_recycleView.layoutManager=LinearLayoutManager(this)
        costumAdapter= LanguageRecycleAdaptor(LanguageViewModel.languageLiveData.value!!)
        costumAdapter.listener=this
       language_recycleView.adapter=costumAdapter
        LanguageViewModel.languageLiveData.observe(this, Observer {
          //language_recycleView.adapter=LanguageRecycleAdaptor(it)
            costumAdapter.notifyDataSetChanged()
            println("dari mainActivity "+LanguageViewModel.languageList.size)
       })
    }

    fun addLanguage(view: View) {
        val languageName=languageInput.text.toString()
        LanguageViewModel.addLanguage(languageName)

    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this, "$language", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(view: View, index: Int) {
        Toast.makeText(this, "$index Delete Succesful", Toast.LENGTH_SHORT).show()
        LanguageViewModel.removeLanguage(index)
    }
}