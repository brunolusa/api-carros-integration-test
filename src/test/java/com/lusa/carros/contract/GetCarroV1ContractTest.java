package com.lusa.carros.contract;

import com.lusa.carros.basetest.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetCarroV1ContractTest extends BaseTest {

    @Test
    public void ValidaContratoGetCarro(){

        getCarrosClient.getCarroById(1L).body(matchesJsonSchema(new File("src/test/resources/jsonSchema/GetCarrosV1JsonSchema.json")));

    }
}
