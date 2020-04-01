package com.qintess.venda.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class FornecedorProdutoId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer produtoId;
	private Integer fornecedorId;

	public FornecedorProdutoId() {}
	public FornecedorProdutoId(Integer produtoId, Integer fornecedorId) {
		this.produtoId = produtoId;
		this.fornecedorId = fornecedorId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}
	public Integer getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedorId, produtoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorProdutoId other = (FornecedorProdutoId) obj;
		return fornecedorId == other.fornecedorId && produtoId == other.produtoId;
	}

}
