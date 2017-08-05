package com.example.anandra.custom_listview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MyAdapter extends BaseAdapter {
    public MainActivity mActivity;
    String path;
    String[] files;


    public MyAdapter(MainActivity mActivity, String path, String[] files) {
        this.mActivity=mActivity;
        this.path=path;
        this.files=files;
    }

/*   MainActivity mActivity;
    String path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/";
    File f=new File(path);
    String[] files=f.list();*/

    @Override
    public int getCount() {
        return  files.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(mActivity);
        View v=inflater.inflate(R.layout.indiview,null);
        ImageView iview1=(ImageView)v.findViewById(R.id.iview1);
        TextView tv1=(TextView)v.findViewById(R.id.tv1);
        TextView tv2=(TextView)v.findViewById(R.id.tv1);
        Button b1=(Button)v.findViewById(R.id.b1);
      final File indi_file=new File(path+files[i]);
        iview1.setImageURI(Uri.fromFile(indi_file));
        tv1.setText(indi_file.getName());
        tv2.setText(String.valueOf(indi_file.length()));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indi_file.delete();
                File f=new File(path);
                files=f.list();
                MyAdapter.this.notifyDataSetChanged();
                files=f.list();

            }
        });

        return v;
    }
}
