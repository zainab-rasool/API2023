package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class HandleJSONFile {
	public static String readJSON(String filepath) throws FileNotFoundException {
		File f=new File(filepath);
		FileInputStream fi=new FileInputStream(f);
		JSONTokener jt=new JSONTokener(fi);
		JSONObject j=new JSONObject(jt);
		return j.toString();
		
	}

}
