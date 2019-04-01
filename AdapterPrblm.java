package com.example.cras;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

    public class AdapterPrblm extends BaseAdapter
    {
        Context mContext;
        List<Server_Set_Get> flist;
        int pos;

        public AdapterPrblm(Context context, List<Server_Set_Get> list)
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
            com.example.cras.AdapterPrblm.ViewHolder viewHolder=null;
            if(convertView==null)
            {

                convertView = View.inflate(mContext, R.layout.server_list, null);
                viewHolder=new com.example.cras.AdapterPrblm.ViewHolder();

                viewHolder.svrid= (TextView) convertView.findViewById(R.id.server_id);
                viewHolder.svrname= (TextView) convertView.findViewById(R.id.server_name);
                viewHolder.status= (TextView) convertView.findViewById(R.id.server_status);
                viewHolder.sdate= (TextView) convertView.findViewById(R.id.server_sdate);
                viewHolder.stime= (TextView) convertView.findViewById(R.id.server_stime);
                viewHolder.edate= (TextView) convertView.findViewById(R.id.server_edate);
                viewHolder.etime= (TextView) convertView.findViewById(R.id.server_etime);



                viewHolder.slove= (Button) convertView.findViewById(R.id.btn_solved);
                viewHolder.escalate = (Button) convertView.findViewById(R.id.btn_escalate);



                viewHolder.slove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // add to cart
                        Toast.makeText(mContext, "Sucessfully Resolved", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(mContext,UserHome.class);
                        mContext.startActivity(i);

                        //asynk task

                    }
                });

                viewHolder.escalate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        Toast.makeText(mContext, "transfer this now", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(mContext,UserHome.class);
                        mContext.startActivity(i);
                    }
                });


                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder= (com.example.cras.AdapterPrblm.ViewHolder) convertView.getTag();
            }

            viewHolder.svrid.setText(flist.get(position).getServer_id());
            viewHolder.svrname.setText(flist.get(position).getServer_name());
            viewHolder.status.setText(flist.get(position).getServer_status());
            viewHolder.stime.setText(flist.get(position).getServer_stime());
            viewHolder.etime.setText(flist.get(position).getServer_sdate());
            viewHolder.sdate.setText(flist.get(position).getServer_etime());
            viewHolder.edate.setText(flist.get(position).getServer_edate());
            // viewHolder.status.setText(flist.get(position).getServer_status());


            return convertView;
        }

        class ViewHolder
        {
            TextView svrname;
            TextView svrid;
            TextView status;
            TextView stime;
            TextView etime;
            TextView edate;
            TextView sdate;
            Button slove;
            Button escalate;



        }
    }





