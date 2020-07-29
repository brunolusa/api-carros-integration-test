package functional;

import basetest.BaseTest;
import com.lusa.carros.model.Carro;
import datafactory.CarroFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCarByIdValidationTest extends BaseTest {

    @Test
    public void buscaCarroPeloId(){

        Carro focus = CarroFactory.novoCarroFordFiesta();

        Carro c = getCarrosClient.getCarroById(2L).extract().body().as(Carro.class);

        Assert.assertEquals(c.getMarca(), focus.getMarca());
        Assert.assertEquals(c.getModelo(), focus.getModelo());
    }
}
