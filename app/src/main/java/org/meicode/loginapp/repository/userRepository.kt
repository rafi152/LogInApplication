package org.meicode.loginapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import org.json.JSONObject
import org.meicode.loginapp.api.ApiInterface
import org.meicode.loginapp.models.Data
import org.meicode.loginapp.models.Support
import org.meicode.loginapp.models.UserResponse
import org.meicode.loginapp.utils.Constants.TAG
import org.meicode.loginapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class userRepository @Inject constructor(private val userApi :  ApiInterface) {
    private val _userLivedata=MutableLiveData<NetworkResult<Data>>()
    val userResponseLiveData:LiveData<NetworkResult<Data>>
    get() = _userLivedata

    suspend fun userRegester(userResponse : Support){
        _userLivedata.postValue(NetworkResult.Loading())
        val response=userApi.signup(userResponse)
        handleResponse(response)
//        handleResponse(response)
//        Log.d(TAG,response.body().toString())
    }

    suspend fun userLogin(userResponse: Support){
        val response=userApi.signin(userResponse)
        handleResponse(response)
//        Log.d(TAG,response.body().toString())

    }

    private fun handleResponse(response: Response<Data>) {
        if (response.isSuccessful && response.body() != null) {
            _userLivedata.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorobj = JSONObject(response.errorBody()!!.charStream().readText())
            _userLivedata.postValue(NetworkResult.Error(errorobj.getString("message")))
        } else {
            _userLivedata.postValue(NetworkResult.Error("Something went wrong"))
        }
    }



//    private fun handleResponse(response: Response<UserResponse>) {
//        if (response.isSuccessful && response.body() != null) {
//            _userLivedata.postValue(NetworkResult.Success(response.body()!!))
//        } else if (response.errorBody() != null) {
//            val errorobj = JSONObject(response.errorBody()!!.charStream().readText())
//            _userLivedata.postValue(NetworkResult.Error(errorobj.getString("message")))
//        } else {
//            _userLivedata.postValue(NetworkResult.Error("Something went wrong"))
//        }
//    }
}