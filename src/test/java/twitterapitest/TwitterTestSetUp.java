package twitterapitest;

import baselineurl.TwitterBaseUri;
import io.restassured.RestAssured;
import org.junit.Before;
import restassurredresuablemethods.ReusableApiMethods;

/**
 *This classed is created
 * as the setup class for
 * all tests used for the
 * twitter tests
 */
public class TwitterTestSetUp {

    protected ReusableApiMethods twitter = new ReusableApiMethods();
    protected String tweet;

    @Before
    public  void setUpTwitterBaseUri () {
    RestAssured.baseURI = TwitterBaseUri.getTwitterBaseUrL();
    }
}
