package com.example.android.hsports;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//import java.util.List;
import java.util.Map;
import java.util.Set;

//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.main_activity_title));

//        List<ClothingItem> itemList = DataProvider.itemList;
        Map<String, ClothingItem> itemMap = DataProvider.itemMap;

        ListView lv = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1, DataProvider.getItemNames());

        lv.setAdapter(adapter);

//        String msg = "List items: " + itemList.size() + ", map items: " + itemMap.size();
//        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
