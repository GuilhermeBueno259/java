package controller;

import dao.AlunoDao;
import model.Aluno;
import model.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("João da Silva");
		aluno.setCpf("123.456.789-10");
		aluno.setFone("(42)99999-9999");
		
		if (Conexao.conectar()) {
			
			AlunoDao dao = new AlunoDao(Conexao.getConexao());
			
			if (dao.inserir(aluno)) {
				System.out.printf("\nDados Salvos!");
			} else {
				System.out.printf("\nErro ao Salvar!");
			}
			Conexao.fecharConexao();
		} else {
			System.out.printf("\nNão conectou com o banco!");
		}
	}
}
