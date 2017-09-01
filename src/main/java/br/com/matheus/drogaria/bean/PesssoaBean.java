package br.com.matheus.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.matheus.drogaria.dao.CidadeDao;
import br.com.matheus.drogaria.dao.EstadoDao;
import br.com.matheus.drogaria.dao.PessoaDao;
import br.com.matheus.drogaria.domain.Cidade;
import br.com.matheus.drogaria.domain.Estado;
import br.com.matheus.drogaria.domain.Pessoa;
import br.com.matheus.drogaria.util.ConverteUtil;

@SuppressWarnings("serial")
@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PesssoaBean implements Serializable {

	private Pessoa pessoa;
	private Estado estado;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;
	private PessoaDao pessoaDao;
	private String codigo;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public PessoaDao getPessoaDao() {
		if (pessoaDao == null) {
			pessoaDao = new PessoaDao();
			return pessoaDao;
		}
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@PostConstruct
	public void pupularTabela() {

		listar();

	}

	private void listar() {
		pessoas = getPessoaDao().listar();
	}

	public void novo() {
		pessoa = new Pessoa();
		listarEstado();
	}

	public void salvar() {
		getPessoaDao().salvar(pessoa);
		listar();
	}

	public void excluir() {
		findById();
		getPessoaDao().excluir(pessoa);
		listar();
	}

	public void findById() {
		pessoa = getPessoaDao().buscar(ConverteUtil.getId(codigo));
	}

	public void listarCidade() {
		CidadeDao dao = new CidadeDao();
		cidades = dao.listar();

	}

	public void listarEstado() {
		EstadoDao dao = new EstadoDao();
		estados = dao.listar();
	}

	public void listarCidadePorEstado() {
		if (estado != null) {
			CidadeDao dao = new CidadeDao();
			cidades = dao.buscarPorEstdo(estado.getCodigo());
		} else {
			cidades = null;
		}
	}
}
