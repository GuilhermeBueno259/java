package com.softgraf.primavera.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository produtoRepository;

	public CrudService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
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

}
