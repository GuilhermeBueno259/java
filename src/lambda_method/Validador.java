package lambda_method;

/*
 * Aqui criamos nossa própria interface funcional
 * Podemos marcar uma interface funcional explicitamente, mais isso é opcional.
 * porém se uma interface for anotada e adicionarmos mais de um método,
 * ocorre um erro de compilação.
 */
@FunctionalInterface
public interface Validador<T> {

	boolean validar(T t);
	
}
