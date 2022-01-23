package edu.neu.madcourse.numad22sp_mingchen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buttonInfo(view: android.view.View) {
        Toast.makeText(this, "Ming Chen, chen.ming1@northeastern.edu", Toast.LENGTH_SHORT).show();
    }
}