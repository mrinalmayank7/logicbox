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

public class MainActivity3 extends AppCompatActivity {
    TextView tviewBSIteration, txtSaveMsg;
    EditText edittxtBS;
    Button btnBSSave,btnBSIterate,backBtn;
    int i;
    String str;
    int[] arr;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tviewBSIteration =findViewById(R.id.tviewBSIteration);
        txtSaveMsg=findViewById(R.id.txtSaveMsg);
        edittxtBS=findViewById(R.id.edittxtBS);
        btnBSSave=findViewById(R.id.btnBSSave);
        btnBSIterate=findViewById(R.id.btnBSIterate);
        barChart = findViewById(R.id.idBarChart);
        backBtn=(Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        String edittxt =(edittxtBS.getText().toString()).replaceAll("\\s", "");
        btnBSSave.setEnabled(!edittxt.isEmpty());
        btnBSIterate.setEnabled(false);
        edittxtBS.addTextChangedListener(formTextWatcher);

            btnBSSave.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View view){

                        str = (edittxtBS.getText().toString()).replaceAll("\\s", "");
                        arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();

                    i = 0;
                    txtSaveMsg.setTextColor(Color.rgb(88, 214, 141));
                    txtSaveMsg.setText("Saved");
                    tviewBSIteration.setTextColor(Color.rgb(140, 191, 242));
                    tviewBSIteration.setText("Input Array : " + edittxtBS.getText().toString());
                    btnBSIterate.setEnabled(!(i >= arr.length - 1));

                    ArrayList<BarEntry> entry = new ArrayList<>();
                    for (int z = 0; z < arr.length; ++z) {
                        entry.add(new BarEntry(z + 1, arr[z]));
                    }

                    barDataSet = new BarDataSet(entry, "Array Elements");
                    barDataSet.setColors(ColorTemplate.rgb("#9999ff"));
                    barDataSet.setValueTextColor(Color.WHITE);
                    barDataSet.setValueTextSize(14f);
                    barData = new BarData(barDataSet);
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


        btnBSIterate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tviewBSIteration.setText("Iteration " + String.valueOf(i+1) + " : ");
                int n = arr.length;
                for (int j = 0; j < n-i-1; j++){
                    if (arr[j] > arr[j+1])
                    {
                        // swap arr[j+1] and arr[j]
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }

                ArrayList<BarEntry> entry=new ArrayList<>();
                for (int z = 0; z < arr.length; ++z){
                    entry.add(new BarEntry(z+1, arr[z]));
                    tviewBSIteration.append(String.valueOf(arr[z] + " "));
                }


                barDataSet = new BarDataSet(entry,"Array Elements");
                barDataSet.setColors(ColorTemplate.rgb("#9999ff"));
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
                    tviewBSIteration.setTextColor(Color.rgb(88, 214, 141));
                    tviewBSIteration.setText("Array is now sorted");
                    btnBSIterate.setEnabled(!(i>=n-1));
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
         String edittxt =(edittxtBS.getText().toString()).replaceAll("\\s", "");
         btnBSSave.setEnabled(!edittxt.isEmpty());
         btnBSIterate.setEnabled(false);
         if(edittxt.isEmpty()){
             txtSaveMsg.setTextColor(Color.rgb(247, 220, 111 ));
             txtSaveMsg.setText("Not Saved");
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