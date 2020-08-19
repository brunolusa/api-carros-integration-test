package com.lusa.carros.basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.*;
import com.lusa.carros.utils.Env;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    public static CarrosClient carrosClient;

    @BeforeSuite
    public void setUp() {

        carrosClient = new CarrosClient(Env.getEnv());

    }
}
