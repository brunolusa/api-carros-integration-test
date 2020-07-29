package com.lusa.carros.acceptance;

import com.lusa.carros.basetest.BaseTest;
import com.lusa.carros.datadriven.CarroDataProvider;
import com.lusa.carros.model.Carro;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ValidacaoAcceptanceTest extends BaseTest {

    @Test(dataProvider = "novoCarro", dataProviderClass = CarroDataProvider.class)
    public void testeDeAceitacao(Carro c){

        //CRUD
        //CREATE
        Carro novoCarro =
            postCarrosClient.criaNovoCarro(c).
                extract().
                    body().
                        as(Carro.class);

        //READ
        Carro carroDaBase =
            getCarrosClient.getCarroById(novoCarro.getId()).
                extract().
                    body().
                        as(Carro.class);

        assertEquals(novoCarro, carroDaBase);

        //UPDATE
        carroDaBase.setModelo("Taurus");

        Carro carroAtualizado =
            putCarrosClient.alterarCarros(carroDaBase, carroDaBase.getId()).
                extract().
                    body().
                        as(Carro.class);

        assertEquals(carroAtualizado.getModelo(), carroDaBase.getModelo());

        //DELETE
        deleteCarrosClient.deleteCarros(carroDaBase.getId());

        //READE TO CONFIRM THE DELETION
        getCarrosClient.getCarrosNotFound(carroDaBase.getId());

    }
}
