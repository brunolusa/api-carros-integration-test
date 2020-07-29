package contract;

import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class GetCarroV1ContractTest {

    @Test
    public void ValidaContratoGetCarro(){

        given().
            spec(getRequestSpecification()).
            pathParam("id","1").
        when().
            get("/carros/{id}").
        then().
            statusCode(SC_OK).
            body(matchesJsonSchema(new File("src/test/resources/jsonSchema/GetCarrosV1JsonSchema.json")));

    }
}
