package com.redwrench.android.framework.implementation;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.redwrench.android.framework.Input;

public class DroidInput implements Input{
	DroidSingleTouch touchHandler;
	
	public DroidInput(Context context, View view, float scaleX, float scaleY){
		touchHandler = new DroidSingleTouch(view, scaleX, scaleY);
	}
	
	

	@Override
	public boolean isTouchDown(int pointer) {
		return touchHandler.isTouchDown(pointer);
	}

	@Override
	public int getTouchX(int pointer) {
		return touchHandler.getTouchX(pointer);
	}

	@Override
	public int getTouchY(int pointer) {
		return touchHandler.getTouchY(pointer);
	}

	@Override
	public List<TouchEvent> getTouchEvents() {
		return touchHandler.getTouchEvents();
	}

}
