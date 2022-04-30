package exemplo_interface;

abstract public class Tv {
	private int tamanho, canal, volume;
	private boolean ligado;

	public Tv(int tamanho) {
		this.tamanho = tamanho;
		this.canal = 0;
		this.volume = 0;
		this.ligado = false;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

}
