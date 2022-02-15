package edu.neu.madcourse.numad22sp_mingchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkActivity extends AppCompatActivity {

    private ArrayList<UrlItem> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UrlAdapter urlAdapter;
    private RecyclerView.LayoutManager uLayoutManager;
    private FloatingActionButton addButton;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);


        init(savedInstanceState);

    }


    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void initialItemData(Bundle savedInstanceState) {
        UrlItem item1 = new UrlItem("Google", "https://www.google.com/", false);
        itemList.add(item1);
    }


    private void createRecyclerView() {
        uLayoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.urlList);
        recyclerView.setHasFixedSize(true);

        urlAdapter = new UrlAdapter(itemList);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemList.get(position).onItemClick(position);
                urlAdapter.notifyItemChanged(position);
            }
        };


        urlAdapter.setOnItemClickListener(itemClickListener);
        recyclerView.setAdapter(urlAdapter);
        recyclerView.setLayoutManager(uLayoutManager);
    }
}