package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class CadastraUsuarioModelo001Tests {


    @Test
    public void adicionarUsuario_Modelo001(){

        JSONObject user = new JSONObject();
        JSONObject access_level = new JSONObject();

        user.put("username","Joao da Silva");
        user.put("password","123456");
        user.put("real_name","Joao da Silvas");
        user.put("email","joaoSilva@.com.bt");

        access_level.put("id",70);
        user.put("access_level",access_level);

        user.put("enabled",1);
        user.put("protected",0);

        given().
                header("content-type", "application/json").
                header("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT").
                baseUri("http://localhost:8989").
                basePath("/api/rest/users").
                body(user).
        when().
                post().

        then().
                statusCode(201).
                body("user.name",equalTo("Joao da Silva"),
                        "user.real_name",equalTo("Joao da Silva"));

    }

}