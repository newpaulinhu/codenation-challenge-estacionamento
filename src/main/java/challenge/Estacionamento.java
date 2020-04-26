package challenge;

import java.util.LinkedList;
import java.util.List;

public class Estacionamento {

	EstacionamentoValidator validador = new EstacionamentoValidator();
	private List<Carro> carrosEstacionados = new LinkedList<>();
	private int vagas = 10;
	
    public void estacionar(Carro carro) {
    	
    	validador.validar(carrosEstacionados, vagas, carro);
    	
    	if (carrosEstacionados.size() == vagas) {
    		carrosEstacionados.stream().filter(c -> c.getMotorista().getIdade() < 55).findFirst().ifPresentOrElse(c -> carrosEstacionados.remove(c), () -> carrosEstacionados.remove(0));
		}
      
    	carrosEstacionados.add(carro);
    }

    public int carrosEstacionados() {
        return this.carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.stream().anyMatch(c -> c.equals(carro));
    }
}
