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

public class MainActivity4 extends AppCompatActivity {
    TextView tviewSSIteration, txtSaveMsgSS, tviewSSSublist;
    EditText edittxtSS;
    Button btnSSSave,btnSSIterate,backBtn;
    int i,small,pos,tmp;
    String str;
    int[] arr;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tviewSSIteration =findViewById(R.id.tviewSSIteration);
        tviewSSSublist=findViewById(R.id.tviewSSSublist);
        txtSaveMsgSS=findViewById(R.id.txtSaveMsgSS);
        edittxtSS=findViewById(R.id.edittxtSS);
        btnSSSave=findViewById(R.id.btnSSSave);
        btnSSIterate=findViewById(R.id.btnSSIterate);
        barChart = findViewById(R.id.idBarChart);
        backBtn=(Button)findViewById(R.id.backBtn2);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });


        String edittxt =(edittxtSS.getText().toString()).replaceAll("\\s", "");
        btnSSSave.setEnabled(!edittxt.isEmpty());
        btnSSIterate.setEnabled(false);
        edittxtSS.addTextChangedListener(formTextWatcher);

        btnSSSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                str=(edittxtSS.getText().toString()).replaceAll("\\s", "");
                arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
                i=0;
                txtSaveMsgSS.setTextColor(Color.rgb(88, 214, 141));
                txtSaveMsgSS.setText("Saved");
                tviewSSIteration.setTextColor(Color.rgb(140, 191, 242));
                tviewSSIteration.setText("Input Array : " + edittxtSS.getText().toString());
                tviewSSSublist.setTextColor(Color.rgb(140, 191, 242));
                tviewSSSublist.setText("Sorted Sub-list : NA");
                btnSSIterate.setEnabled(!(i>=arr.length-1));

                ArrayList<BarEntry> entry=new ArrayList<>();
                for (int z = 0; z < arr.length; ++z){
                    entry.add(new BarEntry(z+1, arr[z]));
                }

                barDataSet = new BarDataSet(entry,"Array Elements");
                barDataSet.setColors(ColorTemplate.getHoloBlue());
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

        btnSSIterate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tviewSSIteration.setText("Iteration " + String.valueOf(i+1) + " : ");
                tviewSSSublist.setTextColor(Color.rgb(88, 214, 141));
                tviewSSSublist.setText("Sorted Sub-list : ");
                int n = arr.length;
                small=arr[i];
                pos=i;
                for(int j=i+1;j<n;j++){
                    if(arr[j]<small){
                        small=arr[j];
                        pos=j;
                    }

                }

                tmp=arr[i];
                arr[i]=arr[pos];
                arr[pos]=tmp;



                ArrayList<BarEntry> entry=new ArrayList<>();

                for (int z = 0; z < arr.length; ++z){
                    entry.add(new BarEntry(z+1, arr[z]));
                    tviewSSIteration.append(String.valueOf(arr[z] + " "));
                }
                barDataSet = new BarDataSet(entry,"Array Elements");
                barDataSet.setColors(ColorTemplate.getHoloBlue());
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

                for (int s = 0; s <=i ; ++s) {
                    tviewSSSublist.append(String.valueOf(arr[s] + " "));

                }

                if (i<n-1){
                    i=i+1;
                }
                else{
                    tviewSSIteration.setTextColor(Color.rgb(88, 214, 141));
                    tviewSSIteration.setText("Array is now sorted");
                    tviewSSSublist.setText("Sorted Array : ");
                    for (int z = 0; z < arr.length; ++z){
                        tviewSSSublist.append(String.valueOf(arr[z] + " "));
                    }

                    btnSSIterate.setEnabled(!(i>=n-1));
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
            String edittxt =(edittxtSS.getText().toString()).replaceAll("\\s", "");
            btnSSSave.setEnabled(!edittxt.isEmpty());
            btnSSIterate.setEnabled(false);
            if(edittxt.isEmpty()){
                txtSaveMsgSS.setTextColor(Color.rgb(247, 220, 111 ));
                txtSaveMsgSS.setText("Not Saved");
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