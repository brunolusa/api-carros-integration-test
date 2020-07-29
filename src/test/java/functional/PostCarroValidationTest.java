package functional;

import basetest.BaseTest;
import com.lusa.carros.model.Carro;
import datadriven.CarroDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PostCarroValidationTest extends BaseTest {

    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void criaNovoCarro(Carro carro){

        Carro carroCriado = postCarrosClient.criaNovoCarro(carro).extract().body().as(Carro.class);

        assertNotNull(carroCriado.getId());
        assertEquals(carroCriado.getMarca(), carro.getMarca());
        assertEquals(carroCriado.getModelo(), carro.getModelo());

    }
}
