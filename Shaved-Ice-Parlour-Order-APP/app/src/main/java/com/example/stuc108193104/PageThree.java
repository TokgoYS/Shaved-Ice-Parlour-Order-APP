package com.example.stuc108193104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PageThree extends AppCompatActivity {

    //Step 1
    Button btn3;
    TextView orderText;
    String outText;
    Product p;
    Ice [] I = new Ice[3];
    int contents =0;
    int amount;
    String [] buy = new String[10];
    //int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);


        //Step 2
        btn3 = findViewById(R.id.btn5);
        orderText = findViewById(R.id.orderText);


        Intent it23 = getIntent();
        Bundle bd23 = it23.getExtras();
        int [] Values = bd23.getIntArray("ice");
        amount = bd23.getInt("amount");


        int count = 0;
        String contents = "";
        for(int i = 1; i<Values.length; i++){
            switch (Values[i]) {
                case 0:
                    I[count] = new Apple();
                    count++;
                    contents += "Apple\n";
                    break;
                case 1:
                    I[count] = new Banana();
                    count++;
                    contents += "Banana\n";
                    break;
                case 2:
                    I[count] = new Pudding();
                    count++;
                    contents += "Pudding\n";
                    break;
                case 3:
                    I[count] = new Strawberry();
                    count++;
                    contents += "Strawberry\n";
                    break;
                case 4:
                    I[count] = new Mango();
                    count++;
                    contents += "Mango\n";
                    break;
            }
        }

        outText = "";


        switch (Values[0]) {
            case 0:
                p = new A(I[0], I[1]);
                outText += "A套餐 \n" + contents;
                break;
            case 1:
                p = new B(I[0], I[1], I[2]);
                outText += "B套餐 \n" + contents;
                break;
            case 2:
                p = new C(I[0], I[1]);
                outText += "C套餐 \n" + contents;
                break;
            case 3:
                p = new D(I[0], I[1], I[2]);
                outText += "D套餐 \n" + contents;
            /*
            case 4:
                p = new E(I[0], I[1], I[2],I[3],I[4]);
                outText += "E套餐 \n" + contents;

            case 5:
                p = new F(I[0], I[1], I[2],I[3],I[4]);
                outText += "F套餐 \n" + contents;

             */
        }

        double total = p.getPrice() * amount;

        outText += "\n" +"套餐數量："  + amount + "份";

        outText += "\n" + "\n" + "金額:" + total + "元"+ "\n";

        orderText.setText(outText);


        //Step 3
        btn3.setOnClickListener(btn3Listener);


    }

    View.OnClickListener btn3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it3 = new Intent(PageThree.this, PageFour.class);
            startActivity(it3);
        }
    };
/*
    View.OnClickListener btn4Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent it4 = new Intent(PageThree.this, PageTwo.class);
            Bundle bd4 = new Bundle();
            it4.putExtras(bd4);
            startActivity(it4);
        }
    };

 */
}
