package org.meicode.loginapp.api

import org.meicode.loginapp.models.Data
import org.meicode.loginapp.models.Support
import org.meicode.loginapp.models.UserResponse
import org.meicode.loginapp.repository.userRepository
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/api/users?page=2")
    suspend fun signup(@Body userResponse: Support) : Response<Data>

    @POST("/api/users?page=2")
    suspend fun signin(@Body userResponse: Support) : Response<Data>
}