package com.example.yt.studentcadresmoblie171;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 Button btn_main_set,btn_main_readname;
 EditText edtTxt_main_name,edtTxt_main_password;
 TextView tv_main_username,tv_main_password;
 private String username,password;
 private EditText getEdtTxt_main_name,getEdtTxt_main_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public  void  init(){
       tv_main_username =(findViewById(R.id.tv_main_username));
       tv_main_password=(findViewById(R.id.tv_main_password));
       btn_main_set=findViewById(R.id.btn_main_set);
        btn_main_readname=findViewById(R.id.btn_main_readname);
        edtTxt_main_name=findViewById(R.id.edtTxt_main_name);
        edtTxt_main_password=findViewById(R.id.edtTxt_main_password);
        btn_main_readname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });
        btn_main_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=edtTxt_main_name.getText().toString().trim();
                password=edtTxt_main_password.getText().toString().trim();

            }
        });

    }
}
