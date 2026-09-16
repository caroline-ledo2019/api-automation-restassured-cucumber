package steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.*;

public class Teste01 {
    private Response response;
    private Scenario scenario;

    // O before serve para capturar o relatório HTML do Cucumber
    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @Dado("que acesso a API ServeRest")
    public void queAcessoAApiServeRest() {
        RestAssured.baseURI = "https://serverest.dev";
    }

    @Quando("executar a requisição para consultar com endpoint {string}")
    public void executarARequisicaoParaConsultarComEndpoint(String endpoint) {
        // Criamos e inicializamos os gravadores locais na hora do envio para evitar erros de NullPointer
        ByteArrayOutputStream requestLogStream = new ByteArrayOutputStream();
        PrintStream requestPs = new PrintStream(requestLogStream);

        // Executa a chamada injetando o filtro que grava os dados da Request
        response = RestAssured.given()
                .filter(new io.restassured.filter.log.RequestLoggingFilter(io.restassured.filter.log.LogDetail.ALL, requestPs))
                .when()
                .get(endpoint);
        
        // Escreve os dados enviados (Headers, URI, Method) imediatamente no passo QUANDO do relatório HTML
        scenario.log("Request enviada" + requestLogStream.toString());
        scenario.log("Response da API" + response.getBody().asPrettyString());
    }

    @Então("devo retornar o status code {int}")
    public void devoRetornarOStatusCode(Integer statuscode) {
        response.then().statusCode(statuscode);
        scenario.log("Status Code validado com sucesso: " + response.getStatusCode());
    }

    @Então("devo retornar os usuários cadastrados")
    public void devoRetornarOsUsuariosCadastrados() {
        // Validações de segurança do corpo do JSON
        response.then().body("usuarios", notNullValue());
        response.then().body("usuarios.size()", greaterThan(0));

        // Lista os resultados informados pela API
        int tamanhoDaLista = response.jsonPath().getList("usuarios").size();

        // Injeta o corpo completo recebido e as validações numéricas no passo final do relatório HTML
        scenario.log("Validação concluída! A lista de usuários foi retornada com sucesso." +
                     "Total de usuários listados no JSON: " + tamanhoDaLista + "");
    }
}
