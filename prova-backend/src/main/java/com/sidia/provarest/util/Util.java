package com.sidia.provarest.util;

import java.io.File;

public class Util {
	
	/**
	 * ready file the directory
	 * @return File[]
	 */
	public static File[] loadFiles(String path) {
		//String path = System.getProperty("user.dir") +"\\data\\";		
		File diretorio = new File(path);
		File[] arquivos = diretorio.listFiles();
		return arquivos;
	}

}