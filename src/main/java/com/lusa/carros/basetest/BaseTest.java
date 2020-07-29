package com.lusa.carros.basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    private static RequestSpecification requestSpecification;
    public static DeleteCarrosClient deleteCarrosClient;
    public static GetActuatorClient getActuatorClient;
    public static GetCarrosClient getCarrosClient;
    public static PostCarrosClient postCarrosClient;
    public static PutCarrosClient putCarrosClient;

    @BeforeSuite
    public static void setUp() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        deleteCarrosClient = new DeleteCarrosClient();
        getActuatorClient = new GetActuatorClient();
        getCarrosClient = new GetCarrosClient();
        postCarrosClient = new PostCarrosClient();
        putCarrosClient = new PutCarrosClient();

    }
}
