package com.example.prak12.repositori

import com.example.prak12.apiservice.ServiceApiSiswa
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

interface ContainerApp{
    val repositorySiswa: RepositoryDataSiswa
}

class DefaultAppContainer: ContainerApp {
    private val baseUrl = "http://10.0.2.2/umyTI/"

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val klien = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            Json{
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            } .asConverterFactory("aplication/json".toMediaType())
        )
        .client(klien)
        .build()

    private val retrofitService: ServiceApiSiswa by lazy {
        retrofit.create(ServiceApiSiswa::class.java)
    }
    override val repositorySiswa: RepositoryDataSiswa by lazy {
        JaringanRepositoryDataSiswa(retrofitService)
    }
}

class AplikasiDataSiswa : Aplication(){
    lateinit var container: ContainerApp
    override fun onCreate(){
        super.onCreate()
        this.container = DefaultAppContainer()
    }
}