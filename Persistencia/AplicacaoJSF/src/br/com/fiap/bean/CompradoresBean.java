package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Comprador;
import br.com.fiap.entity.Livro;

@ManagedBean
@RequestScoped
public class CompradoresBean {
	
	private Comprador comprador;
	private Livro livro;
	private List<SelectItem> listaLivros;
	
	public CompradoresBean() {
		livro = new Livro();
		comprador = new Comprador();
		
		GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
		listaLivros = new ArrayList<>();
		for (Livro l : dao.listar()) {
			listaLivros.add(new SelectItem(l.getCodigo(), l.getTitulo()));
		}
	}
	
	public String incluirComprador() {
		try{
		GenericDao<Comprador> dao = new GenericDao<Comprador>(Comprador.class);
		livro.getCompradores().add(comprador);
		comprador.setLivro(livro);
		dao.adicionar(comprador);
		return "sucessoComprador";
		}catch(Exception e){
			e.printStackTrace();
			return "erroComprador";
		}
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<SelectItem> getListaLivros() {
		return this.listaLivros;
	}

	public void setListaLivros(List<SelectItem> listaLivros) {
		this.listaLivros = listaLivros;
	}
	
	

	
}