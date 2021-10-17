package com.business.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import com.business.githubapp.MyApplication
import com.business.githubapp.databinding.FragmentPostBinding

import com.business.test.interMediator.FactoryVm


import com.business.test.viewModel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FragmentPosts:Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var factoryVm = FactoryVm(MyApplication.repository!!)
        var vm = ViewModelProvider(this, factoryVm)[MainViewModel::class.java]
        //val binding=FragmentHomeBinding.inflate(layoutInflater)

        lifecycleScope.launch {
            /* vm.pagedUserList.collect {
                 //val item = it as PagingData<User>

                 //adapter.submitData(item)
             }*/
            vm.pagedUserList.collect {

               // adapter.submitData(it as PagingData<User>)
            }


        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        /* val binding = DataBindingUtil.inflate<>(inflater,
             R.layout.fragment_title,container,false)*/
        val binding= FragmentPostBinding.inflate(layoutInflater)

        binding.apply {

            rvPost.layoutManager= LinearLayoutManager(root.context)
            //rvUsers.adapter=adapter

        }
        /*adapter.addLoadStateListener {



        }*/

        return binding.root
    }
}