package com.example.android.hsports;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

public class ListItemAdapter extends ArrayAdapter<ClothingItem> {

    private List<ClothingItem> items;

    public ListItemAdapter(Context context, int resource, List<ClothingItem> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        ClothingItem item = items.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(item.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(item.getPrice());
        TextView priceText = (TextView) convertView.findViewById(R.id.priceText);
        priceText.setText(price);

        int imageResource = getContext().getResources().getIdentifier(
                item.getItemId(), "drawable", getContext().getPackageName());

        Log.d("ListItemAdapter", item.getItemId() + ": " + imageResource);

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

        return convertView;
    }
}
