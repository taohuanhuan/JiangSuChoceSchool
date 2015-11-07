package cn.exmp1.chaxunhou;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import cn.exmp1.jisuzexiaotong.R;

public class Chaxunhou2 extends Activity {

private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//���ò����ļ�
		setContentView(R.layout.chaxunhou2);
		//��ʼ�����
		listView = (ListView) findViewById(R.id.lv_search_school);
		//��ȡ��ת����Activity��intent����
		Intent intent = getIntent();
		//��ȡIntent������Я��������
		Bundle bundle2 = intent.getExtras();
		//��Bundle��ȡ��List<Map<String,String>>����
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)bundle2.getSerializable("news");
		
		SimpleAdapter adapter = new SimpleAdapter(
				getApplicationContext(), 	//�����Ķ���
				list, 						//����Դ
				R.layout.item_search, 				//List��ʾ����
				new String[]{"f_year","f_ma","schoolname","f_type","f_subject","f_xuan","f_score"}, //List��map�ļ�ֵ
				new int[]{R.id.ID, R.id.schoolname,R.id.type,R.id.xuan,R.id.score,R.id.score2,R.id.score3});	//��䵽�Ĳ����ļ�

		listView.setAdapter(adapter);
	}
}


