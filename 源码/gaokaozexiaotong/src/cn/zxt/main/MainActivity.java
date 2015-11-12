package cn.zxt.main;

import java.lang.reflect.Field;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.TabHost;
import cn.exmp1.jisuzexiaotong.R;
import cn.zxt.feedback.FeedbackLayout;
import cn.zxt.information.InformationLayout;
import cn.zxt.time.TimeLayout;

/**
 * ȱ�㣺Java���� ���� Ӣ��ƴ������ ��Ѷҳ��ֱ��д��xml
 * �ļ��� ��ѯģ���������� ��ҳҳ������tab ��ʱ
 */
public class MainActivity extends TabActivity {

	/**
	 * �ײ��˵�
	 */
	private TabHost tabHost = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tabHost = getTabHost();
		tabHost.setup();
		addTabSpec();
	}

	private void addTabSpec() {
		Intent intent = new Intent();
		intent.setClass(this, MainLayoutActivity.class);
		TabHost.TabSpec tab1 = tabHost.newTabSpec("1");
		tab1.setIndicator("��ѯ");
		tab1.setContent(intent);

		Intent intent2 = new Intent();
		intent2.setClass(this, InformationLayout.class);
		TabHost.TabSpec tab2 = tabHost.newTabSpec("2");

		tab2.setIndicator("��Ѷ", getResources().getDrawable(R.drawable.dark));
		tab2.setContent(intent2);

		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
	}

	// ����˵�
	private void setOverflowButtonAlways() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKey = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			menuKey.setAccessible(true);
			menuKey.setBoolean(config, false);
		} catch (Exception e) {
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
			Intent intent = new Intent(MainActivity.this,
					MainLayoutActivity.class);// ��һ������Ϊ��ǰ�����Acitivity���ڶ�������Ϊ��Ҫ��ת���Ľ���Activity
			startActivity(intent);
			break;

		case R.id.zixun:
			intent = new Intent(MainActivity.this, InformationLayout.class);
			startActivity(intent);
			break;
		case R.id.feedback:
			intent = new Intent(MainActivity.this, FeedbackLayout.class);
			startActivity(intent);
			break;
		case R.id.time:
			intent = new Intent(MainActivity.this, TimeLayout.class);
			startActivity(intent);
			break;

		}
		return super.onOptionsItemSelected(item);
	}

}
