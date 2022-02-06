package edu.neu.madcourse.numad22sp_mingchen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.Nullable;


public final class ClickyActivity extends AppCompatActivity {
    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_clicky);
    }


    public void onClick(View view) {
        TextView tv = (TextView) findViewById(R.id.press);
        Button button = (Button)view;
        String buttonText = button.getText().toString();
        tv.setText("Pressed: " + buttonText);
    }

}


