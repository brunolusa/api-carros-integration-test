package com.lusa.carros.healthcheck;

import com.lusa.carros.basetest.BaseTest;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseTest {

    @Test
    public void validaSaudedaAplicacao(){ carrosClient  .getHealthCheck(); }

}