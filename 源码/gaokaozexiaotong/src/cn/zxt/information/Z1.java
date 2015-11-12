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
		// 让文字可以滚动显示
		tv.setMovementMethod(ScrollingMovementMethod.getInstance());
		// 设置为false滚动条一直显示
		tv.setScrollbarFadingEnabled(false);

	}

}
