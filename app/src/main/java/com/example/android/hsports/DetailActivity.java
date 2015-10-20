package com.example.android.hsports;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

        String itemId = getIntent().getStringExtra("itemId");
        setTitle(getString(R.string.app_name));
        ClothingItem item = DataProvider.itemMap.get(itemId);

        if (item == null) {
            Toast.makeText(this, "Product id not found: " + itemId,
                    Toast.LENGTH_SHORT).show();
        } else {
            displayItemDetails(item);
        }

    }

    private void displayItemDetails(ClothingItem item) {
        TextView nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(item.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(item.getPrice());
        TextView priceText = (TextView) findViewById(R.id.priceText);
        priceText.setText(price);

        TextView descText = (TextView) findViewById(R.id.descriptionText);
        descText.setText(item.getDescription() + "\n");

        int imageResource = getResources().getIdentifier(
                item.getItemId(), "drawable", getPackageName());
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(imageResource);
    }

}