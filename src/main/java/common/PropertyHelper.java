package common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {

    private static final String PROPERTY_FILE_PATH = "./src/main/resources/properties/environment.properties";
    private Properties properties;

    public PropertyHelper() {
        properties = new Properties();
        try {
            File propertiesFile = new File(PROPERTY_FILE_PATH);
            FileReader fileReader = new FileReader(propertiesFile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load file", e);
        }
    }

    public String readProperty(String key){
        return properties.getProperty(key);
    }
}