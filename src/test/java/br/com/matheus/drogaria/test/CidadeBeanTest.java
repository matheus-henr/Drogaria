package br.com.matheus.drogaria.test;

import org.junit.Test;

import br.com.matheus.drogaria.dao.CidadeDao;
import br.com.matheus.drogaria.domain.Cidade;

public class CidadeBeanTest {
	@Test
	public void apagar(){
		CidadeDao dao = new CidadeDao();
		Cidade cidade = dao.buscar(6);
		
		dao.excluir(cidade);
		
		
	}
}
