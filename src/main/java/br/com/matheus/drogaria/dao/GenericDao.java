package br.com.matheus.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.matheus.drogaria.util.HibernateUtil;

public class GenericDao<Entidade> {

	private Class<Entidade> classe;

	
	public Class<Entidade> getClasse() {
		return classe;
	}
	
	public void setClasse(Class<Entidade> classe) {
		this.classe = classe;
	}//sua dao ta injetando a  classe corretamente, tá correto nehum erro no cosntrutor até onde vi
	
	@SuppressWarnings("unchecked")
	// recuperando a classe
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];//tava procurando essa 
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// pegando
																			// sessao
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();// passando a sessao com o
													// banco para transacao inicializa a pagina 
			sessao.save(entidade);// salvando a entidade
			transacao.commit();// executando o comando Hibernate
		} catch (RuntimeException e) {
			if (transacao != null)// verifica se transacao falhou
				transacao.rollback();

			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(classe);

			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();

			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();

			throw e;
		} finally {
			sessao.close();
		}
	}

	public Entidade buscar(Integer codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade resultado = null;
		try {
			resultado = sessao.find(classe, codigo);
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();//pegando sessao
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();//passando a sessao com o banco para transacao 
			sessao.merge(entidade);//salvando a entidade
			transacao.commit();//executando o comando Hibernate
		} catch (RuntimeException e) {
			if (transacao != null)//verifica se transacao falhou
				transacao.rollback();

			throw e;
		} finally {
			sessao.close();
		}
	}


}
