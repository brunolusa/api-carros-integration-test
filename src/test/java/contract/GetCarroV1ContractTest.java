package contract;

import basetest.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class GetCarroV1ContractTest extends BaseTest {

    @Test
    public void ValidaContratoGetCarro(){

        getCarrosClient.getCarroById(1L).body(matchesJsonSchema(new File("src/test/resources/jsonSchema/GetCarrosV1JsonSchema.json")));

    }
}
