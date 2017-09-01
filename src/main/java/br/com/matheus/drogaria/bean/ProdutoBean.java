package br.com.matheus.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.matheus.drogaria.dao.FabricanteDao;
import br.com.matheus.drogaria.dao.ProdutoDao;
import br.com.matheus.drogaria.domain.Fabricante;
import br.com.matheus.drogaria.domain.Produto;
import br.com.matheus.drogaria.util.ConverteUtil;

@SuppressWarnings("serial")
@ManagedBean(name="produtoBean")
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	private ProdutoDao produtoDao;
	private List<Produto> listaProduto;
	private List<Fabricante> listaFabricante;
	private String codigo;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDao getProdutoDao() {
		if (produtoDao == null) {
			produtoDao = new ProdutoDao();
			return produtoDao;
		}
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}

	public void setListaFabricante(List<Fabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@PostConstruct
	public void carregarLista(){
		listar();
	}

	private void listar() {
		listaProduto = getProdutoDao().listar();
	}
	
	public void preparaNovo(){
		produto = new Produto();
	}
	
	public void salvar(){
		getProdutoDao().merge(produto);
		Messages.addGlobalInfo("Salvo Com Suceso");
		listar();
	}
	
	public void findById(){
		System.out.println("codigo e " + codigo);
		produto = getProdutoDao().buscar(ConverteUtil.getId(codigo));
	}
	
	public void exluir(){
		findById();
		getProdutoDao().excluir(produto);
		listar();
		Messages.addGlobalInfo("DELETADO");
	}
	
	public void listarFabricantes(){
		FabricanteDao dao = new FabricanteDao();
		listaFabricante = dao.listar();
	}

}
