package com.lusa.carros.datadriven;

import com.lusa.carros.datafactory.CarroFactory;
import org.testng.annotations.DataProvider;

public class CarroDataProvider {

    @DataProvider
    public Object[][] novoCarro() {
        return new Object[][]{
                {
                    new CarroFactory().novoCarroRenaultSandero()
                }
        };
    }

}
