package br.com.matheus.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.matheus.drogaria.dao.EstadoDao;
import br.com.matheus.drogaria.domain.Estado;
import br.com.matheus.drogaria.util.ConverteUtil;

@ManagedBean
@ViewScoped
public class EstadoBean {
	private Estado estado;
	private EstadoDao estadoDao;
	private List<Estado> estados;
	private List<Estado> estadosFiltrado;
	private String codigo;
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Estado> getEstadosFiltrado() {
		return estadosFiltrado;
	}

	public void setEstadosFiltrado(List<Estado> estadosFiltrado) {
		this.estadosFiltrado = estadosFiltrado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public EstadoDao getEstadoDao() {
		if (estadoDao == null) {
			estadoDao = new EstadoDao();
			return estadoDao;
		}
		return estadoDao;
	}

	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}

	
	@PostConstruct
	public void listar() {
	estados = getEstadoDao().listar();
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		estado.setSigla(ConverteUtil.sigla(estado.getSigla()));
		getEstadoDao().merge(estado);
		Messages.addFlashGlobalInfo("Salvo Estado:" + estado.getNome());
		estados = getEstadoDao().listar();
	}
	
	
	public void excluir(){
		findByID();
		getEstadoDao().excluir(estado);
		listar();
		Messages.addGlobalInfo("Apagado com sucesso: " + estado.getNome());
	}
	
	
	public void findByID(){
		estado = getEstadoDao().buscar(ConverteUtil.getId(codigo));
		System.out.println(estado.getCodigo());
	}
	
	
	
	
}
