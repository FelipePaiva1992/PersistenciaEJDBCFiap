package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/cadusuarios")
public class ServletCadUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("cadUsuarios.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		try {
			GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			int nivel = Integer.parseInt(request.getParameter("nivel"));
			Usuario usuarioNovo = null;
			
			usuarioNovo = dao.buscar(nome, senha);
			
			if(usuarioNovo != null){
				request.setAttribute("msgCadastro", "Usuario ja existe!");
				request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
			}else{
				usuarioNovo = new Usuario(nome, senha, nivel);
				dao.adicionar(usuarioNovo);
				usuarioNovo = dao.buscar(nome, senha);
	
				if (usuarioNovo != null) {
					request.setAttribute("msgCadastro", "Usuario " + usuarioNovo.getId() + " inserido!");
					request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
				} else {
					request.setAttribute("msgCadastro", "Erro ao cadastrar o usuario!");
					request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgCadastro", "Erro ao cadastrar o usuario!");
			request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);
		}
	}

}
