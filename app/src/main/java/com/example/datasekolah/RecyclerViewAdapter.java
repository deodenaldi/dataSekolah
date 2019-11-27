package com.example.datasekolah;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datasekolah.activity.DetailActivity;
import com.example.datasekolah.activity.MainActivity;
import com.example.datasekolah.model.readSiswa.ResponseReadSiswa;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<ResponseReadSiswa> dataReadSiswa;
    Context context;

    public RecyclerViewAdapter(Context context, ArrayList<ResponseReadSiswa> dataReadSiswa){

        this.context = context;
        this.dataReadSiswa = dataReadSiswa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String namaSiswa = dataReadSiswa.get(position).getNamaSiswa();
        String kelasSiswa = dataReadSiswa.get(position).getKelas();

        holder.txtNamaSiswa.setText(namaSiswa);
        holder.txtKelasSiswa.setText(kelasSiswa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.KEY_NAMA_SISWA, namaSiswa);
                intent.putExtra(DetailActivity.KEY_KELAS_SISWA, kelasSiswa);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataReadSiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaSiswa, txtKelasSiswa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaSiswa = itemView.findViewById(R.id.txtListNamaSiswa);
            txtKelasSiswa = itemView.findViewById(R.id.txtListKelasSiswa);
        }
    }
}
