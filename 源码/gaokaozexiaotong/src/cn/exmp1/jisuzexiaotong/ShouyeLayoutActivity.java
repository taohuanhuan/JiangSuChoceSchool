package cn.exmp1.jisuzexiaotong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import cn.exmp1.chaxunhou.Chaxunhou2;
import cn.exmp1.chaxunhou.ChaxunhouLayout;
import cn.exmp1.jisuzexiaotong.ShouyeLayoutActivity.SpinnerSelectedListener;

public class ShouyeLayoutActivity extends Activity implements OnClickListener {
	private EditText et_score, et_school, et_year;
	public DBManager dbHelper; // 定义数据库操作项

	private static final String[] k = { "文科", "理科", "音乐", "美术", "体育" };
	private TextView view;
	private Spinner spinner; // 声明下拉菜单
	private ArrayAdapter<String> adapter;

	SpinnerSelectedListener menu = new SpinnerSelectedListener();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shouye_layout);
		dbHelper = new DBManager(this);
		dbHelper.openDatabase();

		et_score = (EditText) findViewById(R.id.et_score);
		et_school = (EditText) findViewById(R.id.et_school);
		et_year = (EditText) findViewById(R.id.et_year);
		findViewById(R.id.bt_school).setOnClickListener(this);
		findViewById(R.id.bt_score).setOnClickListener(this);
		/**
		 * 下拉列表
		 */

		view = (TextView) findViewById(R.id.spinnerText);
		spinner = (Spinner) findViewById(R.id.spinner1);
		// 将可选内容与ArrayAdapter连接起来
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, k);
		// 设置下拉列表风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 将adapter 添加到spinner中
		spinner.setAdapter(adapter);
		// 添加Spinner事件监听
		spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
		// 设置默认
		spinner.setVisibility(view.VISIBLE);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.bt_score:
			scorequery();
			break;
		case R.id.bt_school:
			schoolquery();
		default:
			break;
		}
	}

	// 查询分数，分科。
	private void scorequery() {
		
		String year = et_year.getText().toString();
		String schoolscore = et_score.getText().toString();// 获取内容
		// System.out.println(cardNumber);
		// Cursor cursor2 =
		// dbHelper.getReadableDatabase().rawQuery("select f_ma,f_school from T_schoolcontent where f_score = 200",
		// null);
		Cursor cursor2 = dbHelper
				.getReadableDatabase()
				.rawQuery(
						"select f_year,f_ma,f_type,f_subject,f_xuan,f_score,f_school from T_schoolcontent where f_score = ? AND f_year = ?",
						new String[] { schoolscore, year });
		Bundle bundle2 = new Bundle();
		bundle2.putSerializable("news", cursor2list1(cursor2));
		Intent intent = new Intent(ShouyeLayoutActivity.this, Chaxunhou2.class);
		intent.putExtras(bundle2);
		startActivity(intent);

	}

	private ArrayList<Map<String, String>> cursor2list1(Cursor cursor2) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

		while (cursor2.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("f_yaear", cursor2.getString(0));
			map.put("f_ma", cursor2.getString(1));
			map.put("schoolname", cursor2.getString(2));
			map.put("f_type", cursor2.getString(3));
			map.put("f_subject", cursor2.getString(4));
			map.put("f_xuan", cursor2.getString(5));
			map.put("f_score", cursor2.getString(6));

			list.add(map);
		}
		return list;

	}

	// 查询学校 ，并且把他显示在指定位置

	private void schoolquery() {
		// System.out.println("123");
		String schoolname = et_school.getText().toString();// 获取内容
		// System.out.println(schoolname);like '"+temp+"' order by f_id
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
				"SELECT * FROM T_schoolvrl where f_school like '%" + schoolname
						+ "%' order by f_id", null);
		// 内容传递
		Bundle bundle = new Bundle();
		bundle.putSerializable("news", cursor2list(cursor));
		Intent intent = new Intent(ShouyeLayoutActivity.this,
				ChaxunhouLayout.class);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	private ArrayList<Map<String, String>> cursor2list(Cursor cursor) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

		while (cursor.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("ID", cursor.getString(0));
			map.put("schoolname", cursor.getString(1));
			map.put("url", cursor.getString(2));
			list.add(map);
		}
		return list;
	}

	// 下拉列表的选中 获取下拉菜单的值
	public class SpinnerSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			String cardNumber = k[arg2];
			view.setText("考生类型：");
		}

		public void onNothingSelected(AdapterView<?> arg0) {
		}
	}

	protected void onDestroy() {
		super.onDestroy();
		if (dbHelper != null)
			dbHelper.close();
	}
}
