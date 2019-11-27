package com.example.datasekolah.network;

import com.example.datasekolah.model.login.ResponseLogin;
import com.example.datasekolah.model.readSiswa.ResponseReadSiswa;
import com.example.datasekolah.model.register.ResponseRegister;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

//    TODO Login
    @FormUrlEncoded
    @POST("login_user.php")
    Call<ResponseLogin> responseLogin(@Field("vsusername") String vsusername,
                                      @Field("vspassword") String vspassword);

//    TODO Register
    @FormUrlEncoded
    @POST("register_user.php")
    Call<ResponseRegister> responseRegister (@Field("nama_user") String nama_user,
                                             @Field("vsusername") String vsusername,
                                             @Field("vspassword") String vspassword);

    @GET("read_siswa.php")
    Call<ArrayList<ResponseReadSiswa>> actionReadSiswa();

}
