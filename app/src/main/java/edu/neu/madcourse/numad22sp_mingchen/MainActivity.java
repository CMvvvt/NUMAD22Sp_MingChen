package edu.neu.madcourse.numad22sp_mingchen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class MainActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }


    public void buttonInfo(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutMeActivity.class);
        startActivity(intent);
    }

    public void clickButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ClickyActivity.class);
        startActivity(intent);
    }

    public void linkButton(View view) {
        Intent intent = new Intent(getApplicationContext(), LinkActivity.class);
        startActivity(intent);
    }

    public void locationButton(View view) {
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
    }

    public void serviceButton(View view) {
        startActivity(new Intent(getApplicationContext(), serviceActivity.class));
    }
}
