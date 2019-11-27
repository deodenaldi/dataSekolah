package com.example.datasekolah.model.login;


import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("vsusername")
	private String vsusername;

	@SerializedName("vspassword")
	private String vspassword;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("nama_user")
	private String namaUser;

	public void setVsusername(String vsusername){
		this.vsusername = vsusername;
	}

	public String getVsusername(){
		return vsusername;
	}

	public void setVspassword(String vspassword){
		this.vspassword = vspassword;
	}

	public String getVspassword(){
		return vspassword;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"vsusername = '" + vsusername + '\'' + 
			",vspassword = '" + vspassword + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",nama_user = '" + namaUser + '\'' + 
			"}";
		}
}