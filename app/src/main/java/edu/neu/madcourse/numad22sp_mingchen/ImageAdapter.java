package edu.neu.madcourse.numad22sp_mingchen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<String> {

    List<ImageItem> list;
    Context context;
    public ImageAdapter(@NonNull Context context, List<ImageItem> list) {
        super(context, R.layout.image_item);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.image_item, parent, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        Glide.with(convertView).load(list.get(position).getUrl()).into(imageView);
        return convertView;
    }
}
