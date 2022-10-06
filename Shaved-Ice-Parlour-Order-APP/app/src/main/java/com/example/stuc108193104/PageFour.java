package com.example.stuc108193104;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class PageFour extends AppCompatActivity {

    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);


        t = Toast.makeText(this, "祝您有美好的一天!",Toast.LENGTH_LONG);
        t.show();
    }

}
