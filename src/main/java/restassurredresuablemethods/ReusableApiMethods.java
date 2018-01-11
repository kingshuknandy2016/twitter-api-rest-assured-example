package restassurredresuablemethods;

import baselineurl.TwitterBaseUri;
import dataextractor.ExtractJsonData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static datagenerator.RandomDataGenerator.getNumericRandomData;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static loadendpoints.EndPointLoader.loadTheEndPointProperty;
import static oauthmanager.OAuthLoader.loadTheOAuthKeyProperty;


/**
 * This class was created to use the practice
 * of D.R.Y (Don't repeat yourself) with common
 * code that will be used multiple times in
 * the test
 */
public class ReusableApiMethods {

  //The getTweet method returns the latest tweet based on tweet creation

    public String getTweet() {
        return getOauth()
                .when().get(loadTheEndPointProperty("RECENT_TWEETS"))
                .then()
                .contentType(JSON)
                .extract()
                .path("text[0]").toString();
    }

// The createTweet method creates a tweet and checks that the status 200

    public String createTweet() {


        Response res = getOauth()

                .queryParam("status","This tweet was created using rest assured " + getNumericRandomData(2))
                .when()
                .post(loadTheEndPointProperty("CREATE_TWEET"))
                .then()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        ExtractJsonData js = new ExtractJsonData();
        String tweetid = js.jsonToString(res, "id_str");

        return tweetid;

    }

// The deleteTweet method passes the id of the created tweet to the delete end point and checks status is 200
    public void deleteTweet() {
        String tweet = createTweet();
        System.out.println(tweet);

        RestAssured.baseURI = TwitterBaseUri.getTwitterBaseUrL();

                getOauth()
                .when()
                .post(loadTheEndPointProperty("DELETE_TWEET")+tweet+".json")
                .then()
                .assertThat()
                .statusCode(200);
    }

// The getOauth method gets the oAuth parameters need for Twitter

    public RequestSpecification getOauth() {
        return given().auth().oauth(loadTheOAuthKeyProperty("CONSUMER_KEY"), loadTheOAuthKeyProperty("CONSUMER_SECRET"),
                loadTheOAuthKeyProperty("ACCESS_TOKEN"), loadTheOAuthKeyProperty("ACCESS_TOKEN_SECRET"));
    }

}
