package com.example.stuc108193104;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PageTwo extends AppCompatActivity {

    //Step 1
    RadioGroup rgSet;
    RadioButton rb0,rb1,rb2,rb3;
    Button btn,btn2;
    int [] Values;
    int contents;
    String [] fruit;
    String [] items;
    boolean [] chkedItems;
    AlertDialog.Builder altDlg,altDlgAns,altDlgEnter;
    Toast t;
    boolean check = false;
    View v;
    int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        //Step 2
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        rgSet = findViewById(R.id.rgSet);
        rb0 = findViewById(R.id.rb0);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);

        fruit = getResources().getStringArray(R.array.fruit);
        altDlg = new AlertDialog.Builder(this);
        altDlgAns = new AlertDialog.Builder(this);
        altDlgEnter = new AlertDialog.Builder(this);


        //Step 3
        rgSet.setOnCheckedChangeListener(rgListener);
        btn.setOnClickListener(btnListener);
        btn2.setOnClickListener(btn2Listener);
    }


    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if(checkedId == R.id.rb0) {
                Values = new int[3];
                Values[0] = 0;
                contents = 2;
            }
            if(checkedId == R.id.rb1) {
                Values = new int[4];
                Values[0] = 1;
                contents = 3;
            }
            if(checkedId == R.id.rb2) {
                Values = new int[3];
                Values[0] = 2;
                contents = 2;
            }
            if(checkedId == R.id.rb3) {
                Values = new int[4];
                Values[0] = 3;
                contents = 3;
            }

            check = true;
        }
    };

    View.OnClickListener btn2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(check)
            {
                items = fruit;

                chkedItems = new boolean[items.length];

                altDlg.setTitle("配料選擇")
                        .setMultiChoiceItems(items,chkedItems,multchkedListener)
                        .setPositiveButton("確定", dlgPosListener)
                        .setNegativeButton("取消", null)
                        .show();

            }

            else
            {
                t = Toast.makeText(PageTwo.this, "你還沒選擇套餐哦!",Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };

    DialogInterface.OnMultiChoiceClickListener multchkedListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            chkedItems[which] = isChecked;
        }
    };


    DialogInterface.OnClickListener dlgPosListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {


            int sum = 0;

            for(int i =0;i<chkedItems.length;i++)
            {
                if(chkedItems[i])
                {
                    sum++;
                }
            }

            /*
            t = Toast.makeText(PageTwo.this,"sum:"+sum+"contents:"+contents,Toast.LENGTH_LONG);
            t.show();

             */

            if(sum>contents)
            {

                t = Toast.makeText(PageTwo.this, "您只有"+contents+"個配料可以選哦!",Toast.LENGTH_SHORT);
                t.show();
            }

            else if(sum<contents)
            {
                t = Toast.makeText(PageTwo.this, "您還有"+(contents-sum)+"個配料可以選哦!",Toast.LENGTH_SHORT);
                t.show();
            }

            else
            {
                int count = 1;
                for(int i=0; i<chkedItems.length; i++){
                    if(chkedItems[i]){
                        Values[count] = i;
                        count++;

                        if(count>contents)
                            break;
                    }
                }

                String temp = "";
                for(int i = 1; i<=contents; i++)
                {
                    switch (Values[i])
                    {
                        case 0:
                            temp += "Apple" + "\n";
                            break;

                        case 1:
                            temp += "Banana" + "\n";
                            break;

                        case 2:
                            temp += "Pudding" + "\n";
                            break;

                        case 3:
                            temp += "Strawberry" + "\n";
                            break;

                        case 4:
                            temp += "Mango" + "\n";
                            break;

                        default:

                            temp += "" + "\n";
                    }
                }

                altDlgAns.setTitle("選擇結果")
                        .setMessage(temp)
                        .setPositiveButton("確定",dlgPos2Listener)
                        .setNegativeButton("取消",null)
                        .show();
            }
        }
    };

    DialogInterface.OnClickListener dlgPos2Listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {


            LayoutInflater inflater = LayoutInflater.from(PageTwo.this);
            v = inflater.inflate(R.layout.dialog_layout, null);

            altDlgEnter.setTitle("輸入數量")
                    .setView(v)
                    .setPositiveButton("確定",dlgPos3Listener)
                    .setNegativeButton("取消",null)
                    .show();
        }
    };

    DialogInterface.OnClickListener dlgPos3Listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            EditText editText = (EditText) (v.findViewById(R.id.editText1));

            amount = Integer.parseInt("" + editText.getText());

            t = Toast.makeText(PageTwo.this, "配料選擇完畢 可以前往購物車囉!",Toast.LENGTH_LONG);
            t.show();
        }
    };


    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(check) {

                Intent it2 = new Intent(PageTwo.this, PageThree.class);
                Bundle bd2 = new Bundle();
                bd2.putIntArray("ice", Values);
                bd2.putInt("amount", amount);

                it2.putExtras(bd2);
                startActivity(it2);
            }

            else
            {
                t = Toast.makeText(PageTwo.this, "你還沒選擇套餐哦!",Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
}
