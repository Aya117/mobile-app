package edu.cs.birzeit.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class phonedet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonedet);

        TextView txts = (TextView) findViewById(R.id.screensize);
        TextView txto = (TextView) findViewById(R.id.op);
        TextView txtb = (TextView) findViewById(R.id.battery);
        TextView txtm = (TextView) findViewById(R.id.memory);
        TextView txtw = (TextView) findViewById(R.id.weight);
        TextView txtp = (TextView) findViewById(R.id.price);


        if(getIntent().hasExtra("s")&&getIntent().hasExtra("o")&&
                getIntent().hasExtra("b")&&getIntent().hasExtra("m")&&
                getIntent().hasExtra("w")&&getIntent().hasExtra("p")) {

            String sc = getIntent().getStringExtra("s");
            txts.setText(sc);
            String opp = getIntent().getStringExtra("o");
            txto.setText(opp);
            String ba = getIntent().getStringExtra("b");
            txtb.setText(ba);
            String me = getIntent().getStringExtra("m");
            txtm.setText(me);
            String we = getIntent().getStringExtra("w");
            txtw.setText(we);
            String pr = getIntent().getStringExtra("p");
            txtp.setText(pr);

        }


    }
}