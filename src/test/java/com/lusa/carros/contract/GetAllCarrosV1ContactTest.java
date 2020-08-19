package com.lusa.carros.contract;

import com.lusa.carros.basetest.BaseTest;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetAllCarrosV1ContactTest extends BaseTest {

    @Test
    public void ValidaContratoGetCarros(){

        carrosClient.getAllCarros().body(matchesJsonSchema(new File("src/test/resources/jsonSchema/GetAllCarrosV1JsonSchema.json")));

    }
}
