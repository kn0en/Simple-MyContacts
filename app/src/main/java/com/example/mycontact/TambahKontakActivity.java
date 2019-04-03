package com.example.mycontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycontact.entities.Kontak;
import com.example.mycontact.models.KontakModel;

public class TambahKontakActivity extends AppCompatActivity {

    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private Button btnSimpan;
    private Button btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kontak);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
// Sementara dikosongkan dulu..
    }

    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.btnSimpan = (Button) this.findViewById(R.id.btnSimpan);
        this.btnBatal = (Button) this.findViewById(R.id.btnBatal);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnSimpan)
        {
            this.tambahKontak();
        }
        else if(b == this.btnBatal)
        {
            this.finish();
        }
    }

    private void tambahKontak()
    {
// Disini dilakukan penyimpanan kontak baru ke database
    }
}