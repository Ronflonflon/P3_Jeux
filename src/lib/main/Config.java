package lib.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public int dev;
	public int limit_of_try;
	public int limit_color;
	public int nb_case;
	
	public Config() {
		dev = 0;
		
		Properties prop = new Properties();
		InputStream input = null;
		String filename = "C:/Users/fabien/eclipse-workspace/p3_jeux/src/resources/config.properties";
		try {
			input = new FileInputStream(filename);
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Un problème a été rencontré lors de la lecture du fichier de configurations !");
		}
		this.limit_color = Integer.parseInt(prop.getProperty("limit_color"));
		this.limit_of_try = Integer.parseInt(prop.getProperty("limit_of_try"));
		this.nb_case = Integer.parseInt(prop.getProperty("nb_case"));
	}
}
