package oauthmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is designed to
 * return all the parameters
 * for the OAuth needed to run
 * our twitter tests
 **/


public class OAuthLoader {

    private static Properties prop;
    private static FileInputStream fis;


    public  static String loadTheOAuthKeyProperty(String resource) {

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
                String.format("%ssrc%smain%sresources%sOAuth.properties", s, s, s,s);

    }


}
