package com.lusa.carros.functional;

import com.lusa.carros.basetest.BaseTest;
import com.lusa.carros.model.Carro;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class PutCarroValidationTest extends BaseTest {

    @Test
    public void atualizaAtributosCarro(){

        List<Carro> carrosDaBase = getCarrosClient.getAllCarros().extract().body().jsonPath().getList(".",Carro.class);

        carrosDaBase.get(0).setMarca("Teste");

        Carro carroAlterado = putCarrosClient.alterarCarros(carrosDaBase.get(0), carrosDaBase.get(0).getId()).extract().body().as(Carro.class);

        assertEquals(carroAlterado.getId(), carrosDaBase.get(0).getId());
        assertEquals(carroAlterado.getMarca(), carrosDaBase.get(0).getMarca());
        assertEquals(carroAlterado.getModelo(), carrosDaBase.get(0).getModelo());

    }
}
