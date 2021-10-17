package com.business.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.business.githubapp.MyApplication
import com.business.githubapp.R
import com.business.githubapp.databinding.FragmentHomeBinding

import com.business.test.interMediator.FactoryVm
import com.business.test.model.User
import com.business.test.ui.UserAdapter

import com.business.test.viewModel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment:Fragment() {
    private  var adapter= UserAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var factoryVm = FactoryVm(MyApplication.repository!!)
        var vm = ViewModelProvider(this, factoryVm)[MainViewModel::class.java]


        lifecycleScope.launch {

          vm.pagedUserList.collect {

              adapter.submitData(it as PagingData<User>)
          }


        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding= FragmentHomeBinding.inflate(layoutInflater)

         binding.apply {

             rvUsers.layoutManager= LinearLayoutManager(root.context)
              rvUsers.adapter=adapter
             fabAddUser.setOnClickListener {

                 addFragmentToActivity(FragmentCreateUser())
             }
         }
        adapter.addLoadStateListener {



        }
        return binding.root
    }

    private fun addFragmentToActivity(fragment: Fragment?) {

        if (fragment == null) return
        val f=context as FragmentActivity
        val fm=f.supportFragmentManager
        val tr = fm.beginTransaction()
        tr.replace(R.id.frame_layout, fragment)
        tr.commitNowAllowingStateLoss()
        //tr.commit()

    }
}