package br.com.fiap.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.ForumHelper;

public class TesteForum {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		ForumHelper dao = new ForumHelper(em);
		Forum forum = new Forum();
		forum.setAssunto("JPA");
		forum.setDescricao("Java Persistence API");
		System.out.println(dao.salvar(forum));
		Usuario usuario = new Usuario();
		usuario.setNome("Joaquim");
		usuario.setEmail("joaquim@fiap.com.br");
		System.out.println(dao.adicionarUsuario(forum.getId(), usuario));
	}
}