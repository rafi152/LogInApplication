package org.meicode.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.meicode.loginapp.databinding.FragmentAccountLogInBinding
import org.meicode.loginapp.models.Support
import org.meicode.loginapp.utils.NetworkResult
@AndroidEntryPoint
class AccountLogIn : Fragment() {
    private var _binding: FragmentAccountLogInBinding?=null
    private val binding get() =_binding!!
    private val authViewModel by viewModels<AuthViewModel>()
//    private val authViewModel : AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentAccountLogInBinding.inflate(inflater,container,false)
        return binding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.btnSignUp.setOnClickListener {
//                authViewModel.registerUser(Support("rafi","1234"))
                findNavController().navigate(R.id.action_accountLogIn_to_logInFragment)
            }
            binding.btnLogin.setOnClickListener {
                authViewModel.userLogin(Support("sayed","3434"))
            }
//        bindobserver()

            authViewModel.userResponseLiveData.observe(viewLifecycleOwner, Observer {
                binding.progressBar.isVisible=false
                when(it){
                    is NetworkResult.Success ->{
                        findNavController().navigate(R.id.action_logInFragment_to_viewFragment)
                    }
                    is NetworkResult.Error ->{
                        binding.txtError.text=it.message
                    }
                    is NetworkResult.Loading->{
                        binding.progressBar.isVisible=true
                    }
                }
            })

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
    }
//    private fun bindobserver() {
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}