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
		
		//设置布局文件
		setContentView(R.layout.chaxunhou2);
		//初始化组件
		listView = (ListView) findViewById(R.id.lv_search_school);
		//获取跳转到该Activity的intent对象
		Intent intent = getIntent();
		//获取Intent对象所携带的数据
		Bundle bundle2 = intent.getExtras();
		//从Bundle中取出List<Map<String,String>>数据
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>)bundle2.getSerializable("news");
		
		SimpleAdapter adapter = new SimpleAdapter(
				getApplicationContext(), 	//上下文对象
				list, 						//数据源
				R.layout.item_search, 				//List显示布局
				new String[]{"f_year","f_ma","schoolname","f_type","f_subject","f_xuan","f_score"}, //List中map的键值
				new int[]{R.id.ID, R.id.schoolname,R.id.type,R.id.xuan,R.id.score,R.id.score2,R.id.score3});	//填充到的布局文件

		listView.setAdapter(adapter);
	}
}


