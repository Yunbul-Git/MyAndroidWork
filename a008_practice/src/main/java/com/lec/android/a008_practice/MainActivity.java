package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String [] nameList;
    String [] ageList;
    String [] addressList;
    EditText etName;
    EditText etAge;
    EditText etAddress;
    RecyclerView rv;
    PracticeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

         etName = findViewById(R.id.etName);
         etAge = findViewById(R.id.etAge);
         etAddress = findViewById(R.id.etAddress);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(layoutManager);

        adapter = new PracticeAdapter();

        //initAdapter(adapter);

        rv.setAdapter(adapter);

        Button btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
                etName.setText("");
            }
        });

    }//end onCreate

    protected void initAdapter(PracticeAdapter adapter){
        for (int i = 0 ; i == nameList.length; i++){
            if(nameList[i] == null){ nameList[i] = findViewById(R.id.etName).toString(); }
            if(ageList[i] == null){ ageList[i] = findViewById(R.id.etAge).toString(); }
            if(addressList[i] == null){ addressList[i] = findViewById(R.id.etAddress).toString(); }
        }


    }

    protected void insertData(View v){
        adapter.addItem(new Practice(etName.getText().toString(),etAge.getText().toString(),etAddress.getText().toString()));
        //adapter.addItem(new Practice(etName.getText().toString(),findViewById(R.id.etAge).toString(),findViewById(R.id.etAddress).toString()));
        adapter.notifyDataSetChanged();
    }
}//end Activity
