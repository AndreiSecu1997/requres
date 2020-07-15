package in.requres.utilities;

import io.restassured.RestAssured;
import io.restassured.config.MatcherConfig;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.MatcherConfig.ErrorDescriptionType.HAMCREST;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public class RequestsManager {
    RequestSpecs requestSpecs = new RequestSpecs();
    private String baseUrl = requestSpecs.getBaseUrl();

    public Response getRequest(String endpoint) {
        return given()
                .config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))
                        .and().matcherConfig(new MatcherConfig(HAMCREST)))
                .relaxedHTTPSValidation()
                .log().all()
                .get(baseUrl + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response postRequest(String endpoint, Map<String, String> bodyParams) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(bodyParams)
                .log().all()
                .post(baseUrl + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response putRequest(String endpoint, Map<String, String> bodyParams) {
        return given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(bodyParams)
                .log().all()
                .put(baseUrl + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response deleteRequest(String endpoint) {
        return given()
                .config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))
                        .and().matcherConfig(new MatcherConfig(HAMCREST)))
                .relaxedHTTPSValidation()
                .log().all()
                .delete(baseUrl + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
