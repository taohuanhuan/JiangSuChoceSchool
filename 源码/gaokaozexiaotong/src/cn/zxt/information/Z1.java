package cn.zxt.information;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import cn.exmp1.jisuzexiaotong.R;

public class Z1 extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.z1);
		TextView tv = (TextView) findViewById(R.id.content);
		// �����ֿ��Թ�����ʾ
		tv.setMovementMethod(ScrollingMovementMethod.getInstance());
		// ����Ϊfalse������һֱ��ʾ
		tv.setScrollbarFadingEnabled(false);

	}

}
