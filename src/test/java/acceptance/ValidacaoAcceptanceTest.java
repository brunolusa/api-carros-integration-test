package acceptance;

import basetest.BaseTest;
import builder.Carro;
import datadriven.CarroDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class ValidacaoAcceptanceTest extends BaseTest {

    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void testeDeAceitacao(Carro c){

        //CRUD
        //CREATE
        Carro novoCarro =
        given().
            spec(getRequestSpecification()).
            body(c).
        when().
            post("/carros").
        then().
            statusCode(SC_CREATED).
                extract().
                    body().
                        as(Carro.class);

        //READ
        Carro carroDaBase =
        given().
            spec(getRequestSpecification()).
            pathParam("id",novoCarro.getId()).
        when().
            get("/carros/{id}").
        then().
            statusCode(SC_OK).
                extract().
                    body().
                    as(Carro.class);

        Assert.assertEquals(novoCarro, carroDaBase);

        //UPDATE
        carroDaBase.setModelo("Taurus");

        given().
            spec(getRequestSpecification()).
            pathParam("id",carroDaBase.getId()).
            body(carroDaBase).
        when().
            put("/carros/{id}").
        then().
            statusCode(SC_OK).
            body("modelo", is("Taurus"));

        //DELETE
        given().
            spec(getRequestSpecification()).
            pathParam("id",carroDaBase.getId()).
        when().
            delete("/carros/{id}").
        then().
            statusCode(SC_NO_CONTENT);

        //READE TO CONFIRM THE DELETION
        given().
            spec(getRequestSpecification()).
            pathParam("id",carroDaBase.getId()).
        when().
            get("/carros/{id}").
        then().
            statusCode(SC_NOT_FOUND);
    }
}
