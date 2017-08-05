package br.com.matheus.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataCadrasto;
	@Column(nullable=false)
	private Boolean liberado;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Pessoa pessoa;

	public Date getDataCadrasto() {
		return dataCadrasto;
	}

	public void setDataCadrasto(Date dataCadrasto) {
		this.dataCadrasto = dataCadrasto;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
