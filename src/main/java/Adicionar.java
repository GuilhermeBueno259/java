
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adicionar")
public class Adicionar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cookieNome = request.getParameter("cookienome");
		String cookieValor = request.getParameter("cookievalor");
		int cookieTempo = Integer.parseInt(request.getParameter("cookietempo"));

		Cookie cookie = new Cookie(cookieNome, cookieValor);
		// Tempo de vida do cookie
		// -1 = dura até o navegador ser fechaddo (padrão do sistema)
		// 0 = apaga o cookie
		// > 0 = duração do cookie em segundos
		cookie.setMaxAge(cookieTempo);
		
		response.addCookie(cookie);
		
		response.setContentType("text/html"); // Tipo MIME

		PrintWriter out = response.getWriter();
		out.append("<html>" + "<head>" + "<title>Cookies</title>" + "</head>" + "<body>" + "<h3>Cookie adicionado</h3>"
				+ "Nome: " + cookieNome + "<br>"
				+ "Valor: " + cookieValor + "<br>"
				+ "Tempo: " + cookieTempo + "<br><br>"
				+ "<a href='/projeto_cookies/'>Adicionar Cookies</a><br>"
				+ "<a href='/projeto_cookies/listar'>Listar Cookies</a><br>"
						
				+ "</body>" + "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
