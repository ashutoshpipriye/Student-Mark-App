package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Mark extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner sp;
    ListView list;
    Button b1;
    CustomAdapter customAdapter;
    String[] array;
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);

        Intent il = getIntent();
        Bundle ob = il.getExtras();

        sp = (Spinner) findViewById(R.id.spinner);
        String[] arr = {"DBMS", "ML", "TOC"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, arr);
        sp.setOnItemSelectedListener(this);
        sp.setAdapter(ad);

        b1 = findViewById(R.id.submit);
        b1.setOnClickListener(this);
        list = findViewById(R.id.list);
        try {
            String u = "http://192.168.43.253:8080/StudentMarks/Info.jsp";

            URL url = new URL(u);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            int i;
            String s = "";
            do {
                i = in.read();
                s += (char) i;
            } while (i != -1);
            array = s.split("-");
//            Toast.makeText(this, ""+array.length, Toast.LENGTH_SHORT).show();
            try {
                for (String s2 : array) {
                    try {
                        String arr2[] = s2.trim().split(",");
                        Log.i("data", arr2[0] + ":" + arr2[1]);
                        arrayList.add(new String(arr2[0] + ". " + arr2[1]));
                        id.add(arr2[0]);
//                     Toast.makeText(this, arr2[0] + ":" + arr2[1], Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                }
                customAdapter = new CustomAdapter(this, arrayList);
                list.setAdapter(customAdapter);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
//        ArrayAdapter add = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,array);
//        lv.setAdapter(ad);
//        Toast.makeText(this, ""+add, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    StringBuffer sb = new StringBuffer();
    StringBuffer marks = new StringBuffer();
    @Override
    public void onClick(View v) {
        sb = new StringBuffer();
        marks = new StringBuffer();

        String s = sp.getSelectedItem().toString();
        ArrayList<EditText> ar1 = customAdapter.getTextBox();
        for (int i = 0; i <ar1.size(); i++) {
            try {
                EditText e1 = ar1.get(i);
                Log.i("Text", id.get(i) + "   " +e1.getText());
                sb.append("," + id.get(i));
                marks.append("," + e1.getText());
            } catch (Exception e) {
            }
        }
        if (s.equals("DBMS")) {
            try {
                String u = "http://192.168.43.253:8080/StudentMarks/Marks.jsp?Roll_no=" + sb + "&Subject=" + s + "&Marks=" + marks;

                URL url = new URL(u);
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                int j;
                String ss = "";
                do {
                    j = in.read();
                    ss += (char) j;
                } while (j != -1);
                Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(this, "DBMS is selected", Toast.LENGTH_SHORT).show();
        }
        if (s.equals("ML")) {
            try {
                String u = "http://192.168.43.253:8080/StudentMarks/Marks.jsp?Roll_no=" + sb + "&Subject=" + s + "&Marks=" + marks;

                URL url = new URL(u);
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                int j;
                String ss = "";
                do {
                    j = in.read();
                    ss += (char) j;
                } while (j != -1);
                Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(this, "ML is selected", Toast.LENGTH_SHORT).show();
        }

        if (s.equals("TOC")) {
            try {
                String u = "http://192.168.43.253:8080/StudentMarks/Marks.jsp?Roll_no=" + sb + "&Subject=" + s + "&Marks=" + marks;

                URL url = new URL(u);
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                int j;
                String ss = "";
                do {
                    j = in.read();
                    ss += (char) j;
                } while (j != -1);
                Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(this, "TOC is selected", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Marks saved in database", Toast.LENGTH_SHORT).show();
    }
}


