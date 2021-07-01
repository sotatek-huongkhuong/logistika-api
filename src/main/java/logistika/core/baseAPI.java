package logistika.core;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class baseAPI {
    private static ThreadLocal<Response> response = new ThreadLocal();
    private static ThreadLocal<FilterableRequestSpecification> reqSpec = new ThreadLocal();

    public Response sendGet(String url) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).when().get(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }
    public static void initReqSpec() {
        RestAssuredConfig configRest = RestAssuredConfig.newConfig().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("access-token", new String[]{"Accept", "Content-Type"})).httpClient(HttpClientConfig.httpClientConfig()).httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 60000).setParam("http.socket.timeout", 60000));
        reqSpec.set((FilterableRequestSpecification)RestAssured.given().config(configRest).log().uri());
    }
    public Response sendGet(String url, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).pathParam(pathParamName, pathParamValue).contentType(ContentType.JSON).when().get(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendGet(String url, Map<String, Object> params) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).params(params).contentType(ContentType.JSON).when().get(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendGet(String url, String pathParam, String pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).pathParam(pathParam, pathParamValue).contentType(ContentType.JSON).when().get(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).when().post(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url, Object body) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().contentType(ContentType.JSON).body(body).when().post(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url, String body) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).body(body).when().post(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url, String body, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParam(pathParamName, pathParamValue).body(body).when().post(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url, Object body, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParam(pathParamName, pathParamValue).body(body).when().post(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPost(String url, Object body, Map<String, String> pathParameters) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParams(pathParameters).body(body).when().post(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPostWithParams(String url, Object body, Map<String, Object> params) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).queryParams(params).contentType(ContentType.JSON).body(body).when().post(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public baseAPI validateResponse(int statusCode) {
        ((ValidatableResponse) ((ValidatableResponse) ((ValidatableResponse) ((ValidatableResponse) ((ValidatableResponse) ((Response) response.get()).then()).log().ifValidationFails()).statusCode(statusCode)).and()).body("", Matchers.allOf(Matchers.notNullValue(), Matchers.not("")), new Object[0])).extract().response();
        return this;
    }

    public JsonPath getJsonPath(Response r) {
        String json = r.asString();
        return new JsonPath(json);
    }

    public String getJsonValue(String jsonLocator) {
        try {
            String jsonValue = this.getJsonPath((Response) response.get()).get(jsonLocator).toString();
            return jsonValue;
        } catch (Exception E) {
            E.getMessage();
            return (String.format("Response does not contain field %s", jsonLocator));
            // throw new (String.format("Response does not contain field %s", jsonLocator));
        }
    }

    public String getJsonValue(String jsonLocator, Response reponse) {
        try {
            String jsonValue = this.getJsonPath(reponse).get(jsonLocator).toString();
            return jsonValue;
        } catch (Exception E) {
            E.getMessage();
            return (String.format("Response does not contain field %s", jsonLocator));
            // throw new (String.format("Response does not contain field %s", jsonLocator));
        }
    }


    public baseAPI validateStatusCode(int statusCode) {
        ((ValidatableResponse) ((ValidatableResponse) ((Response) response.get()).then()).log().ifValidationFails()).statusCode(statusCode);
        return this;
    }

    public baseAPI validateStatusCode(int statusCode, Response respons) {
        ((ValidatableResponse) ((ValidatableResponse) (respons).then()).log().ifValidationFails()).statusCode(statusCode);
        return this;
    }

    public Response sendPut(String url) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).when().put(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPut(String url, Object body) {
        Response res = (Response) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).body(body).when().put(url, new Object[0])).then()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPut(String url, Map<String, Object> body, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParam(pathParamName, pathParamValue).body(body).when().put(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPut(String url, Object body, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParam(pathParamName, pathParamValue).body(body).when().put(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPut(String url, Object body, Map<String, String> pathParameters) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).contentType(ContentType.JSON).pathParams(pathParameters).body(body).when().put(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendPut(String url, Object body, String pathParamName, Object pathParamValue, Map<String, Object> params) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).params(params).contentType(ContentType.JSON).pathParam(pathParamName, pathParamValue).body(body).when().put(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendDelete(String url) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).when().delete(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendDelete(String url, String pathParamName, Object pathParamValue) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).pathParam(pathParamName, pathParamValue).when().delete(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendDelete(String url, Map<String, String> pathParameters) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).pathParams(pathParameters).when().delete(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendDelete(String url, String pathParamName, Object pathParamValue, Map<String, Object> params) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).params(params).pathParam(pathParamName, pathParamValue).when().delete(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public Response sendDelete(String url, Map<String, String> pathParameters, Map<String, Object> params) {
        Response res = (Response) ((ValidatableResponse) ((ValidatableResponse) ((Response) RestAssured.given().spec((RequestSpecification) reqSpec.get()).params(params).pathParams(pathParameters).when().delete(url, new Object[0])).then()).log().ifValidationFails()).extract().response();
        response.set(res);
        return res;
    }

    public void setHeader(String headerName, Object headerValue) {
        ((FilterableRequestSpecification) reqSpec.get()).header(headerName, headerValue, new Object[0]);
    }
}
