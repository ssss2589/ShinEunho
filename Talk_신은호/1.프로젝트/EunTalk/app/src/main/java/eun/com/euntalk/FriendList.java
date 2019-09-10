package eun.com.euntalk;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Picture;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class FriendList extends AppCompatActivity {
   static  ListView mListView;
    String id;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendlist);

        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        /* 아이템 추가 및 어댑터 등록 */
        NetworkTask networkTask = new NetworkTask("http://192.168.0.19:8080/wepapp/android?command=memberlist&id=" + id, null);
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

        private PopupWindow mPopupWindow;

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<MemberVO> memberList = new ArrayList<>();
            try {
                Log.i("protocol", s);
                final MyAdapter mMyAdapter = new MyAdapter();
                final ArrayList<FriendVO> frivolist = new ArrayList<>();
                JSONArray jsonArray = new JSONObject(s).getJSONArray("member");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject member = jsonArray.getJSONObject(i);
                    MemberVO mem = new MemberVO();
                    mem.setId(member.getString("id"));
                    mem.setPw(member.getString("pw"));
                    mem.setName(member.getString("name"));
                    mem.setFrendStats(member.getInt("frendstats"));
                    mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.start), mem.getName(), "contents_" + i, mem);

                }
                mListView.setAdapter(mMyAdapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    boolean friend = false;

                    class NetworkTask2 extends AsyncTask<Void, Void, String> {
                        private ContentValues values = null;
                        private String id;
                        int position;
                        public NetworkTask2(String id,int position) {
                            this.id = id;
                            this.position = position;
                        }

                        @Override
                        protected String doInBackground(Void... voids) {
                            String result; // 요청 결과를 저장할 변수
                            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
                            result = requestHttpURLConnection.request("http://192.168.0.19:8080/wepapp/android?command=friendCheck&name=" + id + "&id=" + FriendList.this.id, values); // 해당 URL로 부터 결과물을 얻어온다.
                            return result;
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            friend = Boolean.parseBoolean(s);
                            Log.i("frendstats",friend+"");
                            if (friend) {
                                Intent intent = new Intent(FriendList.this, Client.class);
                                Log.i("2",FriendList.this.name);
                                intent.putExtra("name", FriendList.this.name);
                                intent.putExtra("friend", mMyAdapter.getItem(position).getName());
                                startActivity(intent);
                            } else {
                                View popupView = getLayoutInflater().inflate(R.layout.dialog_activity, null);
                                mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                //popupView 에서 (LinearLayout 을 사용) 레이아웃이 둘러싸고 있는 컨텐츠의 크기 만큼 팝업 크기를 지정

                                mPopupWindow.setFocusable(true);
                                // 외부 영역 선택히 PopUp 종료

                                mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);


                                Button cancel = (Button) popupView.findViewById(R.id.Cancel);
                                cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        mPopupWindow.dismiss();
                                    }
                                });

                                Button ok = (Button) popupView.findViewById(R.id.Ok);
                                ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(FriendList.this, plusfriend.class);
                                        intent.putExtra("Mid", FriendList.this.id);
                                        intent.putExtra("Fid", mMyAdapter.getItem(position).getName());
                                        startActivity(intent);
                                        mPopupWindow.dismiss();
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long l) {
                        MemberVO member = mMyAdapter.getMember(position);
                        NetworkTask2 natworttask = new NetworkTask2(member.getName(),position);
                        natworttask.execute();

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
