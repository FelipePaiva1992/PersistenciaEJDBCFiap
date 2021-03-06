package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet(name = "Servlet Login", urlPatterns = { "/valida" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		HttpSession session = request.getSession();

		try {
			GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");

			Usuario usuario = dao.buscar(nome, senha);

			if (usuario != null) {

				session.setAttribute("usuario_logado", usuario);
				response.sendRedirect("admin/menu.jsp");
			} else {
				session.setAttribute("usuario_logado", null);
				request.setAttribute("msgValidacao", "Usuario ou Senha invalidos!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			session.setAttribute("usuario_logado", null);
			request.setAttribute("msgValidacao", "Usuario ou Senha invalidos!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
