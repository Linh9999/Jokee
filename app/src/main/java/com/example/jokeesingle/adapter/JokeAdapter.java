package com.example.jokeesingle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jokeesingle.R;
import com.example.jokeesingle.model.Item;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder>  {

    private List<Item> listData;
    isActive click;

    public JokeAdapter(List<Item> listData, isActive click) {
        this.click=click;
        this.listData = listData;
    }

    public void setData(List<Item>list){
        this.listData =list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.item_jokes, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item element = listData.get(position);
        holder.txtDescription.setText(element.getStrJoke());
        holder.txtName.setText(element.getName());
        holder.btnLike.setOnClickListener(v->{
            click.clickLike(position);
            Toast.makeText(v.getContext(), "That funny", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });
        holder.btnDislike.setOnClickListener(v->{
            click.clickLike(position);
            Toast.makeText(v.getContext(), "That Boring", Toast.LENGTH_SHORT).show();
            notifyDataSetChanged();
        });
        if(element.getActive()=="like"){
            holder.btnLike.setBackgroundResource(R.drawable.shape_button_active);
        }
        if (element.getActive()=="dislike"){
            holder.btnDislike.setBackgroundResource(R.drawable.shape_button_active);
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtDescription;
        public ImageView btnLike,btnDislike;

        public ViewHolder(View itemView) {

            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtDescription = (TextView) itemView.findViewById(R.id.description);
            btnLike = (ImageView) itemView.findViewById(R.id.btnLike);
            btnDislike = (ImageView) itemView.findViewById(R.id.btnDislike);
        }
    }
    public interface isActive{
        void clickLike(int position);
        void clickDisLike(int position);
    }
}
