package com.example.homeshome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context context;
    private List<Home> homeList;

    public HomeAdapter(Context context, List<Home> homeList) {
        this.context = context;
        this.homeList = homeList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.show_data_rumah, null);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Home home = homeList.get(position);
        Glide.with(context)
                .load(home.getGambar())
                .into(holder.imageRumah);
        holder.txtjbayar.setText("Pembayaran : "+String.valueOf(home.getJbayar()));
        holder.txtalamat.setText(home.getAlamat());
        holder.txtharga.setText("Rp. "+String.valueOf(home.getHarga()));
        holder.txtket.setText(home.getKet());
        holder.txtltanah.setText("LT : "+String.valueOf(home.getLtanah())+" m\u00B2");
        holder.txtlbangunan.setText("LB : "+String.valueOf(home.getLbangunan())+" m\u00B2");
        holder.txtbkamar.setText(""+String.valueOf(home.getBkamar()));
        holder.txtbkmandi.setText(""+String.valueOf(home.getBkmandi()));
        holder.txtgarasi.setText(""+String.valueOf(home.getBgarasi()));
        holder.txtjrumah.setText(home.getJhome());
    }

    @Override
    public int getItemCount() {
        int a;
        if(homeList != null && !homeList.isEmpty()){
            a = homeList.size();
        }else{
            a = 0;
        }
        return a;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView txtjbayar, txtjrumah, txtalamat, txtket, txtharga, txtltanah, txtlbangunan, txtbkamar, txtbkmandi, txtgarasi;
        ImageView imageRumah;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtjbayar = (TextView)itemView.findViewById(R.id.txtjbayar);
            txtjrumah = (TextView)itemView.findViewById(R.id.txtjrumah);
            txtharga = (TextView)itemView.findViewById(R.id.txtharga);
            txtalamat = (TextView)itemView.findViewById(R.id.txtalamat);
            txtket = (TextView)itemView.findViewById(R.id.txtket);
            txtltanah = (TextView)itemView.findViewById(R.id.txtltanah);
            txtlbangunan = (TextView)itemView.findViewById(R.id.txtlbangunan);
            txtbkamar = (TextView)itemView.findViewById(R.id.txtbkamar);
            txtbkmandi = (TextView)itemView.findViewById(R.id.txtbkmandi);
            txtgarasi = (TextView)itemView.findViewById(R.id.txtbgarasi);
            imageRumah = (ImageView)itemView.findViewById(R.id.imageRumah);
        }
    }

}
