package com.lusa.carros.functional;

import com.lusa.carros.basetest.BaseTest;
import org.testng.annotations.Test;

public class GetAllCarsValidationTest extends BaseTest {

    @Test
    public void buscaTodosOsCarrosTest(){

        String token = carrosClient.getTokenAuthentication("bruno", "123", "app_run", "app_run");

        carrosClient.getAllCarros(token); }
}
