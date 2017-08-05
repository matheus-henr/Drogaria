package br.com.matheus.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.matheus.drogaria.dao.FabricanteDao;

import br.com.matheus.drogaria.domain.Fabricante;
import br.com.matheus.drogaria.util.ConverteUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	private FabricanteDao fabricanteDao;
	private String codigo;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void setFabricanteDao(FabricanteDao fabricantedao) {
		this.fabricanteDao = fabricantedao;
	}

	public FabricanteDao getFabricanteDao() {
		if (fabricanteDao == null) {
			fabricanteDao = new FabricanteDao();
			return fabricanteDao;
		}
		return fabricanteDao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@PostConstruct
	public void listar() {
		fabricantes = getFabricanteDao().listar();
	}

	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		getFabricanteDao().merge(fabricante);
		Messages.addFlashGlobalInfo("Fabricante Salvo:" + fabricante.getDescricao());
		fabricantes = getFabricanteDao().listar();
	}

	public void excluir() {
		findByID();
		getFabricanteDao().excluir(fabricante);
		listar();
		Messages.addGlobalInfo("Apagado com sucesso: " + fabricante.getDescricao());
	}

	public void findByID() {
		fabricante = getFabricanteDao().buscar(ConverteUtil.getId(codigo));

	}

}
