package com.example.cras;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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

public class PendingProblem extends Activity {

    List<Server_Set_Get> prblmList;
    ListView list_pend;
    String namespace = "http://DBConnection/";
    String soapaction = "";
    String method = "";
   // String method1="";
   // String up = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_problem);

        prblmList = new ArrayList<>();
        list_pend = (ListView) findViewById(R.id.list_pendprblm);


        //b1.setOnClickListener(this);

        Toast.makeText(this, "opened problem", Toast.LENGTH_SHORT).show();

        try {
            Toast.makeText(this, "entered to prblm loop", Toast.LENGTH_SHORT).show();
            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
            this.method = "PrblmList";
            this.soapaction = this.namespace + this.method;
            SoapObject sop = new SoapObject(this.namespace, this.method);
            sop.addProperty("logid", Login.logid);
            SoapSerializationEnvelope snv = new SoapSerializationEnvelope(110);
            snv.setOutputSoapObject(sop);
            HttpTransportSE hp = new HttpTransportSE(sh.getString("url", ""));
            hp.call(this.soapaction, snv);
            String result = snv.getResponse().toString();
            Toast.makeText(this.getApplicationContext(), result, Toast.LENGTH_SHORT).show();

            if (!result.equalsIgnoreCase("failed")) {
                Toast.makeText(this, "3 nd enter", Toast.LENGTH_SHORT).show();
                JSONArray jsonArray = new JSONArray(result);


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Server_Set_Get m = new Server_Set_Get();

                    Toast.makeText(PendingProblem.this, "" + jsonObject.getString("server_name"), Toast.LENGTH_SHORT).show();
                    String svr = jsonObject.getString("server_id");

                    m.setS_name(svr);
                    m.setServer_id(jsonObject.getString("server_id"));
                    m.setServer_name(jsonObject.getString("server_name"));
                    m.setServer_status(jsonObject.getString("server_status"));
                    m.setServer_sdate(jsonObject.getString("server_sdate"));
                    m.setServer_stime(jsonObject.getString("server_stime"));
                    m.setServer_edate(jsonObject.getString("server_edate"));
                    m.setServer_etime(jsonObject.getString("server_etime"));
                    // m.setServer_status(jsonObject.getString("server_s"));

                    prblmList.add(m);
                }
                AdapterPrblm prblmAdapter = new AdapterPrblm(PendingProblem.this, prblmList);
                list_pend.setAdapter(prblmAdapter);

                list_pend.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(getApplicationContext(), "lists problems" + position, Toast.LENGTH_SHORT).show();

                    }
                });
            }

            else {

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
}