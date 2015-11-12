package com.example.welcome;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class WecomePagerAdapter extends PagerAdapter {

	private List<View> views;

	public WecomePagerAdapter() {
		this.views = views;
	}

	public void destroyItem(View arg0, int position, Object object) {
		((ViewPager) arg0).removeView(views.get(position));

	}

	public void finishUpdate(View arg0) {

	}

	public int getCount() {
		return views.size();
	}

	public Object instantiateItem(View arg0, int arg1) {
		((ViewPager) arg0).addView(views.get(arg1), 0);
		return views.get(arg1);

	}

	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}

	public void restoreState(Parcelable arg0, ClassLoader arg1) {

	}

	public Parcelable saveState() {
		return null;

	}

	public void startUpdate(View arg0) {

	}

}
