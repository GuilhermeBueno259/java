package com.softgraf.primavera;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softgraf.primavera.service.CrudService;

@SpringBootApplication
// caso o Spring não encontre os repositórios
//@EnableJpaRepositories(basePackages = "com.softgraf.primavera.data.repository")
public class PrimaveraApplication implements CommandLineRunner {

	private final CrudService crudService;

	public PrimaveraApplication(CrudService crudService) {
		this.crudService = crudService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
	}

	/*
	 * método da interface CommandLineRunner executado na finalização do método
	 * main() usado para testar os repositórios, sem necessitar do front end
	 */

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Método run() executando...");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n===== Sistema Primavera =====");
			System.out.println("1 = Cadastrar 3 produtos padrôes");
			System.out.println("2 = Cadastrar novo produto");
			System.out.println("3 = Cadastrar 100 produtos aleatórios");
			System.out.println("4 = Listar todos os produtos");
			System.out.println("5 = Listar todos os produtos com paginação (20/página) e ordem ascendente");
			System.out.println("6 = Busca produto por descrição");

			System.out.println("Qual opção? ");
			int opcao = input.nextInt();

			switch (opcao) {
			case 1:
				crudService.cadastraTresProdutos();
				break;
			case 2:
				crudService.cadastraNovoProduto();
				break;
			case 3:
				crudService.cadastra100ProdutosAleatorios();
				break;
			case 4:
				crudService.listaTodosOsProdutos();
				break;
			case 5:
				crudService.listaProdutosComPaginacao();
				break;
			case 6:

				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
