package cn.exmp1.jisuzexiaotong;

import java.lang.reflect.Field;

import cn.exmp1.fankui.FankuiLayout;
import cn.exmp1.shiian.TimeLayout;
import cn.exmp1.zixun.ZixunLayout;



import android.app.TabActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.TabHost;
import android.widget.Toast;



public class MainActivity extends TabActivity {
	
	/**
	 * 底部菜单
	 */
	private TabHost tabHost = null ;
	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	    
		tabHost = getTabHost(); 
		tabHost.setup();
		addTabSpec();
	}
	private void addTabSpec() {
		Intent intent = new Intent();
		intent.setClass(this, ShouyeLayoutActivity.class);
		TabHost.TabSpec tab1 =
			tabHost.newTabSpec("1");
			tab1.setIndicator("查询");
			tab1.setContent(intent);
				
		Intent intent2 = new Intent();
		intent2.setClass(this, ZixunLayout.class);
		TabHost.TabSpec tab2 =
			tabHost.newTabSpec("2");

		tab2.setIndicator("资讯",getResources()
				.getDrawable(R.drawable.dark));
		tab2.setContent(intent2);	
		
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);	
	}
	//整体菜单
	private void setOverflowButtonAlways() {
		try
		{
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKey = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKey.setAccessible(true);
			menuKey.setBoolean(config, false);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.shouye_layout, menu);
		return true;
	}
	
	  public boolean onOptionsItemSelected(MenuItem item) {
		    	switch (item.getItemId()) {
				case R.id.chaxun:
					Intent intent=new Intent(MainActivity.this, ShouyeLayoutActivity.class);//第一个参数为当前界面的Acitivity，第二个参数为需要跳转到的界面Activity
					startActivity(intent);
					break;

				case R.id.zixun:
					intent=new Intent(MainActivity.this, ZixunLayout.class);
					startActivity(intent); 
					break;
				case R.id.feedback:
					intent=new Intent(MainActivity.this,FankuiLayout.class);
					startActivity(intent); 
					break;
				case R.id.time:
					intent=new Intent(MainActivity.this, TimeLayout.class);
					startActivity(intent); 
					break;
						
				}
		    	return super.onOptionsItemSelected(item);
		}
	
}
