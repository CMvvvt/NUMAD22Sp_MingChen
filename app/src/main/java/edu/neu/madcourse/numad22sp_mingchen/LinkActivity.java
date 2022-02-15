package edu.neu.madcourse.numad22sp_mingchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkActivity extends AppCompatActivity {

    private ArrayList<UrlItem> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UrlAdapter urlAdapter;
    private RecyclerView.LayoutManager uLayoutManager;
    private EditText name;
    private EditText url;
    private ImageView add;
    private FloatingActionButton addButton;
    private Toast t;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);


        init(savedInstanceState);


//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String text =  input.getText().toString();
//                if(text == null || text.length() == 0) {
//                    makeToast("Enter an item.");
//                } else {
//                    int pos = 0;
//                    addItem(pos);
//                }
//            }
//        });
    }

//    private void addItem(int pos) {
//        name = findViewById(R.id.name);
//        url = findViewById(R.id.url);
//    }


    private void makeToast(String s) {
        if(t != null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        t.show();
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