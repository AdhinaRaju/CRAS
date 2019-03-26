package com.example.cras;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class Login extends AppCompatActivity
{
    EditText t1;
    EditText t2;
    Button btn;
    SharedPreferences sh;
    String Username,Password;

    String namespace = "http://DBConnection/";

    String method = "Login";
    String soapAction = namespace + method;
    public static String logid;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            if(android.os.Build.VERSION.SDK_INT>9) {
                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        } catch (Exception e) { }



        t1=(EditText)findViewById(R.id.email);
        t2=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById(R.id.email_sign_in_button);
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username=t1.getText().toString();
                Password=t2.getText().toString();
                try {
                    SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String url=sh.getString("url", "");
                    SoapObject sop=new  SoapObject(namespace, method);
                    sop.addProperty("username",Username);
                    sop.addProperty("password",Password);

                    SoapSerializationEnvelope snv=new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    snv.setOutputSoapObject(sop);

                    HttpTransportSE hp=new HttpTransportSE(sh.getString("url", ""));
                    hp.call(soapAction, snv);

                    String result=snv.getResponse().toString();
                    if(!result.equalsIgnoreCase("failed"))
                    {
                        logid=result;

                        Intent a=new Intent(getApplicationContext(),UserHome.class);
                        startActivity(a);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"invalid user",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }));

        t1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i1=new Intent(getApplicationContext(), UserHome.class);
                startActivity(i1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R., menu);
        return true;
    }
}





