package br.com.matheus.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.matheus.drogaria.dao.ClienteDao;
import br.com.matheus.drogaria.domain.Cliente;
import br.com.matheus.drogaria.domain.Pessoa;
import br.com.matheus.drogaria.util.ConverteUtil;

@SuppressWarnings("serial")
@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private ClienteDao clienteDao;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;
	private String codigo;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDao getClienteDao() {
		if (clienteDao == null) {
			clienteDao = new ClienteDao();
		}
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> cidades) {
		this.clientes = cidades;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@PostConstruct
	public void listaTabela() {
		clientes = getClienteDao().listar();
	}

	public void listar() {
		clientes = getClienteDao().listar();
	}
	
	public void findByID(){
		cliente = getClienteDao().buscar(ConverteUtil.getId(codigo));
	}
	
	
	public void salvar(){
		getClienteDao().merge(cliente);
		listar();
		Messages.addGlobalInfo("Salvo Com Sucesso");
	}
	
	public void excluir(){
		getClienteDao().excluir(cliente);
		listar();
		Messages.addGlobalInfo("DELETADO");
	}

}
