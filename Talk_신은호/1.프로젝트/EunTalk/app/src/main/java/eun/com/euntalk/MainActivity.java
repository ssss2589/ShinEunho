package eun.com.euntalk;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText idm,pwm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void join(View v){
        Intent intent =new Intent(MainActivity.this,Join.class);
        startActivity(intent);
    }
    public void login(View v){
        idm=(EditText)findViewById(R.id.id_memo);
        pwm=(EditText)findViewById(R.id.pw_memo);
        String id=idm.getText().toString();
        String pw=pwm.getText().toString();
        NetworkTask networkTask = new NetworkTask(id,pw, null);
        networkTask.execute();
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private ContentValues values;
        private String id;
        private String pw;

        public NetworkTask(String id,String pw, ContentValues values) {
            this.values = values;
            this.id = id;
            this.pw = pw;
        }

        @Override
        protected String doInBackground(Void... voids) {
            String result; // 요청 결과를 저장할 변수
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request("http://192.168.0.19:8080/wepapp/android?command=login&id="+id+"&pw="+pw, values); // 해당 URL로 부터 결과물을 얻어온다.
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray msg = new JSONObject(s).getJSONArray("info");
                JSONObject jobject = msg.getJSONObject(0);
                String result = jobject.optString("msg");
                String name = jobject.optString("name");
                Log.i("1",name);
                if(result.equals("로그인 성공")){
                    Intent intent = new Intent(MainActivity.this,FriendList.class);
                    intent.putExtra("id",id);
                    intent.putExtra("name",name);
                    startActivity(intent);
                    finish();
                }
                else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,"로그인 실패",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
