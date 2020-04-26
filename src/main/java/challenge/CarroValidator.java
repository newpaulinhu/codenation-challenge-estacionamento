package challenge;

public class CarroValidator implements Validator {

	public void validar(Carro carro) {
		
		if (carro.getMotorista() == null) {
			throw new EstacionamentoException("Não é permitido carro autonomo!");
		}
		
	}
}
