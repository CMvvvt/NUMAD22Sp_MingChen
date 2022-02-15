package edu.neu.madcourse.numad22sp_mingchen;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UrlHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemUrl;


    public UrlHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        this.itemName = itemView.findViewById(R.id.item_name);
        this.itemUrl = itemView.findViewById(R.id.item_url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    int position = getLayoutPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });

//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(listener != null) {
//                    int position = getLayoutPosition();
//                    if (position != RecyclerView.NO_POSITION) {
//                        listener.onCheckBoxCLick(position);
//                    }
//                }
//            }
//        });

    }
}
