package com.example.datasekolah.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datasekolah.R;
import com.example.datasekolah.model.login.ResponseLogin;
import com.example.datasekolah.network.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.txtRegister)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.txtRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                        Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }else {
                        loginUser(username,password);
                    }

                break;
            case R.id.txtRegister:
                startActivity(new Intent( this, RegisterActivity.class));
                break;
        }
    }

    private void loginUser(String paramUsername, String paramPassword) {
        ApiClient.service.responseLogin(paramUsername,paramPassword).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.body().getResult().equalsIgnoreCase("1")) {
                    String message = response.body().getMessage();
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Gagal onFailure", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
