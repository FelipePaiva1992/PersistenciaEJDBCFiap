package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@WebServlet("/admin/listalivros")
public class ServletListaLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaLivros() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		try {
			GenericDao<Livro> dao = new GenericDao<>(Livro.class);

			List<Livro> livros = dao.listar();

			if (livros == null || livros.size() <= 0) {
				request.setAttribute("msgLivro", "Nenhum livro cadastrado!");
				request.getRequestDispatcher("listaLivros.jsp").forward(request, response);
			} else {
				request.setAttribute("livros", livros);
				request.getRequestDispatcher("listaLivros.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgLivro", "Nenhum livro cadastrado!");
			request.getRequestDispatcher("listaLivros.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("listaLivros.jsp").include(request, response);
	}

}
