package br.com.fiap.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Agenda.findAll", query = "select a from Agenda a")
public class Agenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "DATA")
	private Date data;

	@Column(name = "HORA")
	private Date hora;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AGENDA_PACIENTE", catalog = "medico", joinColumns = {
			@JoinColumn(name = "AGENDA_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PACIENTE_CPF", nullable = false, updatable = false) })
	private Set<Paciente> pacientes = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda " + this.getDescricao());
		for (Paciente pac : this.pacientes) {
			builder.append(" Paciente " + pac.getNome() + "(");

			for (Procedimento proc : pac.getProcedimentos()) {
				builder.append(" procedimento = " + proc.getDescicao());
			}

			for (MatMed mat : pac.getMeds()) {
				builder.append(" matmed = " + mat.getDescricao());
			}
			builder.append(" )");
		}
		return builder.toString();
	}
}
