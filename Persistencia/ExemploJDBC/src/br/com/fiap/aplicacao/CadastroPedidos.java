package br.com.fiap.aplicacao;

import javax.swing.JOptionPane;

import br.com.fiap.dao.ClientesDao;
import br.com.fiap.entity.Clientes;

public class CadastroPedidos {
	public static void main(String[] args) {
		
		//Buscando os clientes em uma lista
		ClientesDao dao = new ClientesDao();
		try {
			Clientes cliente = 
				(Clientes)JOptionPane.showInputDialog(
						null,
						"Selecione um cliente",
						"Clientes",
						JOptionPane.INFORMATION_MESSAGE,
						null, 
						dao.listarClientes().toArray(),
						null);
			
			if(cliente != null){
				
				
			}
			
			
			
		} catch (Exception e) {

		}
		
		
		
		
	}
}
