package com.example.logicbox;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    Button backBtnPRE, btnPREConvert;
    EditText edittxtPRE;
    RadioButton PREinfixConvert,PREpostfixConvert;
    TextView PREResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        edittxtPRE=findViewById(R.id.edittxtPRE);
        PREResult = findViewById(R.id.PREResult);
        btnPREConvert=(Button)findViewById(R.id.btnPREConvert);
        String edittxt =(edittxtPRE.getText().toString());
        btnPREConvert.setEnabled(!edittxt.isEmpty());
        edittxtPRE.addTextChangedListener(formTextWatcher);

        backBtnPRE=(Button)findViewById(R.id.backBtnPRE);
        backBtnPRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        btnPREConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PREpostfixConvert= findViewById(R.id.R1Convert);
                PREinfixConvert= findViewById(R.id.R2Convert);
                String edittxt =(edittxtPRE.getText().toString());
                if(PREinfixConvert.isChecked()){
                    PREResult.setText("Infix : " + String.valueOf(preToInfFromJNI(edittxt)));
                }
                if(PREpostfixConvert.isChecked()){
                    PREResult.setText("Postfix : " + String.valueOf(preToPostFromJNI(edittxt)));
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
            String edittxt =(edittxtPRE.getText().toString());
            btnPREConvert.setEnabled(!edittxt.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
     public native String preToInfFromJNI(String s);
     public native String preToPostFromJNI(String s);
}