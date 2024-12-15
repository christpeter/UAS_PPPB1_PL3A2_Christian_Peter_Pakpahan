package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.network

import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.models.TravelSchedule
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("{database}/{table}")
    fun getAllSchedules(
        @Path("database") database: String,
        @Path("table") table: String
    ): Call<List<TravelSchedule>>

    @POST("{database}/{table}")
    fun createSchedule(
        @Path("database") database: String,
        @Path("table") table: String,
        @Body newSchedule: TravelSchedule
    ): Call<TravelSchedule>

    @PUT("{database}/{table}/{id}")
    fun updateSchedule(
        @Path("database") database: String,
        @Path("table") table: String,
        @Path("id") id: String,
        @Body updatedSchedule: TravelSchedule
    ): Call<TravelSchedule>

    @DELETE("{database}/{table}/{id}")
    fun deleteSchedule(
        @Path("database") database: String,
        @Path("table") table: String,
        @Path("id") id: String
    ): Call<Void>
}