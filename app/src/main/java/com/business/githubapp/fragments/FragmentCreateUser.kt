package com.business.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.business.githubapp.databinding.UserCreationFragmentBinding

class FragmentCreateUser:Fragment() {
    lateinit var viewBind: UserCreationFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind= UserCreationFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBind.apply {


        }
        return viewBind.root
    }
}