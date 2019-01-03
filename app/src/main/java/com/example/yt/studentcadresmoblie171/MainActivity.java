package com.example.yt.studentcadresmoblie171;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private  EditText edtTxt_main_name;
private  EditText edtTxt_main_password;
private Button btn_main_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);
        edtTxt_main_name=(EditText)findViewById(R.id.edtTxt_main_name);
        edtTxt_main_password=(EditText)findViewById(R.id.edtTxt_main_password);
        btn_main_set=(Button)findViewById(R.id.btn_main_set);
        btn_main_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            passDate();
            }




        });

    }

    public void passDate() {
        Intent intent =new Intent(this,activity_show.class);
        intent.putExtra("name",edtTxt_main_name.getText().toString().trim());
        intent.putExtra("password",edtTxt_main_password.getText().toString().trim());
        startActivity(intent);
    }


}
