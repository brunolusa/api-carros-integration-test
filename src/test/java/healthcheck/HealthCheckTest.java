package healthcheck;

import basetest.BaseTest;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseTest {

    @Test
    public void validaSaudedaAplicacao(){ getActuatorClient.getHealthCheck(); }

}