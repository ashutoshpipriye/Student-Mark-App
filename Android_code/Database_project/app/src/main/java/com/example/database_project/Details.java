package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Details extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2,e3,e4,e5;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.mobile);
        e3=findViewById(R.id.email);
        e4=findViewById(R.id.dob);
        e5=findViewById(R.id.city);
        b1=findViewById(R.id.register);
        b1.setOnClickListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onClick(View v) {
        String name = e1.getText().toString();
        String mob_no = e2.getText().toString();
        String email = e3.getText().toString();
        String dob = e4.getText().toString();
        String city = e5.getText().toString();
        try{
            String u = "http://192.168.43.253:8080/StudentMarks/Student.jsp?Name="+name+"&Mob_no="+mob_no+"&Email="+email+"&DOB="+dob+"&City="+city;

            URL url = new URL(u);
            URLConnection con =  url.openConnection();
            InputStream in = con.getInputStream();
            int i;
            String s = "";
            do{
                i = in.read();
                s+=(char)i;
            }while(i!=-1);
            Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}
