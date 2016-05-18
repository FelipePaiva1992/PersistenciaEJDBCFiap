package br.com.fiap.main;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.ForumHelper;

public class Main {

	public static ForumHelper dao;

	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
			EntityManager em = emf.createEntityManager();
			dao = new ForumHelper(em);

			Clientes cliente = new Clientes();
			cliente.setEmail("spaiva.felipe@gmail.com");
			cliente.setNome("Felipe Paiva");
			salvarCliente(cliente);

			Pedidos pedido = new Pedidos();
			pedido.setData(Date.valueOf(LocalDate.now()));
			pedido.setValor(2.30);
			pedido.setDescricao("Pedido de Teste");
			salvarPedido(cliente.getIdCliente(), pedido);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}

	public static void salvarCliente(Clientes cliente) throws Exception{
		dao.salvarCliente(cliente);
		System.out.println("Cliente Salvo");
	}

	public static void salvarPedido(int idCliente, Pedidos pedido) throws Exception {
		dao.salvarPedido(idCliente, pedido);
		System.out.println("Usuario Salvo");
	}

}
