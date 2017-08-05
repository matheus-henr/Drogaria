package br.com.matheus.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {
	@Column(length=80, nullable=false)
	private String descricao;
	@Column(nullable=false)
	private Short quantidade;
	@Column(nullable=false, precision=6, scale=2)
	private BigDecimal preço;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Fabricante fabricante;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Short getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreço() {
		return preço;
	}
	public void setPreço(BigDecimal preço) {
		this.preço = preço;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
