package com.qintess.venda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class FornecedorProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FornecedorProdutoId id = new FornecedorProdutoId();
	
	@Column(name = "estoque"
			,nullable = false)
	private int estoque;

	@Column(precision = 10
			,scale = 2
			,nullable = false
			,name = "preco_custo")
	private double precoCusto;

	@ManyToOne(fetch = FetchType.LAZY
			,cascade = CascadeType.ALL)
	@MapsId("produtoId")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("fornecedorId")
	private Fornecedor fornecedor;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FornecedorProdutoId getId() {
		return id;
	}
	public void setId(FornecedorProdutoId id) {
		this.id = id;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
