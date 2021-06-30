package com.example.loadmoreexample

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("hostel/list")
    fun getListHomeCashBack(
        @Query("term") term: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int,
        @Query("province_id") province_id: String?,
        @Query("district_id") district_id: String?,
        @Query("ward_id") ward_id: String?,
        @Query("sizes") sizes: String?,
        @Query("prices") prices: String?,
        @Query("type") type: Int?,
        @Query("is_empty") isEmpty: Int?
    ): Observable<BaseResponse<List<HomeCashBack>?>>
}