package com.example.datasekolah.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datasekolah.R;
import com.example.datasekolah.model.add.ResponseAdd;
import com.example.datasekolah.network.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaSiswaTambah)
    EditText edtNamaSiswaTambah;
    @BindView(R.id.edtKelasSiswaTambah)
    EditText edtKelasSiswaTambah;
    @BindView(R.id.btnTambah)
    Button btnTambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTambah)
    public void onViewClicked() {

        String nama = edtNamaSiswaTambah.getText().toString();
        String kelas = edtKelasSiswaTambah.getText().toString();

        if (TextUtils.isEmpty(nama)) {
            edtNamaSiswaTambah.setError("Jangan Kosong");
        }else if (TextUtils.isEmpty(kelas)) {
            edtKelasSiswaTambah.setError("Jangan Kosong");
        }

        tambahData(nama, kelas);
    }

    private void tambahData (String nama, String kelas) {
        ApiClient.service.actionAdd(nama, kelas).enqueue(new Callback<ResponseAdd>() {
            @Override
            public void onResponse(Call<ResponseAdd> call, Response<ResponseAdd> response) {
                if (response.isSuccessful()) {
                    String message = response.body().getMessage();
                    String status = response.body().getStatus();

                    if (status.equalsIgnoreCase("1")) {
                        Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddActivity.this, MainActivity.class));
                        finish();
                    }else if (status.equalsIgnoreCase("0")) {
                        Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseAdd> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Gagal onFailure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
