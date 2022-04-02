package conta;

public class Principal {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente(462.90f, 1);
		ContaCorrente contaCorrente2 = new ContaCorrente(397.35f, 2);
		
		System.out.println(contaCorrente.toString());

		contaCorrente.setLimite(543.52f);
		System.out.println("Limite da contaCorrente: R$" + contaCorrente.getLimite());

		System.out.println(contaCorrente.toString());

		contaCorrente.depositar(100);
		contaCorrente.depositar(100);
		contaCorrente.depositar(100);

		System.out.println(contaCorrente.toString());

		if (contaCorrente.transferir(100, contaCorrente2)) {
			System.out.println("Transferência realizada com sucesso...");
		} else {
			System.out.println("A transferência não pode ser realizada...");
		}

		if (contaCorrente.sacar(500)) {
			System.out.println("Saque realizado com sucesso...");
		} else {
			System.out.println("Falha ao realizar o saque...");
		}

		System.out.println(contaCorrente.toString());
	}
}
