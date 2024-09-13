package backendapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static constantsurl.Constants.MAIN_URL;

public class SpecificationSetUp {
    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(MAIN_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
