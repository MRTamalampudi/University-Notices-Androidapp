package com.example.notices;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class home extends AppCompatActivity {
    String[] notice_id;
    String hi="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        notice_connect();
    }

    public void prev(View view) {
        int a=Integer.parseInt(hi);
        if (a==1){
            a=1;
        }
        else{
            a--;
        }
        hi=Integer.toString(a);
        notice_connect();
    }

    public void next(View view) {
        int a=Integer.parseInt(hi);
        a++;
        hi=Integer.toString(a);
        notice_connect();
    }
    public void notice_connect(){
        final TextView textview1=(TextView)findViewById(R.id.textView1);
        final TextView textview2=(TextView)findViewById(R.id.textView2);
        final TextView textview3=(TextView)findViewById(R.id.textView3);
        final TextView textview4=(TextView)findViewById(R.id.textView4);
        final TextView textview5=(TextView)findViewById(R.id.textView5);
        final TextView textview6=(TextView)findViewById(R.id.textView6);
        final TextView textview7=(TextView)findViewById(R.id.textView7);
        final TextView textview8=(TextView)findViewById(R.id.textView8);
        final TextView textview9=(TextView)findViewById(R.id.textView9);
        final TextView textview10=(TextView)findViewById(R.id.textView10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] str = new String[0];
                try {
                    Document document=Jsoup.connect("http://intranet.rguktn.ac.in/SMS/notices/getnotice.php?page="+hi).get();
                    Elements notice_links=document.select("a[href=#]");
                    List<String> href =notice_links.eachAttr("data-href");
                    notice_id=href.toArray(new String[0]);
                    List<String> notice=notice_links.eachText();
                    String[] notice_array=notice.toArray(new String[0]);
                    str=notice_array.clone();
                } catch (IOException e) {

                }
                final String[] finall=str;
                textview1.post(new Runnable() {
                    @Override
                    public void run() {

                        textview1.setText(finall[0]);
                        textview2.setText(finall[1]);
                        textview3.setText(finall[2]);
                        textview4.setText(finall[3]);
                        textview5.setText(finall[4]);
                        textview6.setText(finall[5]);
                        textview7.setText(finall[6]);
                        textview8.setText(finall[7]);
                        textview9.setText(finall[8]);
                        textview10.setText(finall[9]);


                    }
                });

            }
        }).start();
    }
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    public void notice1(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[0]);
        startActivity(notice_view);

    }

    public void notice2(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[1]);
        startActivity(notice_view);
    }
    public void notice3(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[2]);
        startActivity(notice_view);
    }
    public void notice4(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[3]);
        startActivity(notice_view);
    }
    public void notice5(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[4]);
        startActivity(notice_view);
    }
    public void notice6(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[5]);
        startActivity(notice_view);
    }
    public void notice7(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[6]);
        startActivity(notice_view);
    }
    public void notice8(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[7]);
        startActivity(notice_view);
    }
    public void notice9(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[8]);
        startActivity(notice_view);
    }
    public void notice10(View view) {
        Intent notice_view=new Intent(home.this,notice_view.class);
        notice_view.putExtra("notice_id",notice_id[9]);
        startActivity(notice_view);
    }
}