package org.meicode.loginapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.meicode.loginapp.databinding.FragmentLogIn2Binding
import org.meicode.loginapp.models.Support
import org.meicode.loginapp.utils.Constants.TAG
import org.meicode.loginapp.utils.NetworkResult

class LogInFragment : Fragment() {
    private var _binding : FragmentLogIn2Binding?=null  //object
    private val binding get() = _binding!!
//    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLogIn2Binding.inflate(inflater,container,false)  //initialize
        return binding.root

//        binding.btnLogIn.setOnClickListener {
//            authViewModel.registerUser(Support("rafisayed@gmail.com","1234"))
//        }
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        authViewModel.userResponseLiveData.observe(viewLifecycleOwner, Observer {
////            binding.progressBar.isVisible=false
//            when(it){
//                is NetworkResult.Success ->{
//                    findNavController().navigate(R.id.action_logInFragment_to_viewFragment)
//                }
//                is NetworkResult.Error ->{
//                    binding.txtError.text=it.message
//                }
//                is NetworkResult.Loading ->{
//                    binding.progressBar.isVisible=true
//                }
//            }
//        })
//    }
//        authViewModel.userResponseLiveData.observe(viewLifecycleOwner,{
//            when(it){
//                is NetworkResult.Success ->{
//                    findNavController().navigate(R.id.action_logInFragment_to_viewFragment)
//                }
//                is NetworkResult.Error ->{
//                    binding.txtError.text=it.message
//                }
//                is NetworkResult.Loading ->{
//                    binding.progressBar.isVisible=true
//                }
//            }
//        })
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding=null
//    }
}