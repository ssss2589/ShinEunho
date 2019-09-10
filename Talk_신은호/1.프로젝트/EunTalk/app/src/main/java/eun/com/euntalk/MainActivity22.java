package eun.com.euntalk;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

public class MainActivity22 extends AppCompatActivity {
    EditText idm,pwm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://192.168.0.19:8080/wepapp/android?command=profile";
        NetworkTask networkTask = new NetworkTask(url,null);
        networkTask.execute();
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private ContentValues values;
        private String url;

    public NetworkTask(String url,ContentValues values) {
        this.values = values;
        this.url=url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result; // 요청 결과를 저장할 변수
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
        StringBuilder builder = new StringBuilder(result);
        Log.i("asd",builder.toString());

/*        int[] group = new int[0];
        StringBuilder builder1 = new StringBuilder();
        for (int i = 0, x = 0; i < result.length(); i++) {
            if (result.charAt(i) == '.') {
                int su =Integer.parseInt(builder.substring(x, i).toString());
                int[] y = new int[group.length + 1];
                System.arraycopy(group, 0, y, 0, group.length);
                group = y;
                y[y.length - 1] = su;
                x = i + 1;
            }
        }


        Log.i("sds",group.length+"");
       final Bitmap originalBm =  BitmapFactory.decodeByteArray(group,0,group.length);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ImageView)findViewById(R.id.test)).setImageBitmap(originalBm);
            }
        });*/

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
}
