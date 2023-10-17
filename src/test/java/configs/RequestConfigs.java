package configs;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class RequestConfigs {

    protected Map<String, String> headers = new HashMap<String, String>();
    protected Method method = null;
    protected String jsonBody = null;
    RequestSpecification requestSpecification =  RestAssured.given();

    public RequestConfigs(){

        headers.put("content-type", "application/json");
        headers.put("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT");

        for (Map.Entry<String, String> header : headers.entrySet()){
            requestSpecification.headers(header.getKey(), header.getValue());
        }
    }


    public Response executeRequest(){

        requestSpecification.body(jsonBody);
        Response response = requestSpecification.request(method,baseURI+basePath);
        ReportConfigs.addLogReport(jsonBody);

        return response;
    }

}