package com.example.datasekolah.model.register;


import com.google.gson.annotations.SerializedName;


public class ResponseRegister{

	@SerializedName("vsusername")
	private String vsusername;

	@SerializedName("vspassword")
	private String vspassword;

	@SerializedName("nama_user")
	private String namaUser;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

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

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRegister{" + 
			"vsusername = '" + vsusername + '\'' + 
			",vspassword = '" + vspassword + '\'' + 
			",nama_user = '" + namaUser + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}