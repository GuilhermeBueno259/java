package com.softgraf.primavera.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository produtoRepository;

	public CrudService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void cadastraTresProdutos() {
		Produto p1 = new Produto("Xarope para tosse", 35.90f, 10);
		Produto p2 = new Produto("Shampoo Anticaspa", 49.99f, 15);
		Produto p3 = new Produto("Anti-inflamatório", 5.66f, 20);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		System.out.println("===== 3 produtos salvos =====");
	}

	public void cadastraNovoProduto() {
		Scanner entrada = new Scanner(System.in);
		Produto p = new Produto();

		System.out.println("Descrição: ");
		p.setDescricao(entrada.nextLine());

		System.out.println("Preço: ");
		p.setPreco(entrada.nextFloat());

		System.out.println("Quantidade: ");
		p.setQuantidade(entrada.nextInt());

		produtoRepository.save(p);
		System.out.println("Produto salvo");

		entrada.close();
	}

	public void cadastra100ProdutosAleatorios() {
		for (int i = 1; i <= 100; i++) {
			Produto produto = new Produto(randomTexto(7), (float) (Math.random() * 100),
					1 + (int) (Math.random() * 30));

			produtoRepository.save(produto);
			System.out.printf("\nProduto %d/100 salvo", i);
		}
	}

	private String randomTexto(int tamanho) {
		StringBuilder builder = new StringBuilder();
		int base = 97;
		for (int i = 0; i < tamanho; i++) {
			char letra = (char) (base + (Math.random() * 26));
			builder.append(letra);
		}

		return builder.toString();
	}

	public void listaTodosOsProdutos() {
		System.out.println("\n\n====== Listando todos os produtos ======");
		List<Produto> todos = produtoRepository.findAll();
		todos.forEach(System.out::println);
	}

	public void listaProdutosComPaginacao() {
		// paginação e ordenação por id ascendente
		Pageable paginacao = PageRequest.of(0, 20, Sort.by("preco").ascending());

		Page<Produto> pagina = produtoRepository.findAll(paginacao);
		System.out.printf("\n\nTotal de páginas: %d\n", pagina.getTotalPages());
		System.out.printf(">>Página atual: %d\n", pagina.getNumber());
		System.out.printf(">>Itens por página: %d\n", pagina.getSize());
		System.out.printf(">>Total de itens da consulta: %d\n", pagina.getTotalElements());

		Scanner input = new Scanner(System.in);
		String escolha = "";

		do {
			System.out.println("\n\n==== Menu de paginação =====");
			System.out.println("MOSTRAR = mostra conteúdo da página atual");
			System.out.println("PROX = vai para a próxima página");
			System.out.println("ANT = vai para a página anterior");
			System.out.println("PRI = vai para a primeira página");
			System.out.println("ULT = vai para a última página");
			System.out.println("CONV = converte a página em lista");
			System.out.println("FIM = sai do menu");
			System.out.println("Qual opção?");
			escolha = input.next().toUpperCase();

			if (escolha.equals("Fim")) {
				System.out.println("\nSaiu do Menu");
				input.close();
				break;
			}

			switch (escolha) {
			case "MOSTRAR":
				System.out.printf("\n\n----- Exibindo página: %d\n", pagina.getNumber());
				pagina.forEach(System.out::println);
				break;
			case "PROX":
				if (pagina.hasNext()) {
					pagina = produtoRepository.findAll(pagina.nextPageable());
					System.out.printf("\n\n*** Foi para a página: %d", pagina.getNumber());
				} else {
					System.out.println("\n\n*** Não há próxima página");
				}
				break;
			case "ANT":
				if (pagina.hasPrevious()) {
					pagina = produtoRepository.findAll(pagina.previousPageable());
					System.out.printf("\n\n*** Foi para a página: %d", pagina.getNumber());
				} else {
					System.out.println("\n\n*** Não há página anterior");
				}
				break;
			case "PRI":
				pagina = produtoRepository.findAll(paginacao.first());
				System.out.printf("\n\n*** Foi para a página: %d", pagina.getNumber());
				break;
			case "ULT":
				paginacao = PageRequest.of(pagina.getTotalPages() - 1, 20, Sort.by("id").ascending());
				pagina = produtoRepository.findAll(paginacao);
				System.out.printf("\n\n*** Foi para a página: %d", pagina.getNumber());
				break;
			case "CONV":
				@SuppressWarnings("unused") List<Produto> lista = pagina.getContent();
				System.out.println("List<Produto> lista = pagina.getContent();");
				break;
			default:
				System.out.println("\n*** Opção inválida ***");
				break;
			}
		} while (true);

	}

}
