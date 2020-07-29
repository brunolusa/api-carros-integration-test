package datadriven;

import datafactory.CarroFactory;
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
