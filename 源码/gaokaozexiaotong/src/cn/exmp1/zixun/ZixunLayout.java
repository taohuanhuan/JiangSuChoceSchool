package cn.exmp1.zixun;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.exmp1.jisuzexiaotong.R;
import cn.exmp1.jisuzexiaotong.ShouyeLayoutActivity;

public class ZixunLayout extends Activity {
	ListView mlvGeneral;
	List<GeneralBean> mGenerals;//代表十个军事家的集合
	GeneralAdapter mAdapter;
	int[] resid={
		R.drawable.z1,R.drawable.z2,R.drawable.z3,
		R.drawable.z4,R.drawable.z5,R.drawable.z6,
		R.drawable.z7
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zixun_layout);
		initData();//初始化数据
		initView();	
		setListener();
	}
	
	private void setListener() {
		setOnItemClickListener();
		
	}


	private void setOnItemClickListener() {
		mlvGeneral.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {				
				
				Intent intent = null;
				switch (position)
				{
					case 0:intent = new Intent(ZixunLayout.this, Z1.class);break;
					case 1:intent = new Intent(ZixunLayout.this, Z2.class);break;
					case 2:intent = new Intent(ZixunLayout.this, Z3.class);break;
					case 3:intent = new Intent(ZixunLayout.this, Z4.class);break;
					case 4:intent = new Intent(ZixunLayout.this, Z5.class);break;
					case 5:intent = new Intent(ZixunLayout.this, Z6.class);break;
					case 6:intent = new Intent(ZixunLayout.this, Z7.class);break;
				
				}
					startActivity(intent);
		      }  
		});
	}

	private void initView() {
		mlvGeneral=(ListView) findViewById(R.id.lvGeneral);
		mAdapter=new GeneralAdapter();//创建适配器
		mlvGeneral.setAdapter(mAdapter);//关联适配器
	}

	private void initData() {
		//将资源中的字符串组数转换为Java数组
		String[] names=getResources().getStringArray(R.array.generals);
		mGenerals=new ArrayList<GeneralBean>();
		for (int i = 0; i < names.length; i++) {
			GeneralBean bean=new GeneralBean(resid[i], names[i]);
			mGenerals.add(bean);
		}
	}


	class GeneralAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return mGenerals.size();
		}

		@Override
		public GeneralBean getItem(int position) {
			return mGenerals.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		
			View layout=View.inflate(ZixunLayout.this, R.layout.item_generals, null);
	
			ImageView ivThumb=(ImageView) layout.findViewById(R.id.ivThumb);
		
			TextView tvName=(TextView) layout.findViewById(R.id.tvName);
		
			GeneralBean bean=mGenerals.get(position);
		
			ivThumb.setImageResource(bean.getResid());
		
			tvName.setText(bean.getName());
			
			return layout;
		}
		
	}
}

