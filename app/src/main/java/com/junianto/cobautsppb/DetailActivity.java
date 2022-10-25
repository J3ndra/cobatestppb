package com.junianto.cobautsppb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView IVimageMenuMakanan;
    TextView tvNamaMenu, tvHargaMenu, tvSatuanMenu;
    TextView tvTotal, tvJumlah;
    Button btnMinus, btnPlus;

    int tampungTotal = 0;
    int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        IVimageMenuMakanan = findViewById(R.id.iv_foto_makanan);
        tvNamaMenu = findViewById(R.id.tv_nama_makanan);
        tvHargaMenu = findViewById(R.id.tv_harga_makanan);
        tvSatuanMenu = findViewById(R.id.tv_satuan_makanan);
        tvTotal = findViewById(R.id.tv_total);
        tvJumlah = findViewById(R.id.tv_jumlah);
        btnMinus = findViewById(R.id.btn_minus);
        btnPlus = findViewById(R.id.btn_plus);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra("namaMenu");
        setActionBarTitle(title);

        getExtra();

        tvTotal.setText(String.valueOf(tampungTotal));

        btnPlus.setOnClickListener(v -> {
            addTotal();
        });

        btnMinus.setOnClickListener(v -> {
            minusTotal();
        });
    }

    private void getExtra() {
        if(getIntent().hasExtra("gambarMenu") && getIntent().hasExtra("namaMenu") && getIntent().hasExtra("hargaMenu") && getIntent().hasExtra("satuanMenu")) {
            int gambarMenu = getIntent().getIntExtra("gambarMenu", R.drawable.menu1);
            String namaMenu = getIntent().getStringExtra("namaMenu");
            int hargaMenu = getIntent().getIntExtra("hargaMenu", 0);
            String satuanMenu = getIntent().getStringExtra("satuanMenu");

            setData(gambarMenu, namaMenu, hargaMenu, satuanMenu);
        }
    }

    private void setData(int gambarMenu, String namaMenu, int hargaMenu, String satuanMenu) {
        IVimageMenuMakanan.setImageResource(gambarMenu);
        tvNamaMenu.setText(namaMenu);
        tvHargaMenu.setText(String.valueOf(hargaMenu));
        tvSatuanMenu.setText(satuanMenu);
        totalPrice = hargaMenu;
        tvTotal.setText(String.valueOf(totalPrice));
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void addTotal() {
        tampungTotal=tampungTotal+1;

        tvTotal.setText(String.valueOf(tampungTotal));
        tvJumlah.setText(String.valueOf(calcTotalPrice()));
    }

    private void minusTotal() {
        if(tampungTotal!=0) {
            tampungTotal=tampungTotal-1;
        }

        tvTotal.setText(String.valueOf(tampungTotal));
        tvJumlah.setText(String.valueOf(calcTotalPrice()));
    }

    private int calcTotalPrice() {
        return totalPrice * tampungTotal;
    }
}