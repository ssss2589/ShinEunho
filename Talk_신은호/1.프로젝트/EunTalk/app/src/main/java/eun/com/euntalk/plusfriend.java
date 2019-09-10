package eun.com.euntalk;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class plusfriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String Mid = intent.getStringExtra("Mid").trim();
        String Fname = intent.getStringExtra("Fid").trim();
        Log.i("1",Mid);
        Log.i("2",Fname);
        /* 아이템 추가 및 어댑터 등록 */
        NetworkTask networkTask = new NetworkTask("http://192.168.0.19:8080/wepapp/android?command=plusfriend&Mid="+Mid+"&Fname="+Fname, null);
        networkTask.execute();
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private ContentValues values;
        private String url;

        public NetworkTask(String url, ContentValues values) {
            this.values = values;
            this.url = url;
        }

        @Override
        protected String doInBackground(Void... voids) {
            String result; // 요청 결과를 저장할 변수
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
            return result;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            finish();

        }
    }
}
