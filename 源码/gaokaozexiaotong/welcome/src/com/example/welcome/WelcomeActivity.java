package com.example.welcome;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class WelcomeActivity extends Activity {

	// 首次使用程序的显示的欢迎图片

	private int[] ids = { R.drawable.first, R.drawable.second, R.drawable.fifth, R.drawable.forth };

	private List<View> guides = new ArrayList<View>();
	private ViewPager pager;
	private ImageView curDot;
	// 位移量
	private int offest;
	// 记录当前位置
	private int curPos = 0;

	Editor editor;

	SharedPreferences share;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		share = getSharedPreferences("showwelcome", Context.MODE_PRIVATE);
		editor = share.edit();
		// 判断是否首次登录程序
		if (share.contains("shownum")) {
			setContentView(R.layout.activity_welcome);
			int num = share.getInt("shownum", 0);
			editor.putInt("shownum", num++);
			editor.commit();
			skipActivity(1);
		} else {
			editor.putInt("shownumm", 1);
			editor.commit();
			setContentView(R.layout.activity_welcome);
			initView();
		}

	}

	private void initView() {
		for (int i = 0; i < ids.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setImageResource(ids[i]);
			ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT);
			iv.setLayoutParams(params);
			iv.setScaleType(ScaleType.FIT_XY);
			guides.add(iv);

		}
		curDot = (ImageView) findViewById(R.id.cur_dot);
		curDot.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {

			public boolean onPreDraw() {
				offest = curDot.getWidth();
				return true;
			}
		});

		WecomePagerAdapter adapter = new WecomePagerAdapter();
		pager = (ViewPager) findViewById(R.id.showwelcome_page);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			public void onPageSelected(int arg0) {
				moveCursorTo(arg0);
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * 移动指针到相邻位置
	 */
	protected void moveCursorTo(int position) {
		TranslateAnimation anim = new TranslateAnimation(offest * curPos, offest * position, 0, 0);
		anim.setDuration(300);
		anim.setFillAfter(true);
		curDot.startAnimation(anim);
	}

	/**
	 * 延迟多少秒进入主界面
	 */
	private void skipActivity(int min) {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

			}
		}, 1000 * min);
	}
}
