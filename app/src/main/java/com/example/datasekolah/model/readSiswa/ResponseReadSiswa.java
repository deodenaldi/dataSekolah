package com.example.datasekolah.model.readSiswa;


import com.google.gson.annotations.SerializedName;

public class ResponseReadSiswa{

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("id_siswa")
	private String idSiswa;

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

	public void setIdSiswa(String idSiswa){
		this.idSiswa = idSiswa;
	}

	public String getIdSiswa(){
		return idSiswa;
	}

	@Override
 	public String toString(){
		return 
			"ResponseReadSiswa{" + 
			"nama_siswa = '" + namaSiswa + '\'' + 
			",kelas = '" + kelas + '\'' + 
			",id_siswa = '" + idSiswa + '\'' + 
			"}";
		}
}