package healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static utils.PropertyLoader.retornarValorArquivoConfiguracao;

public class HealthCheckTest {

    @Test
    public void validaSaudedaAplicacao(){

        baseURI = retornarValorArquivoConfiguracao("baseUri");
        port = Integer.parseInt(retornarValorArquivoConfiguracao("port"));

        when().
            get("/actuator/health").
        then().
            statusCode(HttpStatus.SC_OK).
            body("status", is("UP"));
    }
}
