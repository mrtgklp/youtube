package YouTube_Url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class YouTube_Url {
    public  static RequestSpecification spec;

    public static void setUp(){
        spec = new RequestSpecBuilder()
                //.addHeader("Authorization",generateToken())
                .setBaseUri(ConfigReader.getProperty("youTube_url"))
                .setContentType(ContentType.JSON)
                .build();
    }
}
