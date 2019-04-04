package com.example.mycontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mycontact.entities.Kontak;
import com.example.mycontact.models.KontakModel;

import java.util.ArrayList;

public class LihatKontakActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // Data
    private KontakModel mKontak;
    private ArrayList<Kontak> allKontak;
    private ArrayList<String> daftarNama;

    // Komponen
    private ListView lstDaftarKontak;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kontak);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
        this.daftarNama = new ArrayList<>();

        this.mKontak = new KontakModel(this);
        this.allKontak = this.mKontak.selectAll();
        for(Kontak k : allKontak)
        {
            this.daftarNama.add(k.getNama());
        }
    }

    private void initComponents()
    {
        this.lstDaftarKontak = this.findViewById(R.id.lstDaftarKontak);
        this.btnOk = this.findViewById(R.id.btnOk);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, this.daftarNama);

        this.lstDaftarKontak.setAdapter(adapter);

        this.lstDaftarKontak.setOnItemClickListener(this);
    }

    private void openMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnOk)
            this.openMainActivity();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        int id = this.allKontak.get(i).getId();

        Intent intent = new Intent(this, DetailKontakActivity.class);
        intent.putExtra("selectedContactId", id);
        this.startActivity(intent);
    }
}