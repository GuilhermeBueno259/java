package conta;

public abstract class Conta {

	private int numero;
	private float saldo;

	public Conta(int numero) {
		this.numero = numero;
	}

	public void depositar(float deposito) {
		this.saldo += deposito;
	}

	public boolean sacar(float saque) {
		if (getSaldo() >= saque) {
			this.saldo -= saque;
			return true;
		} else {
			return false;
		}
	}

	public boolean transferir(float valorTransferencia, Conta para) {
		if (sacar(valorTransferencia)) {
			para.depositar(valorTransferencia);
			return true;
		}
		return false;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format("Número da conta: %-10d Saldo da conta: R$ %.2f", getNumero(), getSaldo());
	}
}
