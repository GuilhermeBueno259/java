package lambda_method;

public class ExemploLambda3 {

	public static void main(String[] args) {
		
		// primeiramente vamos implementar a interface usando classe anônima
		Validador<String> validadorCep1 = new Validador<String>() {

			@Override
			public boolean validar(String cep) {
				return cep.matches("[0-9]{5}-[0-9]{3}");
			}
		};
		
		// agora com lambda
		Validador<String> validadorCep2 = cep -> cep.matches("[0-9]{5}-[0-9]{3}");
		
		// testando
		System.out.println(validadorCep2.validar("84010-320") ? "Cep válido" : "Cep inválido");

	}
}
