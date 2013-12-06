package com.redwrench.android.framework.implementation;

import java.io.IOException;
import java.io.InputStream;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import com.redwrench.android.framework.Graphics;
import com.redwrench.android.framework.Pixmap;

public class DroidGraphics implements Graphics {
	AssetManager assets;
	Bitmap frameBuffer;
	Canvas canvas;
	Paint paint;
	Rect sourceRectangle = new Rect();
	Rect destinationRectangle = new Rect();
	
	public DroidGraphics(AssetManager assets, Bitmap frameBuffer){
		this.assets = assets;
		this.frameBuffer = frameBuffer;
		this.canvas = new Canvas(frameBuffer);
		this.paint = new Paint();
	}
	
	//Interface implementation
	
	@Override
	public Pixmap newPixmap(String fileName, PixmapFormat format){
		Config config = null;
		
		if(format == PixmapFormat.RGB565)
			config = Config.RGB_565;
		else if(format == PixmapFormat.ARGB4444)
			config = Config.ARGB_4444;
		else
			config = Config.ARGB_8888;
		
		Options options  = new Options();
		options.inPreferredConfig = config;
		
		InputStream inputStream = null;
		Bitmap bitmap = null;
		try{
			inputStream = assets.open(fileName);
			bitmap = BitmapFactory.decodeStream(inputStream);
			
			if(bitmap == null)
				throw new RuntimeException(fileName + " could not be loaded.");
		}
		catch(IOException e){
			throw new RuntimeException(fileName + " could not be loaded");
		}
		finally{
			if(inputStream != null){
				try{
					inputStream.close();
				}
				catch(IOException e){
					//Exception is eaten at this point. consider logging
				}
			}
		}
		
		if(bitmap.getConfig() == Config.ARGB_4444)
			format = PixmapFormat.ARGB4444;
		else if(bitmap.getConfig() == Config.ARGB_8888)
			format = PixmapFormat.ARGB8888;
		else
			format = PixmapFormat.RGB565;
		
		return new DroidPixmap(bitmap, format);
		
	}
	
	
	@Override
	public void clear(int color){
		canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
			(color & 0xff));
	}
	
	@Override
	public void drawPixel(int x, int y, int color){
		paint.setColor(color);
		canvas.drawPoint(x, y, paint);
	}
	
	@Override
	public void drawLine(int startX, int startY, int stopX, int stopY, int color){
		paint.setColor(color);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}
	
	@Override
	public void drawRectangle(int x, int y, int width, int height, int color){
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
	}
	
	@Override
	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth,
			int srcHeight){
		sourceRectangle.left = srcX;
		sourceRectangle.right = srcX + srcWidth - 1;
		sourceRectangle.top = srcY;
		sourceRectangle.bottom = srcY + srcHeight - 1;
		
		destinationRectangle.left = x;
		destinationRectangle.right = y + srcWidth - 1;
		destinationRectangle.top = y;
		destinationRectangle.bottom = y + srcHeight - 1;
		
		canvas.drawBitmap(((DroidPixmap) pixmap).bitmap, sourceRectangle, destinationRectangle, 
				null);
		
	}
	
	@Override 
	public void drawPixmap(Pixmap pixmap, int x, int y){
		canvas.drawBitmap(((DroidPixmap) pixmap).bitmap, x, y, null);
		
	}
	
	@Override
	public int getWidth(){
		return frameBuffer.getWidth();
	}
	
	@Override
	public int getHeight(){
		return frameBuffer.getHeight();
	}
}
