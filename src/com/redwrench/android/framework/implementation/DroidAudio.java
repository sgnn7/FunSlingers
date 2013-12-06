package com.redwrench.android.framework.implementation;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.redwrench.android.framework.Audio;
import com.redwrench.android.framework.Music;
import com.redwrench.android.framework.Sound;

public class DroidAudio implements Audio {
	AssetManager assets;
	SoundPool soundPool;
	
	public DroidAudio(Activity activity){
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		this.assets = activity.getAssets();
		this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
	}
	
	public Music newMusic(String fileName){
		/*try{
			AssetFileDescriptor assetFileDescriptor = assets.openFd(fileName);
			return null;
		}*/
		return null;
	}

	@Override
	public Sound newSound(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
