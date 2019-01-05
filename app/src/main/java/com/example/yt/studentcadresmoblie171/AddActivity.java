package com.example.yt.studentcadresmoblie171;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
Button btn_add_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_add);
        MyHelper myHelper;
        btn_add_add=((Button)findViewById(R.id.btn_add_add));
        btn_add_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
tianjia();
            }
        });
        Toast.makeText(this, "welcome，管理员", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "请在以上操作中选择一项进行操作", Toast.LENGTH_LONG).show();
    }

    private void tianjia() {
        Intent intent=new Intent(this,AppendActivity.class);
        startActivity(intent);
    }


}
