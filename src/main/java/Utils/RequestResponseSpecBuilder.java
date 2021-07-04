package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestResponseSpecBuilder {
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
    }
}
