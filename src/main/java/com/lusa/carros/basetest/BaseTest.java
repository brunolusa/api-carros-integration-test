package com.lusa.carros.basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.CarrosClient;
import com.lusa.carros.utils.Env;
import com.lusa.carros.utils.StaticValues;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    public static CarrosClient carrosClient;
    public String accessToken;

    @BeforeSuite
    public void setUp() {

        carrosClient = new CarrosClient(Env.getEnv());
        accessToken = carrosClient.getTokenAuthentication(StaticValues.USER, StaticValues.PASS, StaticValues.CLIENT_USER, StaticValues.CLIENT_PASS);

    }
}
