package br.com.fiap.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="livros")
public class Livro {
	
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	

	public Livro(Integer codigo, String titulo, String autor, Date dataPublicacao, double preco, byte[] imagem) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.preco = preco;
		this.imagem = imagem;
	}

	@Id
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="AUTOR")
	private String autor;
	
	@Column(name="DATAPUB")
	private Date dataPublicacao;
	
	@Column(name="PRECO")
	private double preco;
	
	@Lob
	@Column(name="IMAGEM")
	private byte[] imagem;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "livro")
	Set<Comprador> compradores = new HashSet<>();
	
	
	
	/*
	 * 	TINYBLOB => 255 Bytes
		BLOB => 64 Kilobytes
		MEDIUMBLOB => 16 Megabytes
		LONGBLOB => 4 Gigabits 
	 */

	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}


	public Set<Comprador> getCompradores() {
		return compradores;
	}


	public void setCompradores(Set<Comprador> compradores) {
		this.compradores = compradores;
	}


	
}

