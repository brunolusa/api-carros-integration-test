package com.lusa.carros.basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    public static DeleteCarrosClient deleteCarrosClient;
    public static GetActuatorClient getActuatorClient;
    public static GetCarrosClient getCarrosClient;
    public static PostCarrosClient postCarrosClient;
    public static PutCarrosClient putCarrosClient;

    @BeforeSuite
    public static void setUp() {

        deleteCarrosClient = new DeleteCarrosClient();
        getActuatorClient = new GetActuatorClient();
        getCarrosClient = new GetCarrosClient();
        postCarrosClient = new PostCarrosClient();
        putCarrosClient = new PutCarrosClient();

    }
}
