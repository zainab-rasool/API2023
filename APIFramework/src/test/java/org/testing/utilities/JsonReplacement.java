package org.testing.utilities;

import java.util.regex.Pattern;

//inputs--body data(that is containing varaible also), variablename,varaiblevalue
//purpose--it will replace the variableName with Variablevalue in the bodydata string
//output---after replacement this method will return the latest string that is containing variable value

public class JsonReplacement {
	
	public static String JSONDataVariableValue(String completeBody, String variableName, String VariableValue) {
		completeBody=completeBody.replaceAll(Pattern.quote("{{"+variableName+"}}"), VariableValue);
		return completeBody;
		
	}

}
