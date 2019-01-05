package com.example.yt.studentcadresmoblie171;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppendActivity extends AppCompatActivity {
Button btn_append_set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_append);
        btn_append_set=(Button)findViewById(R.id.btn_append_set);
        btn_append_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

    }
    public void insert(String name,String numble,String sex ,String clas,String zhiwu ,String phone,String home,String sushe)
    {

        SQLiteDatabase db=helper.get
    }
}
