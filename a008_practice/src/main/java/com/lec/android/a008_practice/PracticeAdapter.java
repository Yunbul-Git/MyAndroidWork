package com.lec.android.a008_practice;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PracticeAdapter extends RecyclerView.Adapter<PracticeAdapter.ViewHolder>{

    List<Practice> items = new ArrayList<Practice>();


    static PracticeAdapter adapter;

    public PracticeAdapter() {this.adapter = this;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inf =LayoutInflater.from(parent.getContext());

        View itemView = inf.inflate(R.layout.item, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Practice item = items.get(position);
        holder.setitem(item);
    }

    @Override
    public int getItemCount() {return items.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvAge, tvAddress;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }

        public void setitem(Practice item){
            tvName.setText(item.getName());
            tvAge.setText(item.getAge());
            tvAddress.setText(item.getAddress());
        }


    }//end ViewHolder
    public void addItem(Practice item) {items.add(item);}
    public void addItem(int position, Practice item) {items.add(position, item);}
    public void setItems(ArrayList<Practice> items) {this.items = items;}
    public Practice getItem(int position){return items.get(position);}
    public void setItems(int position, Practice item){items.set(position, item);}
    public void removeItem(int position){items.remove(position);}

}//end Adapter
