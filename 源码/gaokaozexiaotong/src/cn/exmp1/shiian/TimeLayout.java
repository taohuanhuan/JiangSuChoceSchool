package cn.exmp1.shiian;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import cn.exmp1.jisuzexiaotong.R;


public class TimeLayout extends Activity {

		private ExpandableListView expandlistView;
		private StatusExpandAdapter statusAdapter;
		private Context context;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.time_layout);
			context = this;
			expandlistView = (ExpandableListView) findViewById(R.id.expandlist);
			initExpandListView();
		}

		private void initExpandListView() {
			statusAdapter = new StatusExpandAdapter(context, getListData());
			expandlistView.setAdapter(statusAdapter);
			expandlistView.setGroupIndicator(null); 
			expandlistView.setSelection(0);
			int groupCount = expandlistView.getCount();
			for (int i = 0; i < groupCount; i++) {
				expandlistView.expandGroup(i);
			}

			expandlistView.setOnGroupClickListener(new OnGroupClickListener() {

				@Override
				public boolean onGroupClick(ExpandableListView parent, View v,
						int groupPosition, long id) {
					// TODO Auto-generated method stub
					return true;
				}
			});
		}

		private List<GroupStatusEntity> getListData() {
			List<GroupStatusEntity> groupList;
			String[] strArray = new String[] { "7.26--7.30", "6.27--7 .2", "6.76.9" };
			String[][] childTimeArray = new String[][] {
					{ "�Ŀ������������������ԺУ", "��ְ(ר��)ԺУ�Լ���������������ְ(ר��)ԺУ",""},
					{ "�Ŀ����������һ����������ԺУ־Ը","��������ǰ¼ȡ���챾�Ƶ�1С��־Ը���ʱ��Ϊ6.27��29��"}, { "�μӸ߿�" } };
			groupList = new ArrayList<GroupStatusEntity>();
			for (int i = 0; i < strArray.length; i++) {
				GroupStatusEntity groupStatusEntity = new GroupStatusEntity();
				groupStatusEntity.setGroupName(strArray[i]);

				List<ChildStatusEntity> childList = new ArrayList<ChildStatusEntity>();

				for (int j = 0; j < childTimeArray[i].length; j++) {
					ChildStatusEntity childStatusEntity = new ChildStatusEntity();
					childStatusEntity.setCompleteTime(childTimeArray[i][j]);
					childStatusEntity.setIsfinished(true);
					childList.add(childStatusEntity);
				}

				groupStatusEntity.setChildList(childList);
				groupList.add(groupStatusEntity);
			}
			return groupList;
		}
	}


