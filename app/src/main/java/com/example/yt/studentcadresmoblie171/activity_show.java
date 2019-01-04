package com.example.yt.studentcadresmoblie171;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_show extends AppCompatActivity {

private TextView tv_show_name;
private TextView tv_show_password;
private Button btn_show_jinru,btn_show_exit;
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
        btn_show_jinru=(Button)findViewById(R.id.btn_show_jinru);
        btn_show_exit=(Button)findViewById(R.id.btn_show_exit);
        tv_show_name=(TextView)findViewById(R.id.tv_show_name);
        tv_show_password=(TextView)findViewById(R.id.tv_show_password);
        tv_show_name.setText("用户名："+name);
        tv_show_password.setText("密码："+password);
        btn_show_jinru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enter();
            }
        });
btn_show_exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        this.exit();
    }

    private void exit() {
        Dialog dialog=new AlertDialog.Builder(activity_show.this)
                .setTitle("返回上一层菜单？")
                .setMessage("您确定返回么？")
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity_show.this.finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create();
        dialog.show();;
    }
});
    }

    private void enter() {
       Intent intent=new Intent(this,AddActivity.class);
       startActivity(intent);
    }

}
