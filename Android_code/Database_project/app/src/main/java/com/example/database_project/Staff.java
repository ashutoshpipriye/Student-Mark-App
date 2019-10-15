package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Staff extends AppCompatActivity implements View.OnClickListener {

    Intent i;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        b1=findViewById(R.id.btnStudentDetails);
        b2=findViewById(R.id.btnStudentMark);
        b3=findViewById(R.id.btnViewDetails);
        b4=findViewById(R.id.btnViewMarks);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStudentDetails:
                i = new Intent(this, Details.class);
                startActivity(i);
                break;
            case R.id.btnStudentMark:
                i = new Intent(this, Mark.class);
                startActivity(i);
                break;
            case R.id.btnViewDetails:
                i = new Intent(this, ViewDetails.class);
                startActivity(i);
                break;
            case R.id.btnViewMarks:
                i = new Intent(this, ViewMark.class);
                startActivity(i);
                break;
        }
    }
}
