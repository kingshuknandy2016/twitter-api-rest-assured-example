package loadendpoints;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is designed
 * to load the properties
 * required for the test
 * based on the property value
 * that is passed to the loadendpoint
 * method.
 */
public class EndPointLoader {


    private static Properties prop;
    private static FileInputStream fis;


    public  static String loadTheEndPointProperty(String resource) {

        prop = new Properties();

        try {
            fis = new FileInputStream(getTheResourcesFilePath());
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  prop.getProperty(resource);
    }

    private static String getTheResourcesFilePath() {
        String s = File.separator;
        return System.getProperty("user.dir") +
                String.format("%ssrc%smain%sresources%sTwitterEndPoints.properties", s, s, s,s);

    }
}
