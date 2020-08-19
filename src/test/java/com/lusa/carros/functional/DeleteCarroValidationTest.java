package com.lusa.carros.functional;

import com.lusa.carros.basetest.BaseTest;
import com.lusa.carros.datadriven.CarroDataProvider;
import com.lusa.carros.model.Carro;
import org.testng.annotations.Test;

public class DeleteCarroValidationTest extends BaseTest{

    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void validaDelecaodoCarro(Carro carroProvider){
        Carro carroInserido =
            carrosClient.criaNovoCarro(carroProvider).
                extract().
                    body().
                        as(Carro.class);

        carrosClient.deleteCarros(1L);

    }

    @Test
    public void validaDelecaoSemDados(){
        carrosClient.deleteCarroNotFound(0L);
    }
}
