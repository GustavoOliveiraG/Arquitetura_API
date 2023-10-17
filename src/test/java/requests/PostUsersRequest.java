package requests;

import configs.JsonConfigs;
import configs.RequestConfigs;
import io.restassured.http.Method;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class PostUsersRequest extends RequestConfigs {

    public PostUsersRequest(){
        baseURI ="http://localhost:8989";
        basePath = "/api/rest/users";
        method = Method.POST;
    }

    public void setValueJson(String nome, String password, String nomeCompleto, String email){
        jsonBody = JsonConfigs.readFileToAString("src/test/java/jsons/user.json");
        jsonBody = jsonBody.
                replace("$nome",nome)
                .replace("$senha", password)
                .replace("$real", nomeCompleto)
                .replace("$email", email)
                .replace("$id", "55");
    }

}