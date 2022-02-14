package com.example.logicbox;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity10 extends AppCompatActivity {
    Button backBtnMT , MTConvertBtn;
    EditText edittxtBTa ,edittxtBTb, edittxtBTk, edittxtBTi;
    TextView RECResult, SOLResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        edittxtBTa =findViewById(R.id.edittxtBTa);
        edittxtBTb =findViewById(R.id.edittxtBTb);
        edittxtBTk =findViewById(R.id.edittxtBTk);
        edittxtBTi =findViewById(R.id.edittxtBTi);
        RECResult =findViewById(R.id.RECResult);
        SOLResult =findViewById(R.id.SOLResult);
        backBtnMT=(Button)findViewById(R.id.backBtnMT);
        MTConvertBtn=(Button)findViewById(R.id.MTConvertBtn);
        backBtnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        MTConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(edittxtBTa.getText().toString());
                double b = Double.parseDouble(edittxtBTb.getText().toString());
                double k = Double.parseDouble(edittxtBTk.getText().toString());
                double i = Double.parseDouble(edittxtBTi.getText().toString());

                if( a>Math.pow(b,k))
                {
                    double ans= Math.log(a) / Math.log(b);
                    SOLResult.setText("T(n) ∈ θ (n^"+myround(ans)+")");
                    if(i==0 && k!=0 && k!=1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+")");
                    }
                    else if(i==0 && k==1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n)");
                    }
                    else if(i==0 && k==0){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(1)");
                    }
                    else if(i==1 && k==1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n . (log n))");
                    }
                    else if(i==1 && k==0){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(log n)");
                    }
                    else if(i==1 && k!=0 && k!=1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+" . (log n))");
                    }
                    else{
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+" . (log n)^"+myround(i)+")");
                    }

                }
                 if( a== Math.pow(b,k)){
                     double ans= Math.log(a) / Math.log(b);
                     if(i< -1) {
                         SOLResult.setText("T(n) ∈ θ (n^"+myround(ans)+")");
                     }
                     if(i== -1) {
                         SOLResult.setText("T(n) ∈ θ (n^"+myround(ans)+" . (log n)^2)");

                     }
                     if(i> -1) {
                         SOLResult.setText("T(n) ∈ θ (n^"+myround(ans)+" . (log n)^"+myround(i+1)+")");
                     }
                     if(i==0 && k!=0 && k!=1){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                 myround(b) +") + θ(n^"+myround(k)+")");
                     }
                     else if(i==0 && k==1){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                 myround(b) +") + θ(n)");
                     }
                     else if(i==0 && k==0){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                 myround(b) +") + θ(1)");
                     }
                     else if(i==1 && k==1){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                 myround(b) +") + θ(n . (log n))");
                     }
                     else if(i==1 && k==0){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                 myround(b) +") + θ(log n)");
                     }
                     else if(i==1 && k!=0 && k!=1){
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                 myround(b) +") + θ(n^"+myround(k)+" . (log n))");
                     }
                     else{
                         RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                 myround(b) +") + θ(n^"+myround(k)+" . (log n)^"+myround(i)+")");
                     }

                }
                if( a< Math.pow(b,k)){
                    if(i<=0){
                        SOLResult.setText("T(n) ∈ θ(n^"+myround(k)+")");
                    }
                    if(i>0){
                        SOLResult.setText("T(n) ∈ θ(n^"+myround(k)+" . (log n)^ "+myround(i)+")");
                    }
                    if(i==0 && k!=0 && k!=1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+")");
                    }
                    else if(i==0 && k==1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n)");
                    }
                    else if(i==0 && k==0){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(1)");
                    }
                    else if(i==1 && k==1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(n . (log n))");
                    }
                    else if(i==1 && k==0){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +" . T(n/"+
                                myround(b) +") + θ(log n)");
                    }
                    else if(i==1 && k!=0 && k!=1){
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+" . (log n))");
                    }
                    else{
                        RECResult.setText("Recurrence \n T(n) = "+myround(a) +".T(n/"+
                                myround(b) +") + θ(n^"+myround(k)+" . (log n)^"+myround(i)+")");
                    }

                }
            }
        });
    }
    public void openMainActivity2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public String myround(double num){
        if(".#"==".0"){
            DecimalFormat df = new DecimalFormat("#");
        }
        else{
            DecimalFormat df = new DecimalFormat("#.##");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(num);

    }

}