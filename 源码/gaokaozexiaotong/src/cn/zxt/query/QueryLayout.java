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
		
		//设置布局文件
		setContentView(R.layout.query_layout);
		//初始化组件
		listView = (ListView) findViewById(R.id.lv_search_school);
		//获取跳转到该Activity的intent对象
		Intent intent = getIntent();
		//获取Intent对象所携带的数据
		Bundle bundle = intent.getExtras();
		//从Bundle中取出List<Map<String,String>>数据
		@SuppressWarnings("unchecked")
		List<Map<String, String>> list = (List<Map<String, String>>) bundle.getSerializable("news");
		
		SimpleAdapter adapter = new SimpleAdapter(
				getApplicationContext(), 	//上下文对象
				list, 						//数据源
				R.layout.item_search, 				//List显示布局
				new String[]{"ID","schoolname","url"}, //List中map的键值
				new int[]{R.id.ID, R.id.schoolname, R.id.url});	//填充到的布局文件
		
		listView.setAdapter(adapter);
		
		// 点击事件
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
