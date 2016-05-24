package br.com.fiap.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Usuario;

@WebFilter("/admin/*")
public class FiltroAcesso implements Filter {

    public FiltroAcesso() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String servletContexto = req.getServletPath();
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		if(usuario != null || servletContexto.equals("/admin/valida")){
			chain.doFilter(request, response);			
		}else{
			request.setAttribute("msgValidacao", "Efetue o acesso para navegar!");
			request.getRequestDispatcher("../login.jsp").forward(request, response);
		}		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
