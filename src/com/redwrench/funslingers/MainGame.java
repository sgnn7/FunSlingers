package com.redwrench.funslingers;

import com.redwrench.android.framework.FileOps;
import com.redwrench.android.framework.Screen;
import com.redwrench.android.framework.implementation.DroidGame;





public class MainGame extends DroidGame{
	
	//TODO Implement Loading Screen Class
	
	@Override
	public Screen getStartScreen(){
		return new LoadingScreen(this);
	}

	@Override
	public FileOps getFileIO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
