package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Clientes;

public class ClientesDao extends Dao {

	//método para incluir um novo cliente
	public void incluirCliente(Clientes cliente) throws Exception{
		try {
			abrirConexao();
			String sql = "INSERT INTO CLIENTES (NOME,EMAIL) VALUES (?,?)"; 
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	//método para retornar  um objeto com base no código (id)
	public Clientes buscarCliente(int id) throws Exception {
		Clientes cliente = null;
		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				cliente = new Clientes();
				cliente.setId(id);
				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return cliente;
	}
	
	public List<Clientes> listarClientes() throws Exception {
		List<Clientes> clientes = new ArrayList<Clientes>();
		
		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES");
			rs = stmt.executeQuery();
			while(rs.next()){
				Clientes c = new Clientes();
				c.setId(rs.getInt("ID"));
				c.setNome(rs.getString("NOME"));
				c.setEmail(rs.getString("EMAIL"));
				
				clientes.add(c);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		
		return clientes;
	}
	
}
