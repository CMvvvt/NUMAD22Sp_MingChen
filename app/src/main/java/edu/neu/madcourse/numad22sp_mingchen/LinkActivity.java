package edu.neu.madcourse.numad22sp_mingchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
    private static final String URL_NOT_MATCH = "Input Url is not valid!";
    private static final String NO_NAME_OR_URL = "Please enter Name and Url!";
    private static final String SUCCESS_CREATED = "Url created!";

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
                    showSnackBar(NO_NAME_OR_URL);
                    return;
                }

                //Check if the entered url is valid or not
                if(!Patterns.WEB_URL.matcher(urlStr).matches()) {
                    showSnackBar(URL_NOT_MATCH);
                    return;
                }

                int pos = 0;
                addItem(pos);
                showSnackBar(SUCCESS_CREATED);

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

    @SuppressLint("ResourceType")
    private void showSnackBar(String s) {
        Snackbar snackbar;
        RelativeLayout mainLayout = findViewById(R.id.main_layout);

        snackbar = Snackbar.make(mainLayout, s, Snackbar.LENGTH_SHORT);
        snackbar.show();
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
        return;
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

                // Create correct form for url to open
                if(!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }

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