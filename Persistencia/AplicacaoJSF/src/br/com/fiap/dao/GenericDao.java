package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Comprador;
import br.com.fiap.entity.Livro;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}

	@SuppressWarnings("unchecked")
	public T buscar(String nome, String senha) throws Exception {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("From " + classe.getSimpleName() + " WHERE usuario = :u and senha = :s");
			query.setParameter("u", nome);
			query.setParameter("s", senha);
			T entidade = (T) query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			return entidade;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T buscarNome(String nome) throws Exception {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("From " + classe.getSimpleName() + " WHERE titulo = :u");
		query.setParameter("u", nome);
		T entidade = (T) query.getSingleResult();
		em.getTransaction().commit();
		em.close();

		return entidade;
	}

	public List<Comprador> listarCompradores(Integer codigo) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("From Livro WHERE codigo = :c");
		query.setParameter("c", codigo);
		Livro livro = (Livro) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		List<Comprador> compradores = new ArrayList<>();
		compradores.addAll(livro.getCompradores());

		return compradores;
	}

}
