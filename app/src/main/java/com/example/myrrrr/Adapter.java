package com.example.myrrrr;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<DataModel> dataModels;
    private ArrayList<DataModel> filteredList;

    public Adapter(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
        this.filteredList = new ArrayList<>(dataModels);
    }
    public Adapter(Context context, ArrayList<DataModel> dataModels){
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);

        return new Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.textView2.setText(dataModels.get(position).getName());
        holder.imageView.setImageResource(dataModels.get(position).getImage());
        holder.textView.setText(dataModels.get(position).getDescription());
    }

    public void setFilteredList(List<DataModel> filteredList) {
        this.dataModels = new ArrayList<>(filteredList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public ArrayList<DataModel> getDataList() {
        return dataModels;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public TextView textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find views by ID and assign them to the member variables
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

}
