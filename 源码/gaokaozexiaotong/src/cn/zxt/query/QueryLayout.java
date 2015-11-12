package cn.zxt.query;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import cn.exmp1.jisuzexiaotong.R;

public class QueryLayout extends Activity {

	private ListView listView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//���ò����ļ�
		setContentView(R.layout.query_layout);
		//��ʼ�����
		listView = (ListView) findViewById(R.id.lv_search_school);
		//��ȡ��ת����Activity��intent����
		Intent intent = getIntent();
		//��ȡIntent������Я��������
		Bundle bundle = intent.getExtras();
		//��Bundle��ȡ��List<Map<String,String>>����
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>) bundle.getSerializable("news");
		
		SimpleAdapter adapter = new SimpleAdapter(
				getApplicationContext(), 	//�����Ķ���
				list, 						//����Դ
				R.layout.item_search, 				//List��ʾ����
				new String[]{"ID","schoolname","url"}, //List��map�ļ�ֵ
				new int[]{R.id.ID, R.id.schoolname, R.id.url});	//��䵽�Ĳ����ļ�
		
		listView.setAdapter(adapter);
		
		// ����¼�
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				try{
					TextView url = (TextView) view.findViewById(R.id.url);
					Intent intent = new Intent();       
			        intent.setAction("android.intent.action.VIEW");   
			        Uri content_url = Uri.parse(url.getText().toString());  
			        intent.setData(content_url); 
			        startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
