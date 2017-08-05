package br.com.matheus.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain {

	@Column(nullable=false)
	private Short quantidade;
	@Column(nullable=false, precision=6, scale=2)
	private BigDecimal PrecoParcial;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Produto produto;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Venda venda;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoParcial() {
		return PrecoParcial;
	}

	public void setPrecoParcial(BigDecimal precoParcial) {
		PrecoParcial = precoParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
