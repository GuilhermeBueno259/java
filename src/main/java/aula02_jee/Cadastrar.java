package aula02_jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return super.getServletInfo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String sexo = request.getParameter("radioSexo");
		String linJava = request.getParameter("checkJava") != null ? "J" : "";
		String linPython = request.getParameter("checkPython") != null ? "Y" : "";
		String linPhp = request.getParameter("checkPHP") != null ? "P" : "";
		String linSql = request.getParameter("checkSQL") != null ? "S" : "";
		String linguagens = linJava + linPython + linPhp + linSql;
		String cidade = request.getParameter("radioCidade");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Servelet recebeu formulário</h3>");
		out.println("ID: " + id);
		out.println("<br>Nome: " + nome);
		out.println("<br>Sobrenome: " + sobrenome);
		out.println("<br>Sexo: " + sexo);
		out.println("<br>Linguagens: " + linguagens);
		out.println("<br>Cidade: " + cidade);
		out.println("</body>");
		out.println("</html>");
		salvarDados(nome, sobrenome, sexo, linguagens, cidade);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean salvarDados(String nome, String sobrenome, String sexo, String linguagens, String cidade) {
		String url = "jdbc:mysql://localhost:3306/emprego?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "softgraf";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);

			PreparedStatement cmd = conexao.prepareStatement(
					"INSERT INTO candidato (nome, sobrenome, sexo, linguagens, cidade) VALUES (?, ?, ?, ?, ?)");
			cmd.setString(1, nome);
			cmd.setString(2, sobrenome);
			cmd.setString(3, sexo);
			cmd.setString(4, linguagens);
			cmd.setString(5, cidade);

			int retorno = cmd.executeUpdate();

			return retorno > 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
