package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivityViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.CategoryBinding

class UserAdapter (private val context: Context, private val arrylist:ArrayList<MainActivityViewModel>):
    RecyclerView.Adapter<UserAdapter.UserView>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserView {

        val layoutInflater = LayoutInflater.from(parent.context)
        val categoryBinding: CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.innerlayout,parent,false)
        return UserView(categoryBinding)

    }

    override fun getItemCount(): Int {
        return arrylist.size
    }

    override fun onBindViewHolder(holder: UserView, position: Int) {

        val mainViewModel = arrylist[position]
        holder.bind(mainViewModel)
    }


    class UserView(val categoryBinding: CategoryBinding):RecyclerView.ViewHolder(categoryBinding.root)
    {
        fun bind (mainViewModel: MainActivityViewModel)
        {

            this.categoryBinding.categorymodel = mainViewModel
            categoryBinding.executePendingBindings()

        }
    }
}