package controller;

import java.util.List;
import java.util.Scanner;

import dao.AlunoDao;
import model.Aluno;
import model.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
//		Aluno aluno = new Aluno("Jo�o da Silva", "123.456.789-10", "(42)99999-9999");

		if (Conexao.conectar()) {

			Scanner input = new Scanner(System.in);

			AlunoDao dao = new AlunoDao(Conexao.getConexao());

//			if (dao.inserir(aluno)) {
//				System.out.printf("\nDados Salvos!");
//			} else {
//				System.out.printf("\nErro ao Salvar!");
//			}

			System.out
					.printf("\nO que voc� deseja?\n-0-> Buscar aluno espec�fico\n-1-> Retornar lista inteira\n-2-> Apagar Registro\nOp��o: ");
			int opcao = input.nextInt();

			switch (opcao) {
			case 0:
				System.out.printf("\nDigite a matricula do aluno: ");
				int idParaBusca = input.nextInt();
				Aluno alunoRetorno = dao.buscar(idParaBusca);

				if (alunoRetorno.getNome() != null) {
					System.out.printf("\nNome: %s\nCPF: %s\nFone: %s\n", alunoRetorno.getNome(), alunoRetorno.getCpf(),
							alunoRetorno.getFone());
				} else {
					System.out.printf("\nID %d n�o encontrado", idParaBusca);
				}

				break;

			case 1:
				List<Aluno> lista = dao.listar();

				System.out.printf("\nAlunos no sistema\n");
				System.out.printf("Quantidade de alunos no sistema: %d", lista.size());

				for (Aluno a : lista) {
					System.out.printf("\n----------------------------------------%s", a);
				}
				break;
			case 2:
				System.out.printf("\nDigite a matricula do aluno:");
				int idParaApagar = input.nextInt();
				boolean apagou = dao.apagar(idParaApagar);
				if (apagou)
					System.out.printf("Registro do aluno apagado!");
				else
					System.out.printf("N�o foi poss�vel apagar o registro!");
			}

			Conexao.fecharConexao();
			input.close();
		} else {
			System.out.printf("\nN�o conectou com o banco!");
		}
	}
}
