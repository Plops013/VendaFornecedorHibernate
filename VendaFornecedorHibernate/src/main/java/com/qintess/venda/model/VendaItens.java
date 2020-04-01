package com.qintess.venda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class VendaItens implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private VendaItensId id = new VendaItensId();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("produtoId")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("vendaId")
	private Venda venda;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private double precoCusto;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private double precoUnitario;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public VendaItensId getId() {
		return id;
	}
	public void setId(VendaItensId id) {
		this.id = id;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}
