package org.meicode.loginapp

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.meicode.loginapp.models.Data
import org.meicode.loginapp.models.Support
import org.meicode.loginapp.models.UserResponse
import org.meicode.loginapp.repository.userRepository
import org.meicode.loginapp.utils.NetworkResult
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: userRepository) : ViewModel() {

    val userResponseLiveData : LiveData<NetworkResult<Data>>    //livedata object
    get() = userRepository.userResponseLiveData

    fun userRegester(userData: Support){
        viewModelScope.launch {
            userRepository.userRegester(userData)
        }
    }
    fun userLogin(userData: Support){
        viewModelScope.launch {
            userRepository.userLogin(userData)
        }
    }
}