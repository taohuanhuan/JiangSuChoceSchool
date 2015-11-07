package cn.exmp1.yindaoye;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import cn.exmp1.jisuzexiaotong.MainActivity;
import cn.exmp1.jisuzexiaotong.R;


public class WelcomeAct extends Activity {
	
	private boolean isFirstIn = false;
	private static final int TIME = 1500;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;
	
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;

			case GO_GUIDE:
				 goGuide();
				break;
			}
			
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);  //ÎÞtitle  
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
		//              WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yindaowelcome);
		init();
	}
	
	private void init(){
		SharedPreferences perPreferences = getSharedPreferences("jike", MODE_PRIVATE);
		isFirstIn = perPreferences.getBoolean("isFirstIn", true);
		if (!isFirstIn) {
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			Editor editor = perPreferences.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}
	
	private void goHome(){
		Intent i = new Intent(WelcomeAct.this,MainActivity.class);
		startActivity(i);
		finish();
	}
	private void goGuide(){
		Intent i = new Intent(WelcomeAct.this,Guide.class);
		startActivity(i);
		finish();
	}
	
}
