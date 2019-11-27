package com.example.datasekolah.network;


import com.example.datasekolah.model.add.ResponseAdd;
import com.example.datasekolah.model.delete.ResponseDelete;
import com.example.datasekolah.model.login.ResponseLogin;
import com.example.datasekolah.model.readSiswa.ResponseReadSiswa;
import com.example.datasekolah.model.register.ResponseRegister;
import com.example.datasekolah.model.update.ResponseUpdate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

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


    @PUT("update_siswa.php")
    Call<ResponseUpdate> actionUpdate (@Query("nama_siswa") String nama_siswa,
                                       @Query("kelas") String kelas,
                                       @Query("id_siswa") String id_siswa);


    @DELETE("delete_siswa.php")
    Call<ResponseDelete> actionDelete (@Query("id_siswa") String id);

    @FormUrlEncoded
    @POST("create_siswa.php")
    Call<ResponseAdd> actionAdd (@Field("nama_siswa") String nama_siswa,
                                 @Field("kelas") String kelas);
}
