package com.business.test.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.business.githubapp.R
import com.business.githubapp.databinding.UserRowBinding

import com.business.test.model.User
import com.business.test.ui.fragments.FragmentDetails


class UserAdapter:PagingDataAdapter<User,UserAdapter.VH>(DataComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

      return VH(UserRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder:VH, position: Int) {
        val userItem=getItem(position)

        if(userItem!=null) {

            holder.bind(userItem)
        }
    }




    class VH(private val binding: UserRowBinding):RecyclerView.ViewHolder(binding.root){


        @SuppressLint("SetTextI18n")
        fun bind(user:User){

            binding.apply {

                userName.text="${user.title}. ${user.firstName} ${user.lastName}"

                if(user.picture.isNotEmpty()){

                    Glide.with(root.context).load(user.picture).circleCrop().into(ivImage)
                    val f=root.context as FragmentActivity
                    val fm=f.supportFragmentManager
                    val tr=fm.beginTransaction()

                    click.setOnClickListener {
                        val fragmentDetails=FragmentDetails()
                        val b=Bundle()
                        b.putString("id",user.id)
                        fragmentDetails.arguments=b
                        tr.replace(R.id.frame_layout, fragmentDetails)
                        tr.commitNowAllowingStateLoss()


                    }
                }
            }

        }

    }

    object DataComparator:DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {

            return oldItem==newItem
        }


    }



}