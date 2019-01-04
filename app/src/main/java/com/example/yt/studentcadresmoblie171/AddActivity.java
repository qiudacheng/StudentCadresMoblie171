package com.example.yt.studentcadresmoblie171;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_add);
        Toast.makeText(this, "welcome，管理员", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "请在以上操作中选择一项进行操作", Toast.LENGTH_LONG).show();
    }
}
