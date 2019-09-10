package eun.com.euntalk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import eun.com.euntalk.R;

public class Client extends AppCompatActivity {
    ArrayList<String> data;
    ArrayAdapter<String> arrayAdapter;
    private Handler process; //스레드간에 메세지 전달
    Socket s;
    InputStream ins;
    OutputStream os;
    BufferedReader i;
    PrintWriter o;
    String line;
    Geocoder gc;
    String name,friend;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 강제모드정책 에러시 추가해주세요
//onCreate 매소드  setContentView(R.layout.activity_main);위에 넣어야한다
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client);
        listView =  (ListView) findViewById(R.id.listView1);
        data = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(Client.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
        Intent intent = getIntent();
        name =intent.getStringExtra("name");
        friend = intent.getStringExtra("friend");
        process = new Handler();
        Button btn01 = (Button) findViewById(R.id.button1);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed01 = (EditText) findViewById(R.id.editText1);
                String protocol = new ProtocolBuilder(1000).addObj("msg",ed01.getText().toString()).toString();
                o.println(protocol);
                ed01.setText("");
            }
        });

        new Thread(new Thread()) {
            public void run() {
                try {
                    s = new Socket("192.168.0.19", 9830); //서버에 접속을 요청한다.
                    ins = s.getInputStream(); //핸들러가  전달하는 메세지를 읽어드린다.
                    os = s.getOutputStream(); //핸들러에게 내메세지를 전달한다.
                    i = new BufferedReader(new InputStreamReader(ins, "utf-8"));
                    o = new PrintWriter(os, true);
                    HashMap<String,String> item = new HashMap<String,String>();
                    item.put("name",name.trim());
                    item.put("friend",friend.trim());
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    String protocol = new ProtocolBuilder(100).addObj("profile",item).toString();

                    o.println(protocol);
                    Log.i("sds",protocol);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        String msg = i.readLine();

                        JSONObject ob = new JSONObject(msg);
                        int protocol = ob.getInt("protocol");
                        protocol(protocol,ob);
                    } catch (IOException e) {
                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    public void protocol(int protocol, JSONObject ob) throws JSONException{
        switch (protocol){
            case 1000 : {
                    final String msg = ob.getString("msg");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.add(msg);
                        arrayAdapter.notifyDataSetChanged();
                        listView.refreshDrawableState();
                    }
                });
                break;
            }

            case 2000 : {
                JSONArray arr = ob.getJSONArray("msg");
                for(int i =0; i < arr.length();i++){
                    JSONObject msg = arr.getJSONObject(i);
                    final String mesg = msg.getString("msg");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            data.add(mesg);
                            arrayAdapter.notifyDataSetChanged();
                            listView.refreshDrawableState();
                        }
                    });
                }

                break;
            }
        }
    }

//    private Runnable showMSG = new Runnable() {
//        public void run() {
//            data.add(line);
//            arrayAdapter = new ArrayAdapter<String>(Client.this, android.R.layout.simple_list_item_1, data);
//            ListView listView = (ListView) findViewById(R.id.listView1);
//            listView.setAdapter(arrayAdapter);
//            //내아이와 친구아이를 보내줘
//        }
//    };
}