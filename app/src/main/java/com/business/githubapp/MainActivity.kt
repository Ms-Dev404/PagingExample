package com.business.githubapp

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.business.githubapp.databinding.ActivityMainBinding

import com.business.test.interMediator.FactoryVm
import com.business.test.ui.fragments.FragmentPosts
import com.business.test.ui.fragments.FragmentTags
import com.business.test.ui.fragments.HomeFragment

import com.business.test.viewModel.MainViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var factoryVm: FactoryVm
    private lateinit var mainViewModel: MainViewModel
    private lateinit var pbd: ProgressDialog
    private var cm: ConnectivityManager? = null
    private var nF: NetworkInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

        addFragmentToActivity(HomeFragment())
        bottomNav.setOnItemReselectedListener {

            when(it.itemId){

              R.id.menu_user->addFragmentToActivity(HomeFragment())
              R.id.menu_post->addFragmentToActivity(FragmentPosts())
              R.id.menu_tag->addFragmentToActivity(FragmentTags())
            }
        }

        }

    }

    private fun addFragmentToActivity(fragment: Fragment?) {

        if (fragment == null) return

        val fm=supportFragmentManager
        val tr = fm.beginTransaction()
        tr.replace(R.id.frame_layout, fragment)
        tr.commitNowAllowingStateLoss()


    }
}