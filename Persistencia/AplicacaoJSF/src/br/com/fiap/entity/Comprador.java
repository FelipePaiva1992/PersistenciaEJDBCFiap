package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="compradores")
public class Comprador {
	
	
	public Comprador() {
	}

	@Id
	@Column(name="CODIGO")
	private Integer codigo;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CODLIVRO")
	private Livro livro;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}

