package com.example.datasekolah.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datasekolah.R;
import com.example.datasekolah.RecyclerViewAdapter;
import com.example.datasekolah.model.readSiswa.ResponseReadSiswa;
import com.example.datasekolah.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<ResponseReadSiswa> data = null;

    @BindView(R.id.rcView)
    RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getReadSiswa();
    }

    private void getReadSiswa() {
        ApiClient.service.actionReadSiswa().enqueue(new Callback<ArrayList<ResponseReadSiswa>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseReadSiswa>> call, Response<ArrayList<ResponseReadSiswa>> response) {
                if (response.code() == 200){
                    data = response.body();
                    if (data == null){
                        Toast.makeText(MainActivity.this, "Data NULL", Toast.LENGTH_SHORT).show();
                    }else{

                        rcView.setHasFixedSize(true);
                        rcView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        rcView.setAdapter(new RecyclerViewAdapter(MainActivity.this, data));
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseReadSiswa>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_tambah:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
