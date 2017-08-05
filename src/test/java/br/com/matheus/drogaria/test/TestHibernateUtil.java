package br.com.matheus.drogaria.test;

import org.hibernate.Session;
import org.junit.Test;

import br.com.matheus.drogaria.util.HibernateUtil;

public class TestHibernateUtil {

	@Test
	//@Ignore
	public void testaFabricaDeSessao(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
 
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
