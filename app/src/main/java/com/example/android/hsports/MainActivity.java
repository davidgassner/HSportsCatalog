package com.example.android.hsports;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.main_activity_title));

        final List<ClothingItem> itemList = DataProvider.itemList;
        Map<String, ClothingItem> itemMap = DataProvider.itemMap;

        ListView lv = (ListView) findViewById(R.id.listView);

//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(this,
//                        android.R.layout.simple_list_item_1,
//                        android.R.id.text1, DataProvider.getItemNames());
        ArrayAdapter<ClothingItem> adapter =
                new ListItemAdapter(this, R.layout.list_item, itemList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                ClothingItem item = itemList.get(position);
                intent.putExtra("itemId", item.getItemId());
                startActivity(intent);
            }
        });


//        String msg = "List items: " + itemList.size() + ", map items: " + itemMap.size();
//        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
