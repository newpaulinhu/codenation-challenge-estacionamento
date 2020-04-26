package challenge;

import java.util.ArrayList;
import java.util.List;

public class EstacionamentoValidator implements Validator {

	List<Validator> validadores = new ArrayList<>();
	
	public EstacionamentoValidator() {
		validadores.add(new CarroValidator());
		validadores.add(new MotoristaValidator());
	}

	public void validar(Carro carro) {
		validadores.forEach(v -> v.validar(carro));
	}
	
	public void validar(List<Carro> carrosEstacionados, int vagas, Carro carro) {
		this.validar(carro);
		
		boolean todosSaoSenior = carrosEstacionados.stream().allMatch(c -> c.getMotorista().getIdade() > 55);
    	
    	if(todosSaoSenior && carrosEstacionados.size() == vagas) {
    		throw new EstacionamentoException("Estacionamento Lotado!");
    	}
	}
}
