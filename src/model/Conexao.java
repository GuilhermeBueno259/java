package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static String url = "jdbc:mysql://localhost:3307/escola?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static String usuario = "root";
	private static String senha = "softgraf";

	private static Connection conexao = null;

	public static boolean conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexao = DriverManager.getConnection(url, usuario, senha);

		} catch (ClassNotFoundException e) {
			System.out.printf("\nErro: %s não localizado\n", e.getMessage());
			return false;
		} catch (SQLException e) {
			System.out.printf("\nErro: %s", e.getMessage());
			return false;
		}
		System.out.printf("\nConectou!");
		return true;
	}

	public static Connection getConexao() {
		return conexao;
	}

	public static void fecharConexao() {
		try {
			conexao.close();
			System.out.printf("\nDesconectou!");
		} catch (SQLException e) {
			System.out.printf("\nErro ao conectar ao banco de dados\n%s", e.getMessage());
		}
	}
}
