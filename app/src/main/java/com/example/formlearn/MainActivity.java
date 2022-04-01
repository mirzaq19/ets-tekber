package com.example.formlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    MyAdapter myAdapter;
    EditText etNama, etNrp, etIpk;
    RadioButton rbCheck;
    RadioGroup rbJk;
    ArrayList<Mahasiswa> mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = findViewById(R.id.etNama);
        etNrp = findViewById(R.id.etNrp);
        etIpk = findViewById(R.id.etIpk);
        rbJk = findViewById(R.id.rbJk);
        mhs = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        myAdapter = new MyAdapter(this,mhs);
        recyclerView.setAdapter(myAdapter);

    }

    public void onSubmit(View v){
        String nama = etNama.getText()+"";
        String nrp = etNrp.getText()+"";
        String ipk = etIpk.getText()+"";
        rbCheck = findViewById(rbJk.getCheckedRadioButtonId());
        String jk = rbCheck.getText()+"";

        Mahasiswa m = new Mahasiswa(nama,nrp,Double.parseDouble(ipk),jk);

        myAdapter.add(mhs.size(), m);

        Toast.makeText(this,"Berhasil menambahkan data",Toast.LENGTH_LONG).show();
    }

}