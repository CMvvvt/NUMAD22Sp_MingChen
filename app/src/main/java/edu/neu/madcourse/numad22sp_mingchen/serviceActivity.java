package edu.neu.madcourse.numad22sp_mingchen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serviceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";
    private EditText searchQuery;
    private TextView mTitleTextView;
    private ListView listView;
    private JSONArray jsonArray;
    private List<ImageItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        searchQuery = findViewById(R.id.search);
        listView = findViewById(R.id.iamge_list);
        mTitleTextView = (TextView)findViewById(R.id.result_textview);
        list = new ArrayList<ImageItem>();



    }



    public void handle(View view) {
        Handler handler = new Handler();
        searchQuery = (EditText)findViewById(R.id.search);
        Runnable runnable = new Runnable() {
            URL url = null;
            @Override
            public void run() {
                try {
                    url = new URL("https://api.unsplash.com/search/photos/?client_id=VhS_F9fpOnkoEiKdugkb0N3xxTE_2FS_cKqC0DkoAo8&page=1&query="
                            +searchQuery.getText());
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    int responseCode = urlConnection.getResponseCode();
                    Log.i("Code", String.valueOf(responseCode));
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    String s = convertStreamToString(in);
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    list = convertToList(jsonArray);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    Log.e(TAG,"JSONException");
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(list.size() == 0) {
                            Toast.makeText(getApplicationContext(), "No Such Images Found", Toast.LENGTH_LONG).show();
                        }
                        ArrayAdapter<String> arrayAdapter = new ImageAdapter(getApplicationContext(), list);
                        listView.setAdapter(arrayAdapter);
                    }
                });
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();
    }


    private String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next().replace(",", ",\n") : "";
    }


    private static List<ImageItem> convertToList(JSONArray jsonArray) {
        List<ImageItem> list = new ArrayList<>();
        for(int i = 0; i < 10 && i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            String name = (String) jsonObject.optString("id");
            String url = jsonObject.optJSONObject("urls").optString("raw");
            list.add(new ImageItem(name, url));
        }

        return list;
    }
}