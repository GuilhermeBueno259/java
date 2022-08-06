
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/index.html", "/index" }, initParams = {
		@WebInitParam(name = "empresa", value = "SOFTGRAF"),
		@WebInitParam(name = "cidade", value = "PONTA GROSSA"), })
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// false = Obtém a sessão corrente ou null
		// true = cria uma nova sessão
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("login") == null) {
			response.sendRedirect(request.getContextPath() + "/tela_login.html");
		} else {
			String login = (String) session.getAttribute("login");
			
			// Obtém os parametros da servlet
			String empresa = getInitParameter("empresa");
			String cidade = getInitParameter("cidade");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.append("<html>"
					+ "<head><title>Página Principal do Sistema</title></head>"
					+ "<body>"
					+ "<h2>Página Principal</h2>"
					+ "Bem vindo: " + login + "<br>"
					+ "Empresa: " + empresa+ "<br>"
					+ "Cidade: " + cidade + "<br>"
					+ "<a href='" + request.getContextPath() + "/logout'>Logout</a>"
					+ "</body>"
					+ "</html>");
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
