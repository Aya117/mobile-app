package edu.cs.birzeit.mobileapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    Button btLocation;
    TextView tvLatitude,tvLongitude;
    EditText t1,t2,t3,t4,tv_longitude,tv_latitude;
    Button submt;
   // 192.168.0.106
    private static final String url="http://192.168.1.111/web/ass/addUser.php";
    FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btLocation = findViewById(R.id.bt_location);
        tvLatitude = findViewById(R.id.tv_latitude);
        tvLongitude = findViewById(R.id.tv_longitude);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity3.this);
        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MainActivity3.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MainActivity3.this
                                ,Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){

                    getCurrentLocation();
                }else{
                    ActivityCompat.requestPermissions(MainActivity3.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},100);
                }
            }
        });
        submt= findViewById(R.id.save);
        submt.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
        });
    }

    private void insertdata() {
        t1=findViewById(R.id.names);
        t2=findViewById(R.id.addres);
        t3=findViewById(R.id.num);
        t4=findViewById(R.id.type);
        tv_longitude=findViewById(R.id.tv_longitude);
        tv_latitude=findViewById(R.id.tv_latitude);

        final String N = t1.getText().toString();
        final String AD = t2.getText().toString();
        final String NU = t3.getText().toString();
        final String TY = t4.getText().toString();
        final String lo = tv_longitude.getText().toString();
        final String la = tv_latitude.getText().toString();

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                tv_longitude.setText("");
                tv_latitude.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String,String> getParams()throws AuthFailureError
            {
                Map<String,String> param = new HashMap<String,String>();
                param.put("name",N);
                param.put("address",AD);
                param.put("phone",NU);
                param.put("pone_type",TY);
                param.put("longitude",lo);
                param.put("latitude",la);
                return param;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==100 && grantResults.length> 0 &&(grantResults[0]+grantResults[1]
                == PackageManager.PERMISSION_GRANTED)){
            getCurrentLocation();
        }else {
            Toast.makeText(getApplicationContext(),"Permission denied.",Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation(){
        LocationManager locationManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE
        );
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){

            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    final Location location = task.getResult();

                    if (location !=null){
                        tvLatitude.setText(String.valueOf(location.getLatitude()));

                        tvLongitude.setText(String.valueOf(location.getLongitude()));
                    }else{
                        LocationRequest locationRequest = new LocationRequest()
                                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                                .setInterval(10000)
                                .setFastestInterval(1000)
                                .setNumUpdates(1);

                        LocationCallback locationCallback = new LocationCallback(){

                            @Override
                            public void onLocationResult(LocationResult locationResult) {
                                Location location1 = locationResult.getLastLocation();

                                tvLatitude.setText(String.valueOf(location1.getLatitude()));

                                tvLongitude.setText(String.valueOf(location1.getLongitude()));
                            }
                        };
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper());
                    }
                }
            });
        }else {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }
}
