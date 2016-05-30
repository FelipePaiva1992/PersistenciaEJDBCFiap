package br.com.fiap.bean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@ManagedBean
@SessionScoped
public class UsuariosBean {

	private String usuario;
	private String senha;
	private Map<String, Object> sessionMap;

	public UsuariosBean() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		sessionMap = externalContext.getSessionMap();
	}

	public String validaUsuario() {
		try {
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
			Usuario usr = dao.buscar(usuario, senha);

			if (usr != null) {
				sessionMap.put("usuario_logado", usr);
				return "admin/menu";
			} else {
				return "erroAcesso";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "erroAcesso";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
