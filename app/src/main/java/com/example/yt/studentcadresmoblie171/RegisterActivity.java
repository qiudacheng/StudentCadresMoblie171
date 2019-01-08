package com.example.yt.studentcadresmoblie171;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    private EditText et_user_name,et_psw,et_psw_again;

    private String userName,psw,pswAgain;
    private RadioGroup Sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {


        Button btn_register = (Button) findViewById(R.id.btn_register);
        et_user_name= (EditText) findViewById(R.id.et_user_name);
        et_psw= (EditText) findViewById(R.id.et_psw);
        et_psw_again= (EditText) findViewById(R.id.et_psw_again);
        Sex= (RadioGroup) findViewById(R.id.SexRadio);
        btn_register.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {


                getEditString();
                int sex;
                int sexChoseId = Sex.getCheckedRadioButtonId();
                switch (sexChoseId) {
                    case R.id.mainRegisterRdBtnFemale:
                        sex = 0;
                        break;
                    case R.id.mainRegisterRdBtnMale:
                        sex = 1;
                        break;
                    default:
                        sex = -1;
                        break;
                }

                if(TextUtils.isEmpty(userName)){
                   Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(pswAgain)) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                } else if (sex<0){
                    Toast.makeText(RegisterActivity.this, "请选择性别", Toast.LENGTH_SHORT).show();
                }else if(!psw.equals(pswAgain)){
                    Toast.makeText(RegisterActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();

                }else if(isExistUserName(userName)){
                    Toast.makeText(RegisterActivity.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                    saveRegisterInfo(userName, psw);

                   Intent data = new Intent();
                    data.putExtra("userName", userName);
                    setResult(RESULT_OK, data);

                    RegisterActivity.this.finish();
                }
            }
        });
    }

    private void getEditString(){
        userName=et_user_name.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }

    private boolean isExistUserName(String userName){
        boolean has_userName=false;
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);

        String spPsw=sp.getString(userName, "");
            if(!TextUtils.isEmpty(spPsw)) {
            has_userName=true;
        }
        return has_userName;
    }

    private void saveRegisterInfo(String userName,String psw){
        String md5Psw = (psw);//把密码用MD5加密

        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);

        SharedPreferences.Editor editor=sp.edit();

        editor.putString(userName, md5Psw);

        editor.apply();
    }
}
