package com.example.mycontact;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycontact.entities.Kontak;
import com.example.mycontact.models.KontakModel;

public class DetailKontakActivity extends AppCompatActivity {

    // Data
    private KontakModel mKontak;
    private Kontak selectedKontak;

    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private Button btnUbah;
    private Button btnHapus;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kontak);

        this.initData();
        this.initComponents();
    }

    private void initData()
    {
        this.mKontak = new KontakModel(this);
        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);

        this.selectedKontak = this.mKontak.selectOne(selectedContactId);
    }

    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.btnUbah = (Button) this.findViewById(R.id.btnUbah);
        this.btnHapus = (Button) this.findViewById(R.id.btnHapus);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);

        // Isi teks pada komponen saat Activity baru dimunculkan
        this.txtNama.setText(this.selectedKontak.getNama());
        this.txtNomor.setText(this.selectedKontak.getNomor());
    }

    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnUbah)
        {
            this.ubahKontak();
        }
        else if(b == this.btnHapus)
        {
            this.hapusKontak();
        }
        else if(b == this.btnKembali)
        {
            this.recreateActivityCompat();

        }
    }

    private void ubahKontak()
    {
// Logic untuk meng-UPDATE kontak diletakkan disini..
        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        this.selectedKontak.setNama(nama);
        this.selectedKontak.setNomor(nomor);

        this.mKontak.update(this.selectedKontak);
        this.resetFields("Data berhasil diperbarui!", false);
        this.recreateActivityCompat();

    }

    private void hapusKontak()
    {
// Hapus kontak disini..
        this.mKontak.delete(this.selectedKontak);
        this.resetFields("Kontak dihapus..", true);
        this.btnHapus.setEnabled(false);
        this.recreateActivityCompat();
    }

    private void resetFields(String pesan, boolean clear)
    {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    private void recreateActivityCompat() {
        Intent reOpen = new Intent (this, LihatKontakActivity.class);
        overridePendingTransition( 0, 0);
        this.startActivity(reOpen);
        this.finish();
        overridePendingTransition( 0, 0);

    }

}