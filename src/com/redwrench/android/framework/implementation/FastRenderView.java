package com.redwrench.android.framework.implementation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.renderscript.RenderScript;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class FastRenderView extends SurfaceView implements Runnable{
	DroidGame game;
	Bitmap frameBuffer;
	Thread renderThread = null;
	SurfaceHolder surfaceHolder;
	volatile boolean running = false;
	
	public FastRenderView(DroidGame game, Bitmap frameBuffer){
		super(game);
		this.game = game;
		this.frameBuffer = frameBuffer;
		this.surfaceHolder = getHolder();
	}
	
	public void resume(){
		running = true;
		renderThread = new Thread(this);
		renderThread.start();
	}
	
	public void run(){
		Rect dstRect = new Rect();
		long startTime = System.nanoTime();
		
		while(running){
			if(!surfaceHolder.getSurface().isValid())
				continue;
			
			//time difference counted in nanoseconds
			float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
			startTime = System.nanoTime();
			
			game.getCurrentScreen().update(deltaTime);
			game.getCurrentScreen().present(deltaTime);
			
			Canvas canvas = surfaceHolder.lockCanvas();
			canvas.getClipBounds(dstRect);
			canvas.drawBitmap(frameBuffer, null, dstRect, null);
			surfaceHolder.unlockCanvasAndPost(canvas);
			
			
		}
	}
	
	public void pause(){
		running = false;
		while(true){
			try{
				renderThread.join();
				break;
			}
			catch(InterruptedException e){
				//the thread will attempt to join again
			}
		}
	}
	

}
