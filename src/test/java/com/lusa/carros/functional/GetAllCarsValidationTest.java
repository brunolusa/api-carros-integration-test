package com.lusa.carros.functional;

import com.lusa.carros.basetest.BaseTest;
import org.testng.annotations.Test;

public class GetAllCarsValidationTest extends BaseTest {

    @Test
    public void buscaTodosOsCarrosTest(){ getCarrosClient.getAllCarros(); }

}
