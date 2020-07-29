package functional;

import basetest.BaseTest;
import builder.Carro;
import datafactory.CarroFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class GetCarByIdValidationTest extends BaseTest {

    @Test
    public void buscaCarroPeloId(){

        Carro focus = CarroFactory.novoCarroFordFiesta();

        Carro c =
            given().
                spec(getRequestSpecification()).
                pathParam("id", 2).
            when().
                get("/carros/{id}").
            then().
                statusCode(SC_OK)
                .extract().body().as(Carro.class);

        Assert.assertEquals(c.getMarca(), focus.getMarca());
        Assert.assertEquals(c.getModelo(), focus.getModelo());
    }
}
