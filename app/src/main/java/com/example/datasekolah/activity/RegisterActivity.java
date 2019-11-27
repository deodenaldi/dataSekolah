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
import com.example.datasekolah.model.register.ResponseRegister;
import com.example.datasekolah.network.ApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edtRegisterUser)
    EditText edtRegisterUser;
    @BindView(R.id.edtRegisterUsername)
    EditText edtRegisterUsername;
    @BindView(R.id.edtRegisterPassword)
    EditText edtRegisterPassword;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.txtLogin)
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnRegister, R.id.txtLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:

                String user = edtRegisterUser.getText().toString();
                String userName = edtRegisterUsername.getText().toString();
                String password = edtRegisterPassword.getText().toString();

                    if (TextUtils.isEmpty(user) || TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                        Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }else {
                        registerUser(user,userName,password);
                    }
                break;
            case R.id.txtLogin:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
        }
    }

    private void registerUser(String paramUser, String paramUsername, String paramPassword) {
        ApiClient.service.responseRegister(paramUser, paramUsername, paramPassword).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {

                if(response.isSuccessful()){
                    String message = response.body().getMessage();
                    String status = response.body().getStatus();

                    if (status.equalsIgnoreCase("1")) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else if (status.equalsIgnoreCase("0")) {
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {

            }
        });
    }
}
