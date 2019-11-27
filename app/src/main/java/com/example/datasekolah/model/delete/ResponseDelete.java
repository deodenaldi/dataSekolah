package com.example.datasekolah.model.delete;


import com.google.gson.annotations.SerializedName;


public class ResponseDelete{

	@SerializedName("messagge")
	private String messagge;

	@SerializedName("status")
	private int status;

	public void setMessagge(String messagge){
		this.messagge = messagge;
	}

	public String getMessagge(){
		return messagge;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDelete{" + 
			"messagge = '" + messagge + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}