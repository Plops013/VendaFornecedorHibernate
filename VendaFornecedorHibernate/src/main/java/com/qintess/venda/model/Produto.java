package com.qintess.venda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(precision = 10, scale = 2, nullable = false)
	private double preco_venda;
	@Column(nullable = false)
	private short min_estoque;
	@Column(length = 45, nullable = false)
	private String nome;
	@Column(length = 45)
	private String foto;

	@OneToMany(fetch = FetchType.EAGER
			  ,mappedBy = "produto")
	List<FornecedorProduto> listaFornecedor = new ArrayList<>();

	public Produto() {}
	public Produto(double preco_venda, short min_estoque, String nome) {
		super();
		this.preco_venda = preco_venda;
		this.min_estoque = min_estoque;
		this.nome = nome;
	}
	public List<FornecedorProduto> getListaFornecedor() {
		return listaFornecedor;
	}
	public void setListaFornecedor(List<FornecedorProduto> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}
	public short getMin_estoque() {
		return min_estoque;
	}
	public void setMin_estoque(short min_estoque) {
		this.min_estoque = min_estoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foto, id, listaFornecedor, min_estoque, nome, preco_venda);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(foto, other.foto) && Objects.equals(id, other.id)
				&& Objects.equals(listaFornecedor, other.listaFornecedor) && min_estoque == other.min_estoque
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco_venda) == Double.doubleToLongBits(other.preco_venda);
	}


}
