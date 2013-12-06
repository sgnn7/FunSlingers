package com.redwrench.funslingers;

import java.util.List;
import com.redwrench.android.framework.Game;
import com.redwrench.android.framework.Input.TouchEvent;
import com.redwrench.android.framework.Screen;

public class GameScreen extends Screen{
	enum GameState{
		Ready, 
		Running, 
		Paused, 
		GameOver;
				
	}
	
	GameLib gameLib;
	GameState gameState = GameState.Paused;
	
	public GameScreen(Game game){
		super(game);
		gameLib = new GameLib();
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
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
	
	public void updatePaused(List<TouchEvent> events){
		int eventCount = events.size();
		for(int i = 0; i < eventCount; i++){
			TouchEvent event = events.get(i);
			if(event.type == TouchEvent.TOUCH_UP){
				//determine if resume button was pressed
				
				//determine if quit button was pressed
			}
			
		}
		
	}

}
