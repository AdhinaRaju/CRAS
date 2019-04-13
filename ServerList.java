package com.example.cras;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.cras.Login.logid;

public class ServerList extends Activity /* implements View.OnClickListener*/ {

    List<Server_Set_Get> serverList;
    ListView list_server;
    TextView svrid;
    Button btnstatus;
    String namespace = "http://DBConnection/";
    String soapaction = "";
    String method = "ServerList";
    String method1 = "insertPrblm";
    String t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_list);

        serverList = new ArrayList<>();
        list_server = (ListView) findViewById(R.id.list_server);

        svrid = (TextView) findViewById(R.id.server_id);

        btnstatus = (Button) findViewById(R.id.server_status);
       //21 btnstatus.setOnClickListener(this);


        Toast.makeText(this, "opened", Toast.LENGTH_SHORT).show();

        try {
            Toast.makeText(this, "enter", Toast.LENGTH_SHORT).show();
            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
            //this.method = "ServerList";
            this.soapaction = this.namespace + this.method;
            SoapObject sop = new SoapObject(this.namespace, this.method);
            sop.addProperty("logid", logid);
            Toast.makeText(this.getApplicationContext(), logid, Toast.LENGTH_SHORT).show();
            SoapSerializationEnvelope snv = new SoapSerializationEnvelope(110);
            snv.setOutputSoapObject(sop);
            HttpTransportSE hp = new HttpTransportSE(sh.getString("url", ""));
            hp.call(this.soapaction, snv);
            String result = snv.getResponse().toString();
            Toast.makeText(this.getApplicationContext(), result, Toast.LENGTH_SHORT).show();

            if (!result.equalsIgnoreCase("failed")) {
                Toast.makeText(this, "2 nd enter", Toast.LENGTH_SHORT).show();
                JSONArray jsonArray = new JSONArray(result);


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Server_Set_Get m = new Server_Set_Get();

                    Toast.makeText(ServerList.this, "" + jsonObject.getString("server_name"), Toast.LENGTH_SHORT).show();
                    String svr = jsonObject.getString("server_id");

                    m.setS_name(svr);
                    m.setServer_id(jsonObject.getString("server_id"));
                    m.setServer_name(jsonObject.getString("server_name"));
                    m.setServer_status(jsonObject.getString("server_status"));
                    serverList.add(m);
                }
                AdapterServer serverAdapter = new AdapterServer(ServerList.this, serverList);
                list_server.setAdapter(serverAdapter);

                list_server.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(getApplicationContext(), "lists" + position, Toast.LENGTH_SHORT).show();

                    }
                });

            } else {

                Toast.makeText(this.getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
            }


        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* @Override
    public void onClick(View view) {

        t1 = svrid.getText().toString();

        try {
            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(ServerList.this.getApplicationContext());

            SoapObject sop = new SoapObject(ServerList.this.namespace, ServerList.this.method1);
            sop.addProperty("logid", Login.logid);
            sop.addProperty("server_id", ServerList.this.t1);

            SoapSerializationEnvelope snv = new SoapSerializationEnvelope(110);
            snv.setOutputSoapObject(sop);
            HttpTransportSE hp = new HttpTransportSE(sh.getString("url", ""));
            hp.call(ServerList.this.soapaction, snv);
            String result = snv.getResponse().toString();
            Toast.makeText(ServerList.this.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            Intent i;
            if (result.equalsIgnoreCase("updated")) {
                Toast.makeText(ServerList.this.getApplicationContext(), "Successful..", Toast.LENGTH_SHORT).show();
                i = new Intent(ServerList.this.getApplicationContext(), UserHome.class);
                ServerList.this.startActivity(i);
            }

            if (result.equalsIgnoreCase("failed")) {
                Toast.makeText(ServerList.this.getApplicationContext(), "sorry..try again..", Toast.LENGTH_SHORT).show();
            }

            i = new Intent(ServerList.this.getApplicationContext(), UserHome.class);
            ServerList.this.startActivity(i);
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    } */
}




