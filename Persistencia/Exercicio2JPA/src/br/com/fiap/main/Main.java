package br.com.fiap.main;

import java.sql.Date;
import java.time.LocalDate;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class Main {

	public static GenericDao<Clientes> dao;

	public static void main(String[] args) {
		try {
			dao = new GenericDao<>(Clientes.class);

			Clientes cliente = new Clientes();
			cliente.setEmail("spaiva.felipe@gmail.com");
			cliente.setNome("Felipe Paiva");

			Pedidos pedido = new Pedidos();
			pedido.setData(Date.valueOf(LocalDate.now()));
			pedido.setValor(2.30);
			pedido.setDescricao("Pedido de Teste");
			
			pedido.setCliente(cliente);
			cliente.getPedidos().add(pedido);

			salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void salvar(Clientes cliente) throws Exception{
		dao = new GenericDao<>(Clientes.class);
		dao.adicionar(cliente);
		System.out.println("Cliente e Pedido Salvo");
	}

}
