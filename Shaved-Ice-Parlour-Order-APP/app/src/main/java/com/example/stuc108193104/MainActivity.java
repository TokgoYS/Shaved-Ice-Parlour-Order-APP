package com.example.stuc108193104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Step 1
    Button btn1;
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2
        btn1 = findViewById(R.id.btn1);

        //Step 3
        btn1.setOnClickListener(btn1Listener);

        Toast t = Toast.makeText(this,"歡迎光臨 刨冰王!",Toast.LENGTH_LONG);
        t.show();
    }


    View.OnClickListener btn1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent it1 = new Intent(MainActivity.this, PageTwo.class);
            startActivity(it1);
        }
    };
}
