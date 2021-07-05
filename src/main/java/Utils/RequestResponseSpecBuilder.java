package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public class RequestResponseSpecBuilder {
    public static RequestSpecification getRequestSpec() throws IOException {
        return new RequestSpecBuilder()
                .setBaseUri(Properties.getInstance().getProperty("base_url"))
                .setContentType(ContentType.JSON)
                .addFilter(RequestLoggingFilter.logRequestTo(FileHandler.getInstance().getLogFile()))
                .addFilter(ResponseLoggingFilter.logResponseTo(FileHandler.getInstance().getLogFile()))
                .build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .setDefaultParser(Parser.JSON)
                .build();
    }
}
