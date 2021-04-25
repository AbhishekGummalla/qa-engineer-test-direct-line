package qa.utils;


import java.io.*;
import java.util.Properties;

public class ConfigurationReader {

    private Properties properties;
    private String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testData.properties";

    public ConfigurationReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file not found at " + path);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException(key + "key not defined in the properties file.");
        }
    }
}