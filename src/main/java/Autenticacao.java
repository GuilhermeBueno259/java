import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/index" })
@WebFilter(urlPatterns = { "/*" })
public class Autenticacao extends HttpServlet implements Filter {

	private static final long serialVersionUID = 3061973934312075924L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou /index da servlet");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("======= doFilter() iniciado");

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// Obtém a sessão atual ou null
		HttpSession session = req.getSession(false);

		// Significa que o usuário já está logado
		if (session != null && session.getAttribute("login") != null) {
			System.out.println("Você já está logado!");
			chain.doFilter(request, response);
			// Significa que o usuário não está logado
		} else if (nome != null && nome.equalsIgnoreCase("guilherme") && senha != null && senha.equals("123456")) {
			// cria uma sessão
			session = req.getSession(true); // obtém ou cria
			// salva o logina na sessão
			session.setAttribute("login", nome);
			// carrega a página solicitada
			chain.doFilter(request, response);
		} else {
			// não está logado e não foi informado login e senha
			// faz um encaminhamento para o login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		System.out.println("======= doFilter() finalizado");
	}

}
