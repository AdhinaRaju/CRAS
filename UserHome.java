package com.example.cras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity implements View.OnClickListener  {

    Button svr,pend,rsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        svr=(Button)findViewById(R.id.button);
        pend=(Button)findViewById(R.id.button2);
        rsp =(Button) findViewById(R.id.button3);

        svr.setOnClickListener(this);
        pend.setOnClickListener(this);
        rsp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v==svr)
        {
            Intent obj=new Intent(UserHome.this,ServerList.class);
            startActivity(obj);
        }
        if(v==pend)
        {
            Intent obj=new Intent(UserHome.this,PendingProblem.class);
            startActivity(obj);
        }
        if(v==rsp)
        {
            Intent obj1=new Intent(UserHome.this,ResolvedProblems.class);
            startActivity(obj1);
        }
    }



}
