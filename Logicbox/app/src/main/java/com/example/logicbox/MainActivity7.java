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
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    Button backBtnPOST, btnPOSTConvert;
    EditText edittxtPOST;
    RadioButton POSTprefixConvert,POSTinfixConvert;
    TextView POSTResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        edittxtPOST=findViewById(R.id.edittxtPOST);
        POSTResult = findViewById(R.id.POSTResult);
        btnPOSTConvert=(Button)findViewById(R.id.btnPOSTConvert);
        String edittxt =(edittxtPOST.getText().toString()).replaceAll("\\s", "");
        btnPOSTConvert.setEnabled(!edittxt.isEmpty());
        edittxtPOST.addTextChangedListener(formTextWatcher);

        backBtnPOST=(Button)findViewById(R.id.backBtnPOST);
        backBtnPOST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

            btnPOSTConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    POSTinfixConvert= findViewById(R.id.R1Convert);
                    POSTprefixConvert= findViewById(R.id.R2Convert);
                    POSTResult.setTextColor(Color.rgb(255,255,255 ));
                    String edittxt =(edittxtPOST.getText().toString()).replaceAll("\\s", "");

                        if(POSTinfixConvert.isChecked()){
                            POSTResult.setText("Infix : " + String.valueOf(postToInfFromJNI(edittxt)));
                        }
                        if(POSTprefixConvert.isChecked()){
                            POSTResult.setText("Prefix : " + String.valueOf(postToPreFromJNI(edittxt)));
                        }


                }
            }) ;




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
            String edittxt =(edittxtPOST.getText().toString()).replaceAll("\\s", "");
            btnPOSTConvert.setEnabled(!edittxt.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public native String postToInfFromJNI(String s);
    public native String postToPreFromJNI(String s);
}