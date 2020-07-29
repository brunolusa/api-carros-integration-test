package functional;

import basetest.BaseTest;
import builder.Carro;
import datadriven.CarroDataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class PostCarroValidationTest extends BaseTest {

    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void criaNovoCarro(Carro carro){

        given().
            spec(getRequestSpecification()).
            body(carro).
        when().
            post("/carros").
        then().
            statusCode(SC_CREATED).
            body("id", notNullValue(),
            "modelo",is(carro.getModelo()),
                    "marca",is(carro.getMarca()));

    }
}
