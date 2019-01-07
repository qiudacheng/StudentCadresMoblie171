package com.example.yt.studentcadresmoblie171;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    MyHelper myhelper;
    private Button mBtnAdd;
    private Button mBtnUpdate;
    private Button mBtnQuery;
    private Button mBtnDelete;
    private TextView mTvShow,mTvname,mTvnublem,mTvzhiwu,mTvclass;
    private EditText Edtname,Edtnublem,Edtzhiwu,Edtclass;
    private CheckBox Checkstu,Checkyishu,Checkshetuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_add);
       myhelper=new MyHelper(this);
       init();
        Toast.makeText(this, "welcome，管理员", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "请在以上操作中选择一项进行操作", Toast.LENGTH_LONG).show();
    }

    private void init() {
        mBtnAdd=findViewById(R.id.btn_add_add);
        mBtnUpdate=findViewById(R.id.btn_add_update);
        mBtnQuery=findViewById(R.id.btn_add_chaxun);
        mBtnDelete=findViewById(R.id.btn_add_delete);
        mTvShow=findViewById(R.id.tv_show);
        mTvname=findViewById(R.id.tv_add_name);
        mTvnublem=findViewById(R.id.tv_add_nublem);
        mTvzhiwu=findViewById(R.id.tv_add_zhiwu);
        mTvclass=findViewById(R.id.tv_add_class);
        Edtname=findViewById(R.id.EdtTxt_add_name);
        Edtnublem=findViewById(R.id.EdtTxt_add_nublem);
        Edtzhiwu=findViewById(R.id.EdtTxt_add_zhiwu);
        Edtclass=findViewById(R.id.EdtTxt_add_class);
        Checkstu=findViewById(R.id.checkBox_stu);
        Checkyishu=findViewById(R.id.checkBox_yishu);
        Checkshetuan=findViewById(R.id.checkBox_shetuan);
        mBtnAdd.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String name;
        String Class;
        String zhiwu;
        String nublem;
        String stu="";
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()){
            case R.id.btn_add_add:
                name=Edtname.getText().toString().trim();
                Class=Edtclass.getText().toString().trim();
                zhiwu=Edtzhiwu.getText().toString().trim();
                nublem= Edtnublem.getText().toString().trim();
                db=myhelper.getWritableDatabase();
               values=new ContentValues();
               values.put("name",name);
               values.put("class",Class);
               values.put("zhiwu",zhiwu);
               values.put("nublem",nublem);
               if (Checkstu.isChecked()) {
                   stu += Checkstu.getText().toString().trim();
               }
               else if (Checkshetuan.isChecked()) {
                    stu+= Checkshetuan.getText().toString().trim();
                }
                if (Checkyishu.isChecked()){
                    stu+= Checkyishu.getText().toString().trim();
                }
               values.put("home",stu);
               db.insert("information","name",values);
               if (name==null||name.trim().equals("")){
                   Toast.makeText(this,"姓名为空,不允许添加",Toast.LENGTH_SHORT).show();
               }else if (stu==null||stu.trim().equals("")){
                   Toast.makeText(this,"所属为空,不允许添加",Toast.LENGTH_SHORT).show();
               }
               else if(zhiwu==null||zhiwu.trim().equals("")){
                   Toast.makeText(this,"职务为空,不允许添加",Toast.LENGTH_SHORT).show();
               }else if(Class==null||Class.trim().equals("")){
                   Toast.makeText(this,"班级为空,不允许添加",Toast.LENGTH_SHORT).show();
               }else if(nublem==null||nublem.trim().equals("")){
                   Toast.makeText(this,"学号为空,不允许添加",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(this,"学生干部信息添加成功",Toast.LENGTH_SHORT).show();
               }
               db.close();
               break;

           case R.id.btn_add_chaxun:
                name=Edtname.getText().toString().trim();
                Class=Edtclass.getText().toString().trim();
                zhiwu=Edtzhiwu.getText().toString().trim();
                nublem= Edtnublem.getText().toString().trim();
                db=myhelper.getWritableDatabase();
                values=new ContentValues();
                values.put("name",name);
                values.put("class",Class);
                values.put("zhiwu",zhiwu);
                values.put("nublem",nublem);
                if (Checkstu.isChecked()) {
                    stu += Checkstu.getText().toString().trim();
                }
                else if (Checkshetuan.isChecked()) {
                    stu+= Checkshetuan.getText().toString().trim();
                }
                if (Checkyishu.isChecked()){
                    stu+= Checkyishu.getText().toString().trim();
                }
                values.put("home",stu);
                db=myhelper.getReadableDatabase();
                Cursor cursor=db.query("information",null,null,null,null,null,null);
                if (cursor.getCount()==0){
                    mTvShow.setText("");
                    Toast.makeText(this,"没有信息",Toast.LENGTH_SHORT).show();
                }
                else {
                    cursor.moveToFirst();
                    mTvShow.setText("name"+cursor.getString(1)+"nublem"+cursor.getString(2)+"class"+cursor.getString(3)+"zhiwu"+cursor.getString(4)+"stu"+cursor.getString(5));


                }
                while (cursor.moveToFirst()){
                    mTvShow.append("name"+cursor.getString(1)+"nublem"+cursor.getString(2)+"class"+cursor.getString(3)+"zhiwu"+cursor.getString(4)+"stu"+cursor.getString(5));
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_add_delete:
                db=myhelper.getWritableDatabase();
                db.delete("information",null,null);
                Toast.makeText(this,"全部信息已删除",Toast.LENGTH_SHORT).show();
                mTvShow.setText("");
                db.close();
                break;

        }




    }

    public class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context) {
            super(context, "itcast.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),nublem  VARCHAR(20),class  VARCHAR(20),zhiwu  VARCHAR(20),home  VARCHAR(20))");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
