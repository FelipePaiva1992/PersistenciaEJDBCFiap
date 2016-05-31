package br.com.fiap.bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Comprador;
import br.com.fiap.entity.Livro;

@ManagedBean
@SessionScoped
public class LivrosBean {
	private Livro livro;
	private Part figura;
	private List<SelectItem> listaLivros;
	
	

	public LivrosBean() {
		livro = new Livro();
		
		GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
		listaLivros = new ArrayList<>();
		for (Livro l : dao.listar()) {
			listaLivros.add(new SelectItem(l.getCodigo(), l.getTitulo()));
		}
		
		buscarCompradores();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Part getFigura() {
		return figura;
	}

	public void setFigura(Part figura) {
		this.figura = figura;
	}

	// método de ação (action), que retorna o redirecionamento
	// conforme o resultado da execução
	public String incluirLivro() {
		try {
			InputStream inputStream = figura.getInputStream();
			byte[] imagem = new byte[(int) figura.getSize()];

			inputStream.read(imagem, 0, (int) figura.getSize());
			livro.setImagem(imagem);
			GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
			dao.adicionar(livro);
			return "sucesso"; // dispatching para sucesso.xhtml
		} catch (Exception e) {
			return "erro"; // dispatching para erro.xhtml
		}
	}

	public List<Livro> getListaLivros() {
		GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
		return dao.listar();
	}

	private List<Comprador> listaCompradores = new ArrayList<Comprador>();

	public List<Comprador> getListaCompradores() {
		return listaCompradores;
	}

	public void setListaCompradores(List<Comprador> listaCompradores) {
		this.listaCompradores = listaCompradores;
	}

	public void buscarCompradores() {
		try {
			listaCompradores = new GenericDao<Comprador>(Comprador.class).listarCompradores(this.livro.getCodigo());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void setListaLivros(List<SelectItem> listaLivros) {
		this.listaLivros = listaLivros;
	}

	
	
	
}