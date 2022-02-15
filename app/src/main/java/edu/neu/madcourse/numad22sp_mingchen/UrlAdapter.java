package edu.neu.madcourse.numad22sp_mingchen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UrlAdapter extends RecyclerView.Adapter<UrlHolder> {
    private final ArrayList<UrlItem> itemList;
    private ItemClickListener listener;

    public UrlAdapter(ArrayList<UrlItem> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UrlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new UrlHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UrlHolder holder, int position) {
        UrlItem currentItem = itemList.get(position);

        holder.itemName.setText(currentItem.getItemName());
        holder.itemUrl.setText(currentItem.getItemUrl());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
