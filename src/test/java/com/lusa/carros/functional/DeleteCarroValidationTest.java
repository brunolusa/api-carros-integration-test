package com.lusa.carros.functional;

import com.lusa.carros.basetest.BaseTest;
import com.lusa.carros.model.Carro;
import com.lusa.carros.datadriven.CarroDataProvider;
import org.testng.annotations.Test;

public class DeleteCarroValidationTest extends BaseTest {


    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void validaDelecaodoCarro(Carro carroProvider){

        Carro carroInserido =
            postCarrosClient.criaNovoCarro(carroProvider).
                extract().
                    body().
                        as(Carro.class);

        deleteCarrosClient.deleteCarros(carroInserido.getId());

    }

    @Test
    public void validaDelecaoSemDados(){
        deleteCarrosClient.deleteCarroNotFound(0L);
    }
}
