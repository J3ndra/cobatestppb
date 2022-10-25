package com.junianto.cobautsppb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.junianto.cobautsppb.adapter.MenuAdapterGrid;
import com.junianto.cobautsppb.adapter.MenuAdapterLinear;
import com.junianto.cobautsppb.model.MenuModel;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ArrayList<MenuModel> modelArrayList = new ArrayList<>();
    RecyclerView recyclerView_menu;

    int gambarMenu[] = {
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7,
            R.drawable.menu8,
            R.drawable.menu9
    };

    String namaMenu[] = {
            "Nasi Goreng",
            "Soto Madura",
            "Ayam Goreng",
            "Nasi Kuning",
            "Nasi Rames",
            "Nasi Gudeg",
            "Soto Sapi",
            "Bubur Ayam",
            "Bakso Sapi"
    };

    int hargaMenu[] = {
            17000,
            18000,
            22000,
            14000,
            12000,
            13000,
            15000,
            12000,
            17000,
    };

    String satuanMenu[] = {
            "Piring",
            "Mangkok",
            "Ekor",
            "Pincuk",
            "Piring",
            "Pincuk",
            "Mangkok",
            "Mangkok",
            "Mangkok"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView_menu = findViewById(R.id.rv_menu);

        showRecyclerList();
    }

    private void baca_menu_makanan() {
        for(int i=0; i<namaMenu.length; i++) {
            modelArrayList.add(new MenuModel(
                    namaMenu[i],
                    hargaMenu[i],
                    satuanMenu[i],
                    gambarMenu[i]
            ));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            showRecyclerList();
        } else {
            showRecyclerGrid();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerGrid() {
        baca_menu_makanan();

        MenuAdapterGrid menuAdapterGrid = new MenuAdapterGrid(modelArrayList, this);
        recyclerView_menu.setAdapter(menuAdapterGrid);
        recyclerView_menu.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void showRecyclerList() {
        baca_menu_makanan();

        MenuAdapterLinear menuAdapterLinear = new MenuAdapterLinear(modelArrayList, this);
        recyclerView_menu.setAdapter(menuAdapterLinear);
        recyclerView_menu.setLayoutManager(new LinearLayoutManager(this));
    }
}