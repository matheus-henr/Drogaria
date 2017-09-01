package br.com.matheus.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.matheus.drogaria.dao.CidadeDao;
import br.com.matheus.drogaria.dao.EstadoDao;
import br.com.matheus.drogaria.domain.Cidade;
import br.com.matheus.drogaria.domain.Estado;
import br.com.matheus.drogaria.util.ConverteUtil;





@SuppressWarnings("serial")
@ManagedBean(name="cidadeBean")
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private CidadeDao cidadeDao;
	private List<Estado> estados;
	private String codigo;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public CidadeDao getCidadeDao() {
		if(cidadeDao==null){
			cidadeDao = new CidadeDao();
			return cidadeDao;
		}
		return cidadeDao;
	}
	public void setCidadeDao(CidadeDao cidadeDao) {
		this.cidadeDao = cidadeDao;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	@PostConstruct
	public void listar() {
	cidades = getCidadeDao().listar();
	}
	
	public void novo(){
		
		cidade = new Cidade();
		
		listaEstados();
	}

	public void listaEstados() {
		EstadoDao dao = new EstadoDao();
		estados = dao.listar("nome");
	}
	
	public void salvar(){
		getCidadeDao().merge(cidade);
		Messages.addFlashGlobalInfo("Salvo");
		listar();
	}
	
	public void excluir() {
		findByID();
		getCidadeDao().excluir(cidade);
		listar();
		Messages.addGlobalInfo("Apagado com sucesso: " + cidade.getNome());
	}

	public void findByID() {
		cidade = getCidadeDao().buscar(ConverteUtil.getId(codigo));

	}
	

}
