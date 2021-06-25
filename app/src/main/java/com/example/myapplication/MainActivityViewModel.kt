package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.User

class MainActivityViewModel : ViewModel {
    var name = ""
    var age = ""

    constructor() : super()
    constructor(user: User) : super() {
        this.name = user.name
        this.age = user.age.toString()
    }

    var userList = MutableLiveData<ArrayList<MainActivityViewModel>>()

    var arraylist = ArrayList<MainActivityViewModel>()

    fun getArrayList(): MutableLiveData<ArrayList<MainActivityViewModel>> {
        val abo = User("Abo", 22)
        val zhiga = User("Zhiga",29)
        val batyr = User("Batyr",11)
        val alim = User("Alim", 17)
        val kenzhe = User("Kenzhe",15)

        val categoryviewmodel1: MainActivityViewModel = MainActivityViewModel(abo)
        val categoryviewmodel2: MainActivityViewModel = MainActivityViewModel(zhiga)
        val categoryviewmodel3: MainActivityViewModel = MainActivityViewModel(batyr)
        val categoryviewmodel4: MainActivityViewModel = MainActivityViewModel(alim)
        val categoryviewmodel5: MainActivityViewModel = MainActivityViewModel(kenzhe)

        arraylist!!.add(categoryviewmodel1)
        arraylist!!.add(categoryviewmodel2)
        arraylist!!.add(categoryviewmodel3)
        arraylist!!.add(categoryviewmodel4)
        arraylist!!.add(categoryviewmodel5)

        userList.value = arraylist

        return userList
    }
}