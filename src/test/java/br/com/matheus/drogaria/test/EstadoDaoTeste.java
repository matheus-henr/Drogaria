package br.com.matheus.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.matheus.drogaria.dao.EstadoDao;
import br.com.matheus.drogaria.domain.Estado;

public class EstadoDaoTeste {
	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDao dao = new EstadoDao();
		dao.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDao estadoDAO = new EstadoDao();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	@Test
	public void editar(){
		EstadoDao dao = new EstadoDao();
		Estado estado = dao.buscar(13);
		
		System.out.println(estado.getNome());
		System.out.println(estado.getSigla());
		
		estado.setNome("Matheus Henrique");
		estado.setSigla("MH");
		
		dao.merge(estado);
		
		 estado = dao.buscar(13);
		 
		System.out.println(estado.getNome());
		System.out.println(estado.getSigla());
		
	}
}
