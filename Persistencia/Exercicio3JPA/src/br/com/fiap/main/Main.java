package br.com.fiap.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MatMed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class Main {

	public static GenericDao<Agenda> dao;

	public static void main(String[] args) {
		try {
			dao = new GenericDao<>(Agenda.class);
			
			Agenda agenda = new Agenda();
			agenda.setData(Date.valueOf(LocalDate.now()));
			agenda.setHora(Date.valueOf(LocalDate.now()));
			agenda.setDescricao("Descrição de teste");
			
			Paciente paciente = new Paciente();
			paciente.setCpf("39707136847");
			paciente.setDataNasc(Date.valueOf(LocalDate.now()));
			paciente.setNome("Felipe Paiva");
			paciente.setTelefone("1143686923");

			agenda.getPacientes().add(paciente);
			
			paciente = new Paciente();
			paciente.setCpf("39707136848");
			paciente.setDataNasc(Date.valueOf(LocalDate.now()));
			paciente.setNome("Felipe Paiva2");
			paciente.setTelefone("1143686924");

			agenda.getPacientes().add(paciente);
			
			Procedimento procedimento = new Procedimento();
			procedimento.setDescicao("Procedimento de Teste");
			procedimento.setPreco(200.5);			

			paciente.getProcedimentos().add(procedimento);
			
			procedimento = new Procedimento();
			procedimento.setDescicao("Procedimento de Teste2");
			procedimento.setPreco(200.5);			

			paciente.getProcedimentos().add(procedimento);
			
			procedimento = new Procedimento();
			procedimento.setDescicao("Procedimento de Teste3");
			procedimento.setPreco(200.5);			

			paciente.getProcedimentos().add(procedimento);
			
			MatMed matMed = new MatMed();
			matMed.setDescricao("MatMed de teste");
			matMed.setFabricante("Fabrica fabricosa");
			matMed.setPreco(25.5);
			
			paciente.getMeds().add(matMed);
			
			matMed = new MatMed();
			matMed.setDescricao("MatMed de teste2");
			matMed.setFabricante("Fabrica fabricosa2");
			matMed.setPreco(25.5);
			
			paciente.getMeds().add(matMed);
						
			
			dao.adicionar(agenda);
			
			List<Agenda> agendas = dao.executarNamedQuery("Agenda.findAll");
			
			for(Agenda ag:agendas){
				System.out.println(ag);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}


}
