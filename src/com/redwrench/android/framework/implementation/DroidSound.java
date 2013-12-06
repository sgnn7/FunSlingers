package com.redwrench.android.framework.implementation;

import android.media.SoundPool;

import com.redwrench.android.framework.Sound;

public class DroidSound implements Sound {
	int soundId;
	SoundPool soundPool;
	
	public DroidSound(int soundId, SoundPool soundPool){
		this.soundId = soundId;
		this.soundPool = soundPool;
	}
	
	@Override
	public void play(float volume){
		soundPool.play(soundId, volume, volume, 0, 0, 1);
	}
	
	@Override
	public void dispose(){
		soundPool.unload(soundId);
	}

}
