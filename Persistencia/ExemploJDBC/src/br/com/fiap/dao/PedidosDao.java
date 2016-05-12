package br.com.fiap.dao;

import br.com.fiap.entity.Pedidos;

public class PedidosDao extends Dao {
	
	public void incluirPedido(Pedidos pedido) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, pedido.getIdCliente());
			stmt.setDate(2, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
}
