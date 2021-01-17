package edu.cs.birzeit.mobileapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //test comment
        setContentView(R.layout.activity_main);

        RecyclerView recycler = (RecyclerView)findViewById(R.id.phone_recycler);

        String[] captions = new String[phone.phones.length];
        int[] ids = new int[phone.phones.length];
        String[] s = new String[phone.phones.length];
        String[] o = new String[phone.phones.length];
        String[] b = new String[phone.phones.length];
        String[] m = new String[phone.phones.length];
        String[] w = new String[phone.phones.length];
        String[] p = new String[phone.phones.length];

        for (int i = 0; i < captions.length; i++) {
            captions[i] = phone.phones[i].getName();
            ids[i] = phone.phones[i].getImageID();
            s[i] = phone.phones[i].getScreenSize();
            o[i] = phone.phones[i].getOperatingSystem();
            b[i] = phone.phones[i].getBattery();
            m[i] = phone.phones[i].getMemory();
            w[i] = phone.phones[i].getWeight();
            p[i] = phone.phones[i].getPrice();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, s, o, b, m, w, p, this);
        recycler.setAdapter(adapter);
    }
}