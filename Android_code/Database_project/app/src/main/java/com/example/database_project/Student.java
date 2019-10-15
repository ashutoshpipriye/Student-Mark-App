package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student extends AppCompatActivity implements View.OnClickListener {
    Intent it;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        btn1=findViewById(R.id.btnDetails);
        btn2=findViewById(R.id.btnMarks);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDetails:
                it = new Intent(this, Details.class);
                startActivity(it);
                break;
            case R.id.btnMarks:
                it = new Intent(this, ViewMark.class);
                startActivity(it);
                break;
        }
    }
}
