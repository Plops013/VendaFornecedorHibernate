package com.qintess.venda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(length = 45, 
			name = "nome",
			nullable = false)
	private String nome;
	@Column(length = 45, 
			name = "telefone",
			nullable = false)
	private String telefone;
	@Column(length = 45, 
			name = "contato",
			nullable = false)
	private String contato;

	@OneToMany(cascade = CascadeType.ALL
			,fetch = FetchType.LAZY 
			,mappedBy = "fornecedor"
			,orphanRemoval = true)
	List<FornecedorProduto> listaProdutos = new ArrayList<>();

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addProduto(Produto produto, int estoque, double precoCusto) {
		FornecedorProduto fp = new FornecedorProduto();
		fp.setEstoque(estoque);
		fp.setFornecedor(this);
		fp.setProduto(produto);
		fp.setPrecoCusto(precoCusto);
		listaProdutos.add(fp);
	}

	public void removeProduto(Produto produto) {
		for (FornecedorProduto fpLista : listaProdutos) {
			if (fpLista.getProduto().equals(produto) && fpLista.getFornecedor().equals(this)) {
				listaProdutos.remove(fpLista);
				break;
			}
		}
	}

	public Fornecedor() {}
	public Fornecedor(String nome, String telefone, String contato) {
		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
	}
	public Fornecedor(Integer id, String nome, String telefone, String contato, List<FornecedorProduto> listaProdutos) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
		this.listaProdutos = listaProdutos;
	}

	public List<FornecedorProduto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<FornecedorProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

}
