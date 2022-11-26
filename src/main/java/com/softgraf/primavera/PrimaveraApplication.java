package com.softgraf.primavera;

import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.softgraf.primavera.service.CrudService;

@SpringBootApplication
public class PrimaveraApplication implements CommandLineRunner {

	private final CrudService crudService;

	public PrimaveraApplication(CrudService crudService) {
		this.crudService = crudService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	/*
	 * método da interface CommandLineRunner executado na finalização do método
	 * main() usado para testar os repositórios, sem necessitar do front end
	 */

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Método run() executando...");

		System.out.println("\n\n===== Sistema Primavera =====");
		System.out.println("1 = Cadastrar 3 produtos padrôes");
		System.out.println("2 = Cadastrar novo produto");
		System.out.println("3 = Cadastrar 100 produtos aleatórios");
		System.out.println("4 = Listar todos os produtos");
		System.out.println("5 = Listar todos os produtos com paginação (20/página) e ordem ascendente");
		System.out.println("6 = Busca produto por descrição");

		System.out.println("Qual opção? ");
	}

}
