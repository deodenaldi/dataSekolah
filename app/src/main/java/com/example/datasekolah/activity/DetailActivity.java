package com.example.datasekolah.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datasekolah.R;
import com.example.datasekolah.model.update.ResponseUpdate;
import com.example.datasekolah.network.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.edtNamaSiswa)
    EditText edtNamaSiswa;
    @BindView(R.id.edtKelasSiswa)
    EditText edtKelasSiswa;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;
    @BindView(R.id.btnDelete)
    Button btnDelete;

    public static String KEY_ID = "key_id";
    public static String KEY_NAMA_SISWA = "key_nama_siswa";
    public static String KEY_KELAS_SISWA = "key_kelas_siswa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String terimaid = getIntent().getStringExtra(KEY_ID);
        String terimanama = getIntent().getStringExtra(KEY_NAMA_SISWA);
        String terimakelas = getIntent().getStringExtra(KEY_KELAS_SISWA);

        edtNamaSiswa.setText(terimanama);
        edtKelasSiswa.setText(terimakelas);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = edtNamaSiswa.getText().toString();
                String kelas = edtKelasSiswa.getText().toString();

                if (TextUtils.isEmpty(nama)){
                    edtNamaSiswa.setError("Tidak Boleh Kosong");
                }else if (TextUtils.isEmpty(kelas)) {
                    edtKelasSiswa.setError("Tidak Boleh Kosong");
                }else {
                    updateSiswa(terimaid, terimanama, terimakelas);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void updateSiswa(String id, String nama, String kelas) {
        ApiClient.service.actionUpdate(id, nama, kelas).enqueue(new Callback<ResponseUpdate>() {
            @Override
            public void onResponse(Call<ResponseUpdate> call, Response<ResponseUpdate> response) {
                if (response.isSuccessful()) {
                    String message = response.body().getMessage();
                    String status = response.body().getStatus();

                    if (status.equalsIgnoreCase("1")) {
                        Toast.makeText(DetailActivity.this, message, Toast.LENGTH_SHORT).show();
                    }else if (status.equalsIgnoreCase("0")) {
                        Toast.makeText(DetailActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseUpdate> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Gagal onFailure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
