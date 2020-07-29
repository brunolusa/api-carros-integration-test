package datafactory;

import com.lusa.carros.model.Carro;

public class CarroFactory {

    public Carro novoCarroRenaultSandero(){
        return Carro.builder().marca("Renault").modelo("Sandero").build();
    }

    public static Carro novoCarroFordFiesta(){
        return Carro.builder().marca("Ford").modelo("Fiesta").build();
    }
}
