package twitterapitest;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.assertThat;

/**
 * Below are a few sample Twitter
 * API tests.
 */

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TwitterTests extends TwitterTestSetUp {


    @Test
    public void getRecentTweet() {
        twitter.createTweet();
        tweet = twitter.getTweet();

        assertThat(tweet,containsString("This tweet was created using rest assured"));
    }

    @Test
    public void createNewTweet () {
        twitter.createTweet();
    }


    @Test
    public void deleteExistingTweet() {
        twitter.deleteTweet();

  }










}
