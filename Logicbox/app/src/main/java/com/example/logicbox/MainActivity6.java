package com.example.logicbox;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    Button backBtnINF, btnINFConvert;
    EditText edittxtINF;
    RadioButton INFprefixConvert,INFpostfixConvert;
    TextView INFResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        edittxtINF=findViewById(R.id.edittxtINF);
        INFResult = findViewById(R.id.INFResult);
        btnINFConvert=(Button)findViewById(R.id.btnINFConvert);
        String edittxt =(edittxtINF.getText().toString());
        btnINFConvert.setEnabled(!edittxt.isEmpty());
        edittxtINF.addTextChangedListener(formTextWatcher);

        backBtnINF=(Button)findViewById(R.id.backBtnINF);
        backBtnINF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        btnINFConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INFprefixConvert= findViewById(R.id.R2Convert);
                INFpostfixConvert= findViewById(R.id.R1Convert);
                String edittxt =(edittxtINF.getText().toString());
                if(INFprefixConvert.isChecked()){
                    INFResult.setText("Prefix : " + String.valueOf(infToPreFromJNI(edittxt)));
                }
                if(INFpostfixConvert.isChecked()){
                    INFResult.setText("Postfix : " + String.valueOf(infToPostFromJNI(edittxt)));
                }



            }
        });


    }

    public void openMainActivity2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    private TextWatcher formTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @RequiresApi(api = Build.VERSION_CODES.S)
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String edittxt =(edittxtINF.getText().toString());
            btnINFConvert.setEnabled(!edittxt.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public native String infToPostFromJNI(String s);
    public native String infToPreFromJNI(String s);
}