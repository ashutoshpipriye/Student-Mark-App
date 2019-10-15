package com.example.database_project;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class CustomAdapter implements ListAdapter {
    ArrayList<String> arrayList;
    Context context;

    ArrayList<EditText> ar=new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String string = arrayList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_row, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
//                  i.setData(Uri.parse(subjectData.Link));
                    context.startActivity(i);
                    //Toast.makeText(context,subjectData.Link,Toast.LENGTH_LONG).show();
                }
            });
            TextView tittle = convertView.findViewById(R.id.title);
            EditText imag = convertView.findViewById(R.id.list_image);
            ar.add(imag);
//          String marks = imag.getText().toString();
//          Toast.makeText(context, ""+marks, Toast.LENGTH_SHORT).show();
            tittle.setText(string);
//          Picasso.with(context)
//                  .load(subjectData.Image)
//                  .into(imag);

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
    public ArrayList<EditText> getTextBox(){
        return  ar;
    }
}
