package com.example.formlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    ArrayList<Mahasiswa> mhs;
    Context context;

    MahasiswaAdapter(Context context1, ArrayList<Mahasiswa> mhs1) {
        mhs = mhs1;
        context = context1;
    }

    public void add(int position, Mahasiswa item) {
        mhs.add(position, item);
        notifyItemInserted(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvNrp;
        TextView tvIpk;
        TextView tvJk;

        ViewHolder(View v) {
            super(v);
            tvNama = v.findViewById(R.id.tvNama);
            tvNrp = v.findViewById(R.id.tvNrp);
            tvIpk = v.findViewById(R.id.tvIpk);
            tvJk = v.findViewById(R.id.tvJk);

        }
    }

    @NonNull
    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mhs_itemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNama.setText(mhs.get(position).getNama());
        holder.tvNrp.setText(mhs.get(position).getNrp());
        holder.tvIpk.setText(context.getString(R.string.double_format,mhs.get(position).getIpk()));
        holder.tvJk.setText(mhs.get(position).getJenis_kelamin());
    }

    @Override
    public int getItemCount() {
        return mhs.size();
    }
}
