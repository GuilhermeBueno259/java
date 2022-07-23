
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		PrintWriter saida = response.getWriter();

		if (usuario.equals("Guilherme") && senha.equals("123456")) {
//			saida.println("<html><h1>" + usuario + " logou</h1></html>");
//			response.sendRedirect("principal");
			request.getRequestDispatcher("principal").forward(request, response);
		} else {
			saida.print("<html><h1>Usuario/senha incorreto</h1></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
