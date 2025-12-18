package com.example.prak12.repositori

import com.example.prak12.apiservice.ServiceApiSiswa
import com.example.prak12.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void>
//    suspend fun getStatusSiswa(id: Int): DataSiswa
//    suspend fun editStatusSiswa(id:Int,dataSiswa: DataSiswa): retrofit2.Response<Void>
//    suspend fun hapusStatusSiswa(id: Int): retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
}