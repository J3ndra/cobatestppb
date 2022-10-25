package com.junianto.cobautsppb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.junianto.cobautsppb.DetailActivity;
import com.junianto.cobautsppb.R;
import com.junianto.cobautsppb.model.MenuModel;

import java.util.ArrayList;

public class MenuAdapterLinear extends RecyclerView.Adapter<MenuAdapterLinear.myViewHolderList> {

    ArrayList<MenuModel> modelArrayList;
    Context context;

    public MenuAdapterLinear(ArrayList<MenuModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item_linear, parent, false);

        return new MenuAdapterLinear.myViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolderList holder, int position) {
        holder.gambar_menu.setImageResource(modelArrayList.get(position).getGambarMenu());
        holder.c_nama_menu.setText(modelArrayList.get(position).getNamaMenu());
        holder.c_harga_menu.setText(String.valueOf(modelArrayList.get(position).getHargaMenu()));
        holder.c_satuan_menu.setText(modelArrayList.get(position).getSatuanMenu());
        holder.cv_item.setOnClickListener(v -> {
            Toast.makeText(context, modelArrayList.get(position).getNamaMenu(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("gambarMenu", modelArrayList.get(position).getGambarMenu());
            intent.putExtra("namaMenu", modelArrayList.get(position).getNamaMenu());
            intent.putExtra("hargaMenu", modelArrayList.get(position).getHargaMenu());
            intent.putExtra("satuanMenu", modelArrayList.get(position).getSatuanMenu());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    protected class myViewHolderList extends RecyclerView.ViewHolder {
        LinearLayout cv_item;
        ImageView gambar_menu;
        TextView c_nama_menu, c_harga_menu, c_satuan_menu;
        public myViewHolderList(@NonNull View itemView) {
            super(itemView);
            cv_item = itemView.findViewById(R.id.item_menu);
            gambar_menu = itemView.findViewById(R.id.iv_foto_makanan);
            c_nama_menu = itemView.findViewById(R.id.tv_nama_makanan);
            c_harga_menu = itemView.findViewById(R.id.tv_harga_makanan);
            c_satuan_menu = itemView.findViewById(R.id.tv_satuan_makanan);
        }
    }
}
