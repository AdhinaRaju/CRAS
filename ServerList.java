package com.example.cras;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ServerList extends AppCompatActivity implements View.OnClickListener{

    List<Server_Set_Get> serverList;
    ListView list_server;
    TextView txtstatus;
    String namespace = "http://DBConnection/";
    String soapaction="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_list);

        serverList = new ArrayList<>();
        list_server = (ListView) findViewById(R.id.list_server);

        txtstatus=(TextView)findViewById(R.id.status);

       txtstatus.setOnClickListener(this);

        Toast.makeText(this, "listed", Toast.LENGTH_SHORT).show();
        Server_Asynk obj = new Server_Asynk();
        obj.execute();

    }

    public void onClick(View v) {
        Intent obj=new Intent(ServerList.this,PendingProblem.class);
        startActivity(obj);
    }

    class Server_Asynk extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}


