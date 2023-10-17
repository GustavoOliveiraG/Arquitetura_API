package tests;

import configs.JsonConfigs;
import configs.TestsConfigs;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.PostUsersRequest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;


public class CadastraUsuarioModelo003Tests extends TestsConfigs {
    
    protected String jsonBody = null;
    protected Method method = null;


    @Test
    public void adicionarUsuario_Modelo003_01(){

        baseURI ="http://localhost:8989";
        basePath = "/api/rest/users";
        method = Method.POST;

        RequestSpecification requestParameters = RestAssured.given();
        requestParameters
                .headers("content-type", "application/json")
                .header("Authorization", "GeFK6eK8LFHVW0O4GEFLWp2R5QE4h1vT");

        jsonBody = JsonConfigs.readFileToAString("src/test/java/jsons/user.json");
        jsonBody = jsonBody.
                replace("$nome","Gariela")
                .replace("$senha", "123456")
                .replace("$real", "Gariela")
                .replace("$email", "Gariela@gmail.com")
                .replace("$id", "55");

        requestParameters.body(jsonBody);
        Response response = requestParameters.request(method,baseURI+basePath);

        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void adicionarUsuario_Modelo003_02(){

        String nome ="Gugu";
        String password ="321";
        String nomeCompleto ="Gugu";
        String email = "gugu@gmaail.com";

        PostUsersRequest postUsersRequest = new PostUsersRequest();
        postUsersRequest.setValueJson(nome, password, nomeCompleto, email);
        Response response = postUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(),201,"Erro API");
    }

    @Test
    public void adicionarUsuario_Email_Invalido(){

    // Parametros do Body
        String nome ="Marcelo";
        String password ="321";
        String nomeCompleto ="Marcelo";
        String email = "Marcelo";

    // Configuracao e envio da requisicao
        PostUsersRequest postUsersRequest = new PostUsersRequest();
        postUsersRequest.setValueJson(nome, password, nomeCompleto, email);
        Response response = postUsersRequest.executeRequest();

    // Validacoes
        Assert.assertEquals(response.statusCode(),400,"Erro API");
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), "Email 'Marcelo' is invalid.", "Validação campo: user.name");

    }

}
