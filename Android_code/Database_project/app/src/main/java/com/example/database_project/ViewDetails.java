package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ViewDetails extends AppCompatActivity {

    ListView lv;
    String [] arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        lv=findViewById(R.id.list_view);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);

        Intent il = getIntent();
        Bundle ob = il.getExtras();
       try {
           String u = "http://192.168.43.253:8080/StudentMarks/Show_details.jsp";

           URL url = new URL(u);
           URLConnection con =  url.openConnection();
           InputStream in = con.getInputStream();
           int i;
           String s = "";
           do{
               i = in.read();
               s+=(char)i;
           }while(i!=-1);
           arr = s.split(",");
       }catch (Exception e){
           Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
       }
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        lv.setAdapter(ad);
    }
}
