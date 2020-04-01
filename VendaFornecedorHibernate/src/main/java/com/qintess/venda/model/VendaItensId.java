package com.qintess.venda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class VendaItensId implements Serializable {

	private static final long serialVersionUID = 1L;
	private int produtoId;
	private int vendaId;
	
	public VendaItensId() {}
	public VendaItensId(int produtoId, int vendaId) {
		super();
		this.produtoId = produtoId;
		this.vendaId = vendaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}
	public int getVendaId() {
		return vendaId;
	}
	public void setVendaId(int vendaId) {
		this.vendaId = vendaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(produtoId, vendaId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaItensId other = (VendaItensId) obj;
		return produtoId == other.produtoId && vendaId == other.vendaId;
	}
}
