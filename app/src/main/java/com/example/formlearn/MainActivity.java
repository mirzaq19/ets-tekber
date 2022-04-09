package com.example.formlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    MahasiswaAdapter mhsAdapter;
    ArrayList<Mahasiswa> mhs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);

        recyclerView = findViewById(R.id.mahasiswa_list);
        recyclerView.setHasFixedSize(true);
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        mhsAdapter = new MahasiswaAdapter(this,mhs);
        recyclerView.setAdapter(mhsAdapter);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.save_button) {

            EditText etNama = findViewById(R.id.etNama);
            EditText etNrp = findViewById(R.id.etNrp);
            EditText etIpk = findViewById(R.id.etIpk);
            RadioButton rbLk = findViewById(R.id.rbLk);
            RadioButton rbPr = findViewById(R.id.rbPr);

            String nama = etNama.getText()+"";
            String nrp = etNrp.getText()+"";
            String ipk = etIpk.getText()+"";
            boolean isLaki = rbLk.isChecked();
            boolean isPerempuan = rbPr.isChecked();

            try{
                if(nama.isEmpty()){
                    throw new IllegalArgumentException("Anda belum mengisi nama");
                }
                if(nrp.isEmpty()){
                    throw new IllegalArgumentException("Anda belum mengisi NRP");
                }
                if(ipk.isEmpty()){
                    throw new IllegalArgumentException("Anda belum mengisi IPK");
                }
                double ipk_double = Double.parseDouble(ipk);
                if(ipk_double<0.0 || ipk_double>4.0){
                    throw new NumberFormatException("Ipk harus lebih dari 0 dan kurang dari 4");
                }
                if(!isLaki && !isPerempuan){
                    throw new IllegalArgumentException("Anda belum mengisi jenis kelamin");
                }
                Mahasiswa m = new Mahasiswa(nama,nrp,ipk_double,isLaki);
                mhsAdapter.add(mhs.size(), m);
                Toast.makeText(this,"Berhasil menambahkan data",Toast.LENGTH_LONG).show();
            } catch (IllegalArgumentException e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    }
}