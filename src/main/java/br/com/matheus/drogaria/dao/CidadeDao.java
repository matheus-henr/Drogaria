package br.com.matheus.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.matheus.drogaria.domain.Cidade;
import br.com.matheus.drogaria.util.HibernateUtil;

public class CidadeDao extends GenericDao<Cidade> {

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstdo(Integer codigoCidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", codigoCidade));
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}
}
