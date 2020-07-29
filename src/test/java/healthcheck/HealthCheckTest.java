package healthcheck;

import basetest.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static utils.PropertyLoader.retornarValorArquivoConfiguracao;

public class HealthCheckTest extends BaseTest {

    @Test
    public void validaSaudedaAplicacao(){

        getActuatorClient.getHealthCheck();

    }
}
