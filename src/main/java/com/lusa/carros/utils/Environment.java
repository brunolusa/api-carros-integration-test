package com.lusa.carros.utils;

public class Environment {

    public Environment() {
    }

    public static String getEnvironment() {
        return System.getProperty("env", EnvironmentInterface.TST);
    }

    public interface EnvironmentInterface {

        String HOM = "hom";
        String TST = "tst";

    }
}
