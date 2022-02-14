package com.example.logicbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.logicbox.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'logicbox' library on application startup.
    static {
        System.loadLibrary("logicbox");
    }

    private ActivityMainBinding binding;
    Button ac2btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        ac2btn=(Button)findViewById(R.id.ac2btn);
        ac2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });
    }
    public void openMainActivity2(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'logicbox' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}