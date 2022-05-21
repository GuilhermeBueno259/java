package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

			cmd.close();

			return retorno > 0;

		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
			return false;
		}
	}

	@Override
	public boolean atualizar(Aluno aluno) {
		String sql = "update aluno set nome = ?, cpf = ?, fone = ? where id = ?";
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, aluno.getNome());
			cmd.setString(2, aluno.getCpf());
			cmd.setString(3, aluno.getFone());
			cmd.setLong(4, aluno.getId());

			int retorno = cmd.executeUpdate();

			cmd.close();

			return retorno > 0;
		} catch (SQLException e) {
			System.out.printf("Erro: %s", e.getMessage());
			return false;
		}
	}

	@Override
	public Aluno buscar(long id) {
		Aluno aluno = new Aluno();
		String sql = "select * from aluno where id = ?";
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setLong(1, id);
			ResultSet rs = cmd.executeQuery();

			if (rs.next()) {
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setFone(rs.getString("fone"));
			}

			cmd.close();

		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
			aluno = null;
		}
		return aluno;
	}

	@Override
	public boolean apagar(long id) {
		String sql = "delete from aluno where id = ?";
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);

			cmd.setLong(1, id);

			int i = cmd.executeUpdate();

			cmd.close();

			return i > 0;

		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
			return false;
		}

	}

	@Override
	public List<Aluno> listar() {
		String sql = "select * from aluno order by id";
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				lista.add(new Aluno(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("fone")));
			}

			cmd.close();

		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
		}
		return lista;
	}

}
