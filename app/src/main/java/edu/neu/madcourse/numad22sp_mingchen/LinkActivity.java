package edu.neu.madcourse.numad22sp_mingchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
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


        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        add = findViewById(R.id.add);
        init(savedInstanceState);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr =  name.getText().toString();
                String urlStr = url.getText().toString();
                if(nameStr == null || nameStr.length() == 0 || urlStr == null || urlStr.length() == 0) {
                    makeToast("Enter a url!");
                } else {
                    int pos = 0;
                    addItem(pos);
                }
            }
        });
    }

    private void addItem(int pos) {
        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        UrlItem item = new UrlItem(name.getText().toString(), url.getText().toString(), false);
        itemList.add(item);

        urlAdapter.notifyDataSetChanged();

        name.setText("");
        url.setText("");
        makeToast("Added your url!");
    }


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
                String url = itemList.get(position).getItemUrl().toString();
                makeToast(url);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                urlAdapter.notifyItemChanged(position);
            }
        };


        urlAdapter.setOnItemClickListener(itemClickListener);
        recyclerView.setAdapter(urlAdapter);
        recyclerView.setLayoutManager(uLayoutManager);
    }
}