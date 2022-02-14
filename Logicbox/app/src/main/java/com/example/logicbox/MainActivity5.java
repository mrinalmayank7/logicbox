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
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity5 extends AppCompatActivity {
    TextView tviewISIteration, txtSaveMsgIS;
    EditText edittxtIS;
    Button btnISSave,btnISIterate,backBtnIS;
    int i;
    String str;
    int[] arr;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        tviewISIteration =findViewById(R.id.tviewISIteration);
        txtSaveMsgIS=findViewById(R.id.txtSaveMsgIS);
        edittxtIS=findViewById(R.id.edittxtIS);
        btnISSave=findViewById(R.id.btnISSave);
        btnISIterate=findViewById(R.id.btnISIterate);
        barChart = findViewById(R.id.idBarChart);
        backBtnIS=(Button)findViewById(R.id.backBtnIS);
        backBtnIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        String edittxt =(edittxtIS.getText().toString()).replaceAll("\\s", "");
        btnISSave.setEnabled(!edittxt.isEmpty());
        btnISIterate.setEnabled(false);
        edittxtIS.addTextChangedListener(formTextWatcher);
        btnISSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                str=(edittxtIS.getText().toString()).replaceAll("\\s", "");
                arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
                i=1;
                txtSaveMsgIS.setTextColor(Color.rgb(88, 214, 141));
                txtSaveMsgIS.setText("Saved");
                tviewISIteration.setTextColor(Color.rgb(140, 191, 242));
                tviewISIteration.setText("Input Array : " + edittxtIS.getText().toString());
                btnISIterate.setEnabled(!(i>=arr.length));

                ArrayList<BarEntry> entry=new ArrayList<>();
                for (int z = 0; z < arr.length; ++z){
                    entry.add(new BarEntry(z+1, arr[z]));
                }

                barDataSet = new BarDataSet(entry,"Array Elements");
                barDataSet.setColors(ColorTemplate.rgb("#ff6666"));
                barDataSet.setValueTextColor(Color.WHITE);
                barDataSet.setValueTextSize(14f);
                barData=new BarData(barDataSet);
                barData.setValueTextColor(Color.WHITE);
                barChart.getXAxis().setTextColor(Color.WHITE);
                barChart.getAxisLeft().setTextColor(Color.WHITE); // left y-axis
                barChart.getAxisRight().setTextColor(Color.WHITE);
                barChart.getLegend().setTextColor(Color.WHITE);
                barChart.getDescription().setTextColor(Color.WHITE);
                barChart.setFitBars(true);
                barChart.setData(barData);
                barChart.getDescription().setEnabled(false);
                barChart.animateY(1200);
            }
        });

        btnISIterate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tviewISIteration.setText("Iteration " + String.valueOf(i) + " : ");
                int n = arr.length;
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;

                ArrayList<BarEntry> entry=new ArrayList<>();
                for (int z = 0; z < arr.length; ++z){
                    entry.add(new BarEntry(z+1, arr[z]));
                    tviewISIteration.append(String.valueOf(arr[z] + " "));
                }


                barDataSet = new BarDataSet(entry,"Array Elements");
                barDataSet.setColors(ColorTemplate.rgb("#ff6666"));
                barDataSet.setValueTextColor(Color.WHITE);
                barDataSet.setValueTextSize(14f);
                barData=new BarData(barDataSet);
                barData.setValueTextColor(Color.WHITE);
                barChart.getXAxis().setTextColor(Color.WHITE);
                barChart.getAxisLeft().setTextColor(Color.WHITE); // left y-axis
                barChart.getAxisRight().setTextColor(Color.WHITE);
                barChart.getLegend().setTextColor(Color.WHITE);
                barChart.getDescription().setTextColor(Color.WHITE);
                barChart.setFitBars(true);
                barChart.setData(barData);
                barChart.getDescription().setEnabled(false);
                barChart.animateY(1200);


                if (i<n-1){
                    i=i+1;
                }
                else{
                    tviewISIteration.setTextColor(Color.rgb(88, 214, 141));
                    tviewISIteration.setText("Array is now sorted");
                    btnISIterate.setEnabled(!(i>=n-1));
                }




            }
        });

    }
    private TextWatcher formTextWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @RequiresApi(api = Build.VERSION_CODES.S)
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String edittxt =(edittxtIS.getText().toString()).replaceAll("\\s", "");
            btnISSave.setEnabled(!edittxt.isEmpty());
            btnISIterate.setEnabled(false);
            if(edittxt.isEmpty()){
                txtSaveMsgIS.setTextColor(Color.rgb(247, 220, 111 ));
                txtSaveMsgIS.setText("Not Saved");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void openMainActivity2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

}