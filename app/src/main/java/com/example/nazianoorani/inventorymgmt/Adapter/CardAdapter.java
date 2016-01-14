package com.example.nazianoorani.inventorymgmt.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazianoorani.inventorymgmt.DTO.ItemDetails;
import com.example.nazianoorani.inventorymgmt.R;

import java.util.ArrayList;

/**
 ** Created by nazianoorani on 23/12/15.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    ArrayList<ItemDetails> itemList = new ArrayList<ItemDetails>();

    public CardAdapter() {
        ItemDetails itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 1");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 2");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 3");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 4");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 5");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 6");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 7");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 8");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 9");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);
        itemDetails = new ItemDetails();
        itemDetails.setItemName("Product 10");
        itemDetails.setItemImage(R.drawable.img_item);
        itemList.add(itemDetails);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemDetails itemDetails = itemList.get(position);
        holder.itemNameTextView.setText(itemDetails.getItemName());
        holder.itemImgView.setImageResource(itemDetails.getItemImage());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView itemSizeTextView;
        ImageView itemImgView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImgView = (ImageView) itemView.findViewById(R.id.img);
            itemNameTextView = (TextView) itemView.findViewById(R.id.textView);
            itemSizeTextView = (TextView)itemView.findViewById(R.id.textView2);
        }

    }


}