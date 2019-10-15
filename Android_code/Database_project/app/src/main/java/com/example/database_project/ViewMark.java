package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ViewMark extends AppCompatActivity implements View.OnClickListener {

    ListView lv;
    String [] arr;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mark);

        lv=findViewById(R.id.list);
        e1=findViewById(R.id.subject);
        b1=findViewById(R.id.marks);
        b1.setOnClickListener(this);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);

        Intent il = getIntent();
        Bundle ob = il.getExtras();
    }

    @Override
    public void onClick(View v) {
        try {

            String subject = e1.getText().toString();
            String u = "http://192.168.43.253:8080/StudentMarks/View_marks.jsp?Subject="+subject;

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