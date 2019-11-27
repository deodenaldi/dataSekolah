package com.example.datasekolah.model.update;


import com.google.gson.annotations.SerializedName;


public class ResponseUpdate{

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public void setNamaSiswa(String namaSiswa){
		this.namaSiswa = namaSiswa;
	}

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
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
			"ResponseUpdate{" + 
			"nama_siswa = '" + namaSiswa + '\'' + 
			",kelas = '" + kelas + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}