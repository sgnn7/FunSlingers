package com.redwrench.funslingers;

import com.redwrench.android.framework.Game;
import com.redwrench.android.framework.Graphics;
import com.redwrench.android.framework.Screen;
import com.redwrench.android.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game){
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics graphics = game.getGraphics();
		Assets.background = graphics.newPixmap("background.png", PixmapFormat.RGB565);
		Assets.mainMenu = graphics.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
		Assets.pauseMenu = graphics.newPixmap("pause.png", PixmapFormat.ARGB4444);
		Assets.readyButton = graphics.newPixmap("ready.png", PixmapFormat.ARGB4444);
		game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
}
