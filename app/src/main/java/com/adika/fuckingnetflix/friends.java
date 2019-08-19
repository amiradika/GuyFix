package com.adika.fuckingnetflix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class friends extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StringBuffer sb = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.text);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        tv1=(TextView)findViewById(R.id.tv1);
        String data = "";
        int i = 1;
        if (is != null){
            try{
                while (((data = br.readLine()) != null)&&(i<=2)){
                    if (i==2) {
                        sb.append(data);
                    }
                    i++;
                }
                tv1.setText(sb);
                is.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    }


