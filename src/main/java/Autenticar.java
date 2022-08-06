
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obt�m a sess�o corrente ou null

		HttpSession session = request.getSession(false);

		// Recupera login e senha enviados pela tela de login
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		// Se j� estiver logado
		if (session != null && session.getAttribute("login") != null) {
			// Vai para a p�gina principal
			request.getRequestDispatcher("/index").forward(request, response);
			// Se n�o est� logado, ent�o verifica se nome e senha est�o corretos
		} else if (nome != null && senha != null && nome.equalsIgnoreCase("Guilherme") && senha.equals("123")) {
			// Se a senha est� correta ent�o cria a sess�o
			session = request.getSession(true);

			// Salva o usu�rio na sess�o
			session.setAttribute("login", nome);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.append("<html>" + "<head><title>Logado</title></head>"
					+ "<body>"
					+ "<h2>Nova Sess�o criada</h2>"
					+ "<h3>Session ID: " + session.getId() + "</h3>"
					+ "<h3>Session Creation Time: " + new Date(session.getCreationTime()) + "</h3>"
					+ "<h3>Session Last Acessed Time: " + new Date(session.getLastAccessedTime()) + "</h3>"
					+ "<h3>Session Max Inactive Interval: " + new Date(session.getMaxInactiveInterval()) + "</h3>"
					+ "<a href='" + request.getContextPath() + "/index.html'>Continuar</a>"
					+ "</body>"
					+ "</html>");
		} else {
			response.sendRedirect(request.getContextPath() + "/tela_login.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
