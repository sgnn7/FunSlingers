package com.redwrench.android.framework.implementation;

import android.graphics.Bitmap;

import com.redwrench.android.framework.Graphics.PixmapFormat;
import com.redwrench.android.framework.Pixmap;

public class DroidPixmap implements Pixmap{
	Bitmap bitmap;
	PixmapFormat format;
	
	public DroidPixmap(Bitmap bitmap, PixmapFormat format){
		this.bitmap = bitmap;
		this.format = format;
	}
	
	@Override
	public int getWidth(){
		return bitmap.getWidth();
	}
	
	@Override
	public int getHeight(){
		return bitmap.getHeight();
	}
	
	@Override
	public PixmapFormat getFormat(){
		return format;
	}
	
	@Override
	public void dispose(){
		bitmap.recycle();
	}
	

}
