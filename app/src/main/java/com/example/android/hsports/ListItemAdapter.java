package com.example.android.hsports;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItemAdapter extends ArrayAdapter<ClothingItem> {

    private List<ClothingItem> items;

    Map<String, Bitmap> bitmaps = new HashMap<>();

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

//        int imageResource = getContext().getResources().getIdentifier(
//                item.getItemId(), "drawable", getContext().getPackageName());

//        Log.d("ListItemAdapter", item.getItemId() + ": " + imageResource);

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
//        iv.setImageResource(imageResource);

        Bitmap bitmap = getBitmapFromAsset(item.getItemId());
        iv.setImageBitmap(bitmap);


        return convertView;
    }

    private Bitmap getBitmapFromAsset(String itemId) {
        if (bitmaps.containsKey(itemId)) {
            return bitmaps.get(itemId);
        }

        AssetManager assetManager = getContext().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(itemId + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        bitmaps.put(itemId, bitmap);
        return bitmap;
    }


}
