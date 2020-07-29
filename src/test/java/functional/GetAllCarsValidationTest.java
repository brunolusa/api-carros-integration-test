package functional;

import basetest.BaseTest;
import org.testng.annotations.Test;

public class GetAllCarsValidationTest extends BaseTest {

    @Test
    public void buscaTodosOsCarrosTest(){ getCarrosClient.getAllCarros(); }

}
