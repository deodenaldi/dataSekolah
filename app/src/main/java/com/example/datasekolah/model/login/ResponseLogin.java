package com.example.datasekolah.model.login;


import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("result")
	private String result;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLogin{" + 
			"result = '" + result + '\'' + 
			",message = '" + message + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}