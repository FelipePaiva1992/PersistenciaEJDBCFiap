package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ForumHelper {
	private EntityManager em;

	public ForumHelper(EntityManager em) {
		this.em = em;
	}

	public String salvarCliente(Clientes clientes)  throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(clientes);
			em.getTransaction().commit();
			return "Clientes salvo";
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public String salvarPedido(int idcliente, Pedidos pedidos) throws Exception{
		try {
			Clientes c = em.find(Clientes.class, idcliente);
			pedidos.setCliente(c);
			c.getPedidos().add(pedidos);
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return "Inclusao realizada";
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
}
