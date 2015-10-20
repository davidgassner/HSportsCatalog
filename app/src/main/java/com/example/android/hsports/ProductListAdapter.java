package com.example.android.hsports;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
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

public class ProductListAdapter extends ArrayAdapter<Product> {

    private List<Product> products;

    Map<String, Bitmap> bitmaps = new HashMap<>();

    public ProductListAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        products = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        Product product = products.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(product.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView priceText = (TextView) convertView.findViewById(R.id.priceText);
        priceText.setText(price);

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(product.getProductId());
        iv.setImageBitmap(bitmap);

        return convertView;
    }

    private Bitmap getBitmapFromAsset(String productId) {
        if (bitmaps.containsKey(productId)) {
            return bitmaps.get(productId);
        }

        Log.d(this.getClass().getSimpleName(), "Getting asset for " + productId);
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;
        try {
            stream = assetManager.open(productId + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        bitmaps.put(productId, bitmap);

        return bitmap;
    }


}
