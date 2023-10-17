package tests;

import configs.TestsConfigs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.PostUsersRequest;


public class CadastraUsuarioModelo004Tests extends TestsConfigs {

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