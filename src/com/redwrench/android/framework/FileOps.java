package com.redwrench.android.framework;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public interface FileOps{
	
	public InputStream readAsset(String fileName) throws IOException;
	
	public InputStream readFile(String fileName) throws IOException;
	
	public OutputStream writeFile(String fileName) throws IOException;

}
