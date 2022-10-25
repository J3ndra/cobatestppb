package com.junianto.cobautsppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAlamat, btnTelp, btnEmail, btnPesanMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlamat = findViewById(R.id.btn_alamat);
        btnTelp = findViewById(R.id.btn_telp);
        btnEmail = findViewById(R.id.btn_email);
        btnPesanMakanan = findViewById(R.id.btn_rv);

        btnAlamat.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.9802167,110.4055873?q=-6.9802167,110.4055873(Kos @ Jalan Bima)"));
            startActivity(intent);
        });

        btnTelp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:082135364500"));
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Uri uri = Uri.parse("mailto:" + "111202113319@mhs.dinus.ac.id")
                    .buildUpon()
                    .appendQueryParameter("subject", "Junianto Endra K.")
                    .appendQueryParameter("body", "Halo.")
                    .build();

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(Intent.createChooser(emailIntent, "Test Email"));
        });

        btnPesanMakanan.setOnClickListener(v -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });
    }
}