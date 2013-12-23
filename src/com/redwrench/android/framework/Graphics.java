package com.redwrench.android.framework;

public interface Graphics {
	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}

	public Pixmap newPixmap(String fileName, PixmapFormat format);

	public void clear(int color);

	public void drawPixel(int x, int y, int color);

	public void drawLine(int x, int y, int x2, int y2, int color);

	public void drawRectangle(int x, int y, int width, int height, int color);

	public void drawPixmap(Pixmap pixmap, int x, int y, int sourceX,
			int sourceY, int srcWidth, int srcHeight);

	public void drawPixmap(Pixmap pixmap, int x, int y);

	public int getWidth();

	public int getHeight();

}
