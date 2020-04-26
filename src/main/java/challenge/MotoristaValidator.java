package challenge;

public class MotoristaValidator implements Validator {

	@Override
	public void validar(Carro carro) {
		Motorista motorista = carro.getMotorista();
		
		if(motorista.getIdade() < 18) {
			throw new EstacionamentoException("Motorista menor de idade");
		}
		
		if(motorista.getPontos() > 20) {
			throw new EstacionamentoException("Motorista com carteira suspensa");
		}
	}
}
