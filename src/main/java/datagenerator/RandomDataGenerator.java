package datagenerator;

import java.util.Random;

/**
 * This is a random data generator class
 * used to provide random data to other
 * class that require the data to be unique
 * during execution of the tests
 */

public class RandomDataGenerator {

    public static String getNumericRandomData(int amount) {

        String data = "123456789";
        Random ran = new Random();
        StringBuilder sb = new StringBuilder(amount);

        for (int i = 0; i < amount; i++) {
            sb.append(data.charAt(ran.nextInt(data.length())));
        }
        return sb.toString();
    }

}
