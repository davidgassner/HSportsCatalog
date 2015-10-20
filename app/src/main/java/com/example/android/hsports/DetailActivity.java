package com.example.android.hsports;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String productId = getIntent().getStringExtra(MainActivity.EXTRA_ID);
        setTitle(getString(R.string.app_name));
        Product product = DataProvider.productMap.get(productId);

        if (product == null) {
            Toast.makeText(this, "Product id not found: " + productId,
                    Toast.LENGTH_SHORT).show();
        } else {
            displayDetails(product);
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

        int imageResource = getResources().getIdentifier(
                product.getProductId(), "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

    }

}