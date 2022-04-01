package com.example.formlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<Mahasiswa> mhs;
    Context context;

    MyAdapter(Context context1, ArrayList<Mahasiswa> mhs1) {
        mhs = mhs1;
        context = context1;
    }

    public void add(int position, Mahasiswa item) {
        mhs.add(position, item);
        notifyItemInserted(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.textItem);
        }
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mhs.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mhs.size();
    }
}
