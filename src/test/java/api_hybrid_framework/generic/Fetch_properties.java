package api_hybrid_framework.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fetch_properties {
	
	public static String getProperties_value( ) throws IOException {
		
		FileInputStream fl = new FileInputStream("./src/test/java/api_hybrid_framework/utils/globalproperties.properties");
		Properties pro = new Properties();
		pro.load(fl);
		String a1 = pro.getProperty("baseuri");
		return a1;
		
	}

}
