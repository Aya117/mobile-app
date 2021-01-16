package edu.cs.birzeit.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnshow;
    private Button btnbuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshow=findViewById(R.id.btnshow);
        btnbuy=findViewById(R.id.btnbuy);
    }

    public void showMobile(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }

    public void buyitem(View view) {

        Intent intent1 = new Intent(this,MainActivity3.class);
        startActivity(intent1);
    }
}