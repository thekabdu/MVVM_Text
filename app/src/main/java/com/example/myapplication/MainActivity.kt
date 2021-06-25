package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var recycleview: RecyclerView?=null
    private var useradapter: UserAdapter?=null

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview = findViewById(R.id.recyclerview) as RecyclerView

        var categoryViewModel:MainActivityViewModel = ViewModelProvider(this@MainActivity).get(MainActivityViewModel::class.java)



        categoryViewModel.getArrayList().observe(this, Observer {mainActivityViewModels->


            useradapter = UserAdapter(this@MainActivity,mainActivityViewModels!!)
            recycleview!!.setLayoutManager(LinearLayoutManager(this@MainActivity))
            recycleview!!.setAdapter(useradapter)
    })
    }
}


