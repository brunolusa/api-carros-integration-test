package functional;

import basetest.BaseTest;
import builder.Carro;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;
import static org.hamcrest.CoreMatchers.*;

public class PutCarroValidationTest extends BaseTest {

    @Test
    public void atualizaAtributosCarro(){

        List<Carro> carrosDaBase =
        given().
            spec(getRequestSpecification()).
        when().
            get("/carros").
        then().
            statusCode(SC_OK).
                extract().
                    body().
                    jsonPath().
                        getList(".", Carro.class);

        carrosDaBase.get(0).setMarca("Teste");

        given().
            spec(getRequestSpecification()).
            body(carrosDaBase.get(0)).
            pathParam("id",carrosDaBase.get(0).getId()).
        when().
            put("/carros/{id}").
        then().
            statusCode(SC_OK).
            body("id", is(carrosDaBase.get(0).getId().intValue()),
            "modelo",is(carrosDaBase.get(0).getModelo()),
                    "marca",is(carrosDaBase.get(0).getMarca()));

    }
}
