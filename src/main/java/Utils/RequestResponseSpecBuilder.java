package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public class RequestResponseSpecBuilder {
    public static RequestSpecification getRequestSpec() throws IOException {
        return new RequestSpecBuilder()
                .setBaseUri(Properties.properties().getProperty("base_url"))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(201)
                .setDefaultParser(Parser.JSON)
                .build();
    }
}
