package com.example.android.hsports;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String productId = getIntent().getStringExtra(MainActivity.EXTRA_ID);
        setTitle(getString(R.string.app_name));
        Product product = DataProvider.productMap.get(productId);

        if (product == null) {
            Toast.makeText(this, "Product id not found: " + productId,
                    Toast.LENGTH_SHORT).show();
        } else {
            displayDetails(product);
        }

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    private void displayDetails(Product product) {
        TextView nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(product.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView priceText = (TextView) findViewById(R.id.priceText);
        priceText.setText(price);

        TextView descText = (TextView) findViewById(R.id.descriptionText);
        descText.setText(product.getDescription());

        String imageFile = product.getProductId() + ".png";
        AssetManager assetManager = getAssets();
        InputStream stream = null;
        try {
            stream = assetManager.open(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(stream);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bitmap);

    }

}