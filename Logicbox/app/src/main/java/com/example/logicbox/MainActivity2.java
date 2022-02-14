package com.example.logicbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btnBS , btnSS, btnIS , btnINF ,btnPOST,btnPRE , abtBtn , btnMT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnBS=(Button)findViewById(R.id.btnBS);
        btnSS=(Button)findViewById(R.id.btnSS);
        btnIS=(Button)findViewById(R.id.btnIS);
        btnINF=(Button)findViewById(R.id.btnINF);
        btnPOST=(Button)findViewById(R.id.btnPOST);
        btnPRE=(Button)findViewById(R.id.btnPRE);
        abtBtn=(Button)findViewById(R.id.abtBtn);
        btnMT=(Button)findViewById(R.id.btnMT);
        btnBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity3();
            }
        });
        btnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity4();
            }
        });
        btnIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity5();
            }
        });
        btnINF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity6();
            }
        });
        btnPOST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity7();
            }
        });
        btnPRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity8();
            }
        });
        abtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity9();
            }
        });
        btnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity10();
            }
        });
    }
    public void openMainActivity3(){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    public void openMainActivity4(){
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
    public void openMainActivity5(){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
    public void openMainActivity6(){
        Intent intent = new Intent(this,MainActivity6.class);
        startActivity(intent);
    }
    public void openMainActivity7(){
        Intent intent = new Intent(this,MainActivity7.class);
        startActivity(intent);
    }
    public void openMainActivity8(){
        Intent intent = new Intent(this,MainActivity8.class);
        startActivity(intent);
    }
    public void openMainActivity9(){
        Intent intent = new Intent(this,MainActivity9.class);
        startActivity(intent);
    }
    public void openMainActivity10(){
        Intent intent = new Intent(this,MainActivity10.class);
        startActivity(intent);
    }
}