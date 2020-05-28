package com.example.tugasproject3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Hitung extends AppCompatActivity {

    TextView BangunRuang, hasilBangunRuang;
    TextInputLayout nilai1, nilai2;
    ImageView imgBagunRuang;
    Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hitung);

        BangunRuang = findViewById(R.id.BangunRuang);
        hasilBangunRuang = findViewById(R.id.hasil);
        imgBagunRuang = findViewById(R.id.gambarBangunRuang);
        nilai1 = findViewById(R.id.Nilai1);
        nilai2 = findViewById(R.id.Nilai2);

        i = getIntent();

        ubah(i);
    }

    private void ubah(Intent i){
        switch (i.getStringExtra("Bangun Ruang")) {
            case "Kerucut" :
                getSupportActionBar().setTitle("Hitung Volume Kerucut");
                BangunRuang.setText("Kerucut");
                imgBagunRuang.setImageResource(R.drawable.kerucut);
                nilai1.setHint("Jari Jari Alas");
                nilai2.setHint("Tinggi");
                break;
            case "Balok" :
                getSupportActionBar().setTitle("Hitung Volume Balok");
                BangunRuang.setText("Balok");
                imgBagunRuang.setImageResource(R.drawable.balok);
                nilai1.setHint("Panjang");
                nilai2.setHint("Tinggi");
                //nilai3.setHint("Lebar");
                break;
            case "Prisma Segilima" :
                getSupportActionBar().setTitle("Hitung Volume Prisma Segilima");
                BangunRuang.setText("Prisma Segilima");
                imgBagunRuang.setImageResource(R.drawable.prismasegilima);
                nilai1.setHint("Luas Alas");
                nilai2.setHint("Tinggi");
                break;
            case "Limas Segilima" :
                getSupportActionBar().setTitle("Hitung Volume Limas Segilima");
                BangunRuang.setText("Limas Segilima");
                imgBagunRuang.setImageResource(R.drawable.limassegilima);
                nilai1.setHint("Luas Alas");
                nilai2.setHint("Tinggi");
                break;
        }
    }

    public void prosesHitung(View view) {
        double nilai_1, nilai_2, hasilKerucut, hasilBalok, hasilPrisma, hasilLimas;

        String nil1 = nilai1.getEditText().getText().toString();
        String nil2 = nilai2.getEditText().getText().toString();

        if (!nil1.equals("")||!nil2.equals("")) {
            nilai_1 = Double.parseDouble(nil1);
            nilai_2 = Double.parseDouble(nil2);

            switch (i.getStringExtra("Bangun Ruang")) {
                case "Kerucut" :
                    hasilKerucut = (0.3 * 3.14 * (nilai_1 * nilai_1) * nilai_2);
                    hasilBangunRuang.setText("Volume Kerucut "+hasilKerucut);
                    break;
                case "Balok" :
                    hasilBalok = nilai_1 * nilai_2; //* nilai_3;
                    hasilBangunRuang.setText("Volume Balok :"+hasilBalok);
                    break;
                case "Prisma Segilima" :
                    hasilPrisma = nilai_1 * nilai_2;
                    hasilBangunRuang.setText("Volume Prisma Segilima : "+hasilPrisma);
                    break;
                case "Limas Segilima" :
                    hasilLimas = (0.3 * (nilai_1 * nilai_2));
                    hasilBangunRuang.setText("Volume Limas Segilima : "+hasilLimas);
                    break;
            }
        }
        else  {
            Toast.makeText(Hitung.this, "Nilai Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
