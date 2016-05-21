package br.com.fiap.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

/**
 * Servlet implementation class ServletCadLivros
 */
@WebServlet("/admin/cadlivros")
@MultipartConfig
public class ServletCadLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadLivro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("cadLivros.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		InputStream inputStream = null;
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String data = request.getParameter("data");
			Date datapub = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			double preco = Double.parseDouble(request.getParameter("preco"));
			Part filePart = request.getPart("foto");
			byte[] imagem = new byte[(int) filePart.getSize()];
			if (filePart != null) {
				inputStream = filePart.getInputStream();
				inputStream.read(imagem, 0, (int) filePart.getSize());
			}
			Livro livro = new Livro();
			livro.setCodigo(codigo);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setDataPublicacao(datapub);
			livro.setPreco(preco);
			livro.setImagem(imagem);

			GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);

			if (dao.buscar(codigo) != null) {
				request.setAttribute("msgLivros", "Livro já cadastrado!");
				request.getRequestDispatcher("cadLivros.jsp").forward(request, response);
			} else {
				dao.adicionar(livro);

				Livro livroInserido = dao.buscar(livro.getCodigo());

				if (livroInserido != null) {
					request.setAttribute("msgLivros", "Livro " + livroInserido.getTitulo() + " inserido!");
					request.getRequestDispatcher("cadLivros.jsp").forward(request, response);
				} else {
					request.setAttribute("msgLivros", "Erro ao cadastrar o livro!");
					request.getRequestDispatcher("cadLivros.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgLivros", "Erro ao cadastrar o livro!");
			request.getRequestDispatcher("cadLivros.jsp").forward(request, response);
		}
	}

}
