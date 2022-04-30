package com.softgraf.controller;

import java.util.Date;

import com.softgraf.model.Cliente;
import com.softgraf.model.Endereco;
import com.softgraf.model.Item;
import com.softgraf.model.Pedido;
import com.softgraf.model.Produto;

public class Principal {

	public static void main(String[] args) {
		Produto produto0 = new Produto("123", "Melhoral Infantil", 1.99f);

		Produto p1 = new Produto("456", "Vitamina D com Zinco", 49.99f);

		System.out.println(produto0);
		System.out.println(p1);

		Endereco endereco0 = new Endereco();
		endereco0.setRua("Rua XV de Novembro, 123");
		endereco0.setCidade("Ponta Grossa");
		endereco0.setEstado("Paraná");
		endereco0.setCep("84010-100");
//
//		System.out.println("Endereço 1: \n" + endereco0.getRua() + "\n" + endereco0.getCidade() + "\n"
//				+ endereco0.getEstado() + "\n" + endereco0.getCep());
//
		Cliente cliente0 = new Cliente();
		cliente0.setNome("João da Silva");
		cliente0.setCodigo("C999");
		cliente0.setEndereco(endereco0);
//
//		System.out.println("Cliente 1: " + cliente0.getCodigo() + "\nNome: " + cliente0.getNome() + "\nEndereço: "
//				+ cliente0.getEndereco().getRua() + " - CEP: " + cliente0.getEndereco().getCep() + "\nCidade/Estado: "
//				+ cliente0.getEndereco().getCidade() + " - " + cliente0.getEndereco().getEstado());
//
		Pedido pedido0 = new Pedido();

		pedido0.setCliente(cliente0);
		pedido0.setNumero(0);
		pedido0.setData(new Date());

//		System.out.println("Código do Pedido: " + pedido0.getNumero() + "\nCliente: " + pedido0.getCliente().getCodigo()
//				+ " - Nome: " + pedido0.getCliente().getNome() + "\nData: " + pedido0.getData().getDate() + "/"
//				+ (pedido0.getData().getMonth() + 1) + "/" + (pedido0.getData().getYear() + 1900));

		Item i0 = new Item();
		i0.setNumero(0);
		i0.setProduto(produto0);
		i0.setQtdeProduto(10);

		Item i1 = new Item();
		i1.setNumero(1);
		i1.setProduto(p1);
		i1.setQtdeProduto(20);

		pedido0.addItem(i0);
		pedido0.addItem(i1);

//		System.out.println("Número do Item: " + i0.getNumero() + "\nProduto: " + i0.getProduto().getCodigo()
//				+ " - Descrição: " + i0.getProduto().getDescricao() + "\nQuantidade: " + i0.getQtdeProduto()
//				+ "\n------------------------------------------------");
//
//		System.out.println("Número do Item: " + i1.getNumero() + "\nProduto: " + i1.getProduto().getCodigo()
//				+ " - Descrição: " + i1.getProduto().getDescricao() + "\nQuantidade: " + i1.getQtdeProduto()
//				+ "\n------------------------------------------------");

//		System.out.println("Número do Item: " + pedido0.listaItens().get(0).getNumero() + "\nProduto: "
//				+ pedido0.listaItens().get(0).getProduto().getCodigo() + " - Descrição: "
//				+ pedido0.listaItens().get(0).getProduto().getDescricao() + "\nQuantidade: "
//				+ pedido0.listaItens().get(0).getQtdeProduto() + "\n------------------------------------------------");
//
//		System.out.println("Número do Item: " + pedido0.listaItens().get(1).getNumero() + "\nProduto: "
//				+ pedido0.listaItens().get(1).getProduto().getCodigo() + " - Descrição: "
//				+ pedido0.listaItens().get(1).getProduto().getDescricao() + "\nQuantidade: "
//				+ pedido0.listaItens().get(1).getQtdeProduto() + "\n------------------------------------------------");

	}
}
