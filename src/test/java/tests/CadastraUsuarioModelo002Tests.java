package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class CadastraUsuarioModelo002Tests {

    protected Map<String, String> headers = new HashMap<String, String>();
    protected Method method = null;

    @Test
    public void adicionarUsuario_Modelo002_01(){

        JSONObject user = new JSONObject();
        JSONObject access_level = new JSONObject();

        user.put("username","Joao API_Rest JsonSimples");
        user.put("password","123456");
        user.put("real_name","Joao da API_Rest JsonSimples");
        user.put("email","joao@api.com.bt");

        access_level.put("id",70);
        user.put("access_level",access_level);

        user.put("enabled",1);
        user.put("protected",0);

// given().
        headers.put("content-type", "application/json");
        headers.put("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT");

        RequestSpecification requestSpecification = RestAssured.given();
        for (Map.Entry<String, String> header : headers.entrySet()){
            requestSpecification.headers(header.getKey(), header.getValue());
        }

        requestSpecification.body(user);

//when().
        method = Method.POST;

//then().
        Response response = requestSpecification.request(method,"http://localhost:8989/api/rest/users");
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void adicionarUsuario_Modelo002_02(){

        JSONObject user = new JSONObject();
        JSONObject access_level = new JSONObject();

        user.put("username","Joao API_Rest JsonSimples");
        user.put("password","123456");
        user.put("real_name","Joao da API_Rest JsonSimples");
        user.put("email","joao@api.com.bt");

        access_level.put("id",70);
        user.put("access_level",access_level);

        user.put("enabled",1);
        user.put("protected",0);

        baseURI ="http://localhost:8989";
        basePath = "/api/rest/users";

// given().
        headers.put("content-type", "application/json");
        headers.put("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT");

        RequestSpecification requestSpecification = RestAssured.given();
        for (Map.Entry<String, String> header : headers.entrySet()){
            requestSpecification.headers(header.getKey(), header.getValue());
        }

        requestSpecification.body(user);

//when().
        method = Method.POST;

//then().
        Response response = requestSpecification.request(method,baseURI+basePath);
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void adicionarUsuario_Modelo002_03(){

        baseURI ="http://localhost:8989";
        basePath = "/api/rest/users";
        method = Method.POST;

        headers.put("content-type", "application/json");
        headers.put("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT");

        RequestSpecification requestSpecification = RestAssured.given();
        for (Map.Entry<String, String> header : headers.entrySet()){
            requestSpecification.headers(header.getKey(), header.getValue());
        }

        JSONObject user = new JSONObject();
        JSONObject access_level = new JSONObject();

        user.put("username","Joao API_Rest JsonSimples");
        user.put("password","123456");
        user.put("real_name","Joao da API_Rest JsonSimples");
        user.put("email","joao@api.com.bt");
        access_level.put("id",70);
        user.put("access_level",access_level);
        user.put("enabled",1);
        user.put("protected",0);

        requestSpecification.body(user);
        Response response = requestSpecification.request(method,baseURI+basePath);

        Assert.assertEquals(response.statusCode(),201);
    }

}