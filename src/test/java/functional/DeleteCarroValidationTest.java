package functional;

import basetest.BaseTest;
import builder.Carro;
import com.lusa.carros.clients.DeleteCarrosClient;
import datadriven.CarroDataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class DeleteCarroValidationTest extends BaseTest {


    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void validaDelecaodoCarro(Carro carroProvider){
        Carro carroInserido =
        given().
            spec(getRequestSpecification()).
            body(carroProvider).
        when().
            post("/carros").
        then().
            statusCode(SC_CREATED).
            extract().
                body().
                    as(Carro.class);

        deleteCarrosClient.deleteCarros(carroInserido.getId());

    }

    @Test
    public void validaDelecaoSemDados(){
        deleteCarrosClient.deleteCarroNotFound(0L);
    }
}
