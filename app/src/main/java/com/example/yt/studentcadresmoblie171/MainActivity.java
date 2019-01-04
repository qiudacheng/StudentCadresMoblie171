package com.example.yt.studentcadresmoblie171;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  EditText edtTxt_main_name;
private  EditText edtTxt_main_password;
private Button btn_main_set,btn_main_exit;
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
        btn_main_exit=((Button)findViewById(R.id.btn_main_exit));
        btn_main_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                this.exit();
            }

            private void exit() {
                Dialog dialog=new AlertDialog.Builder(MainActivity.this)
                        .setTitle("程序退出？")
                        .setMessage("您确定退出么？")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               MainActivity.this.finish();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();
                dialog.show();;
            }

        });

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
