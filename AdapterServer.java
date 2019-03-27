package com.example.cras;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterServer extends BaseAdapter
 {
     Context mContext;
     List<Server_Set_Get> flist;
     int pos;

     public AdapterServer(Context context, List<Server_Set_Get> list)
     {

         mContext = context;
         flist = list;
     }

     @Override
     public int getCount() {
         return flist.size();
     }

     @Override
     public Object getItem(int position) {
         return flist.get(position);
     }

     @Override
     public long getItemId(int position) {
         return 0;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent)
     {
        ViewHolder viewHolder=null;
         if(convertView==null)
         {

             convertView = View.inflate(mContext, R.layout.server_list, null);
             viewHolder=new ViewHolder();

             viewHolder.svrid= (TextView) convertView.findViewById(R.id.server_id);
             viewHolder.svrname= (TextView) convertView.findViewById(R.id.server_name);
             viewHolder.status= (TextView) convertView.findViewById(R.id.server_status);


             viewHolder.status.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     //buy
                     Toast.makeText(mContext, "solve this now", Toast.LENGTH_SHORT).show();
                     Intent i = new Intent(mContext,PendingProblem.class);
                     mContext.startActivity(i);
                 }
             });

             convertView.setTag(viewHolder);
         }
         else
         {
             viewHolder= (ViewHolder) convertView.getTag();
         }

         viewHolder.svrid.setText(flist.get(position).getServer_id());
         viewHolder.svrname.setText(flist.get(position).getServer_name());
         viewHolder.status.setText(flist.get(position).getServer_status());


         return convertView;
     }

     class ViewHolder
     {
         TextView svrname;
         TextView svrid;
         TextView status;



     }

 }
