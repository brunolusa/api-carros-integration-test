package contract;

import basetest.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class GetAllCarrosV1ContactTest extends BaseTest {

    @Test
    public void ValidaContratoGetCarros(){
        given().
            spec(getRequestSpecification()).
        when().
            get("/carros").
        then().
            statusCode(SC_OK).
            body(matchesJsonSchema(new File("src/test/resources/jsonSchema/GetAllCarrosV1JsonSchema.json")));
    }
}
