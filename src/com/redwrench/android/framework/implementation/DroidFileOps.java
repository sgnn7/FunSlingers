package com.redwrench.android.framework.implementation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.res.AssetManager;
import android.os.Environment;

import com.redwrench.android.framework.FileOps;

public class DroidFileOps implements FileOps  {
	AssetManager assets;
	String externalStoragePath;
	
	public DroidFileOps(AssetManager assets){
		this.assets = assets;
		this.externalStoragePath = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + File.separator;
	}
	
	@Override
	public InputStream readAsset(String fileName) throws IOException{
		return assets.open(fileName);
	}
	
	@Override
	public InputStream readFile(String fileName) throws IOException{
		return new FileInputStream(externalStoragePath + fileName);
	}
	
	@Override
	public OutputStream writeFile(String fileName) throws IOException {
		return new FileOutputStream(externalStoragePath + fileName);
	}
	

}
