package com.example.anandra.custom_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ListView lview;
    MainActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readfiles();
        }

    public  void  readfiles() {
        MainActivity mActivity;
        String path = "/storage/emulated/0/Test/";
        File f = new File(path);
        String[] files = f.list();
        lview=(ListView)findViewById(R.id.lview);
        lview.setAdapter(new MyAdapter(MainActivity.this,path,files));
    }
    }


