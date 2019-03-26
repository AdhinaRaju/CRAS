package com.example.cras;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IpSetting extends AppCompatActivity {

    EditText t1;
    Button b1;
    String ipaddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_setting);

        t1=(EditText)findViewById(R.id.editText1);

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        t1.setText(sh.getString("ipaddress", ""));
        b1=(Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ipaddress=t1.getText().toString();
                String url="http://"+ipaddress+":8080/justweb/NewWebService?wsdl";
                SharedPreferences sh=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor e=sh.edit();
                e.putString("ipaddress",ipaddress);
                e.putString("url",url);
                e.commit();

                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });
    }
}
