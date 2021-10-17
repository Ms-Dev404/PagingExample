package com.business.test.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.business.githubapp.MyApplication
import com.business.githubapp.databinding.FragmentNotificationsBinding

import com.business.test.interMediator.FactoryVm
import com.business.test.interMediator.FetchingState
import com.business.test.networkResponse.UserDetailsResponse
import com.business.test.viewModel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FragmentDetails:Fragment() {

    lateinit var vm:MainViewModel
    lateinit var binding: FragmentNotificationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var factoryVm = FactoryVm(MyApplication.repository!!)
        vm = ViewModelProvider(this, factoryVm)[MainViewModel::class.java]






        }



    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentNotificationsBinding.inflate(layoutInflater)

        binding.apply {

            val id = arguments?.getString("id")

            if (!id.isNullOrBlank()) {

                fetchDataFromServer(id)

            } else {

                Toast.makeText(context, "Something went wrong!!", Toast.LENGTH_SHORT).show()
            }

            btnUpdate.setOnClickListener {


            }

            btnDelete.setOnClickListener {


            }


        }


        return binding.root
    }


    private fun fetchDataFromServer(id:String) {

        vm.getDetails(id).observe(viewLifecycleOwner, { stateObserver ->

            when (stateObserver) {

                is FetchingState.Loading -> {
                    Toast.makeText(
                        context,
                        "Fetching!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is FetchingState.Success -> {

                    Toast.makeText(
                        context,
                        "Success!",
                        Toast.LENGTH_SHORT
                    ).show()

                    if(stateObserver.response!=null){

                      setView(stateObserver.response as UserDetailsResponse)


                    }
                }

                is FetchingState.Error -> {

                    Toast.makeText(
                        context,
                        stateObserver.exception.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }



            }
        })

    }

    @SuppressLint("SetTextI18n")
    private fun setView(res:UserDetailsResponse){

        Glide.with(binding.root.context).asBitmap().circleCrop().load(res?.picture).into(binding.ivProfile)
        binding.tvFname.text="First name: ${res?.firstName}"
        binding.tvLname.text="Last name: ${res?.lastName}"
        binding.tvName.text="${res?.title.uppercase()}. ${res?.firstName} ${res?.lastName}"
        binding.tvEmail.text="Email: ${res?.email}"
        binding.tvDob.text="Date of birth : ${res?.dateOfBirth}"
        binding.tvPhon.text="Phone : ${res?.phone}"
        binding.regTime.text="Register date : ${res?.registerDate}"
        binding.tvUpdated.text="Updated date : ${res?.updatedDate}"
        binding.regTime.isSelected=true
        binding.tvUpdated.isSelected=true

        val place=res?.location
        binding.tvStreet.text="Street : ${place?.street}"
        binding.tvCity.text="City : ${place?.city}"
        binding.tvCountry.text="Country : ${place?.country}"
        binding.tvTimezone.text="TimeZone : ${place?.timezone}"
    }


}