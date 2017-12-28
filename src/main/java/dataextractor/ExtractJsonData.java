package dataextractor;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * This class is designed
 * to return data from the
 * response this could be
 * either Json or XML format
 * dependent of the test
 */
public class ExtractJsonData {


    public  String jsonToString(Response res, String data) {
        String response = res.asString();
        JsonPath js =new JsonPath(response);
        return  js.get(data).toString();
    }


    public  String xmlToString(Response res, String data) {
        return new XmlPath(res.asString()).get(data).toString();

    }

}
