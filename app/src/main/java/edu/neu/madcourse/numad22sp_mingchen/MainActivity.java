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
        Button clickyButton = (Button)this.findViewById(R.id.clicky);
        clickyButton.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent Intent = new Intent((Context)MainActivity.this, ClickyActivity.class);
                MainActivity.this.startActivity(Intent);
            }
        }));
    }

    @SuppressLint("WrongConstant")
    public final void buttonInfo(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Toast.makeText((Context)this, (CharSequence)"Ming Chen, chen.ming1@northeastern.edu", 0).show();
    }
}
