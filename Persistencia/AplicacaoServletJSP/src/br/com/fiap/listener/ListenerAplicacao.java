package br.com.fiap.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerAplicacao implements ServletRequestAttributeListener, ServletContextListener, HttpSessionListener,
		HttpSessionAttributeListener {

	public ListenerAplicacao() {
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		gerarLog("Sessão criada");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo removido da sessão");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		gerarLog("Sessão destruida");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo adicionado na requisiçao");
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		gerarLog("Atributo atualizado na requisiçao");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo adicionado na sessão");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo removido na sessão");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		gerarLog("Atributo atualizado na sessão");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		gerarLog("Aplicação iniciada");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		gerarLog("Aplicação terminada");
	}

	private void gerarLog(String texto) {
		try (FileWriter fw = new FileWriter("D:/arquivos/log.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:SS")) + "] - "
					+ texto + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
