package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Aluno;

public class AlunoDao implements Dao<Aluno> {
	private Connection conexao;

	public AlunoDao(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean inserir(Aluno aluno) {
		String sql = "insert into aluno (nome, cpf, fone) values (?, ?, ?)";

		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, aluno.getNome());
			cmd.setString(2, aluno.getCpf());
			cmd.setString(3, aluno.getFone());
			int retorno = cmd.executeUpdate();
			
			if (retorno == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
			return false;
		}
	}

	@Override
	public boolean atualizar() {
		return false;
	}

	@Override
	public Aluno buscar(long id) {
		return null;
	}

	@Override
	public boolean apagar(long id) {
		return false;
	}

	@Override
	public List<Aluno> listar() {
		return null;
	}

}
