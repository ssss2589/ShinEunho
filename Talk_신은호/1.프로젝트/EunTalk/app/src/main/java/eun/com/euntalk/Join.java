package eun.com.euntalk;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class Join extends AppCompatActivity {
    private TextView mid,mpw,mname,msenum,mphone;
    private static final int PICK_FROM_ALBUM = 1;
    private File tempFile;
    byte[] byteArray;
    StringBuilder imagebyte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        mid=(TextView) findViewById(R.id.id_memo);
        mpw=(TextView) findViewById(R.id.pw_memo);
        mname=(TextView) findViewById(R.id.name_memo);

    }

    public void back(View v){
        finish();
    }
    public void go(View v){
        String id = mid.getText().toString();
        String pw = mpw.getText().toString();
        String name= mname.getText().toString();
        if (id==null){
            Toast.makeText(this,"가입 실패",Toast.LENGTH_SHORT).show();
        }else{
            NetworkTask networkTask = new NetworkTask(id,pw,name, null);
            networkTask.execute();
            finish();

        }
    }

    public void imageB(View v){
        tedPermission();
    }
    private void tedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                // 권한 요청 성공
                goToAlbum();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                // 권한 요청 실패
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();

    }
    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_FROM_ALBUM) {

            Uri photoUri = data.getData();
            Log.i("사진",photoUri+"asd");
            Cursor cursor = null;

            try {

                /*
                 *  Uri 스키마를
                 *  content:/// 에서 file:/// 로  변경한다.
                 */
                String[] proj = { MediaStore.Images.Media.DATA };

                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));

            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            setImage();

        }
        if (resultCode != Activity.RESULT_OK) {

            Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();

            if(tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        Log.e("삭제", tempFile.getAbsolutePath() + " 삭제 성공");
                        tempFile = null;
                    }
                }
            }

            return;
        }
    }
    StringBuilder builder;
    private void setImage() {

        ImageView imageView = findViewById(R.id.imageView);

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        File file = new File(tempFile.getAbsolutePath());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        originalBm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            FileInputStream is = new FileInputStream(file);
            boolean stop = false;
            builder = new StringBuilder();

            while(!stop) {
                int a = is.read();
                if (a == -1) {
                    break;
                }
                builder.append(a + ".");
            }
            is.close();
//            Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    try {
//                        Socket socket = new Socket("192.168.0.8", 2300);
//                        PrintWriter pwr = new PrintWriter(socket.getOutputStream(),true);
//                        pwr.println(builder.toString());
//                        pwr.close();
//                        socket.close();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    }
//            };
//            thread.start();
        }catch(Exception e){
            e.printStackTrace();
        }
//        byteArray = byteArrayOutputStream .toByteArray();
//        imagebyte = new StringBuilder();
//        for(int i=0;i<byteArray.length;i++) {
//            imagebyte.append(byteArray[i]);
//            if(i!=byteArray.length){
//                imagebyte.append("#");
//            }
//        }
//        Log.i("바이트",imagebyte.toString());
        imageView.setImageBitmap(originalBm);

    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private ContentValues values;
        private String id;
        private String pw;
        private String name;

        public NetworkTask(String id,String pw,String name, ContentValues values) {
            this.values = values;
            this.id = id;
            this.pw = pw;
            this.name = name;
        }
        @Override
        protected String doInBackground(Void... voids) {
            String result; // 요청 결과를 저장할 변수
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            if(builder == null){
                result = requestHttpURLConnection.request("http://192.168.0.19:8080/wepapp/android?command=join&id="+id+"&pw="+pw+"&name="+name, values);
            }else {
                Log.i("logi",builder.toString());
                result = requestHttpURLConnection.request("http://192.168.0.19:8080/wepapp/android?command=join&id=" + id + "&pw=" + pw + "&name=" + name, values, builder); // 해당 URL로 부터 결과물을 얻어온다.
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            }
    }
}

