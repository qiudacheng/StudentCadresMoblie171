package com.example.yt.studentcadresmoblie171;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_show extends AppCompatActivity {

private TextView tv_show_name;
private TextView tv_show_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_show);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        tv_show_name=(TextView)findViewById(R.id.tv_show_name);
        tv_show_password=(TextView)findViewById(R.id.tv_show_password);
        tv_show_name.setText("用户名："+name);
        tv_show_password.setText("密码："+password);

    }
}
