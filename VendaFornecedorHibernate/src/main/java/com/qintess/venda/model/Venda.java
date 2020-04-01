package com.qintess.venda.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private int clienteId;
	@Column(nullable = false)
	private int desconto;
	@Column(nullable = false)
	private int formaPagamento;
	@Column(nullable = false)
	private LocalDate data;

	@OneToMany (cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy = "venda",
			orphanRemoval = true)
	private List<VendaItens> listaItens = new ArrayList<>();

	public Venda() {}
	public Venda(int clienteId, int desconto, int formaPagamento, LocalDate data) {
		super();
		this.clienteId = clienteId;
		this.desconto = desconto;
		try {
			setFormaPagamento(formaPagamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getId() {
		return id;
	}

	public void addProdutos() {

	}

	public void addProduto(Produto produto, int quantidade) {
		VendaItens vi = new VendaItens();
		vi.setPrecoUnitario(produto.getPreco_venda());
		vi.setQuantidade(quantidade);
		for (FornecedorProduto fp : produto.getListaFornecedor()) {
			if (fp.getProduto() == produto) {
				vi.setPrecoCusto(fp.getPrecoCusto());
				break;
			}
		}
		vi.setProduto(produto);
		vi.setVenda(this);
		listaItens.add(vi);
	}

	public void removeProduto(Produto produto) {
		VendaItens vi = new VendaItens();
		for (VendaItens v : listaItens) {
			if(v.getProduto().equals(produto)) {
				vi = v;
				break;
			}
		}
		listaItens.remove(vi);
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public int getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(int formaPagamento) throws Exception {
		if ( formaPagamento > 0 && formaPagamento <= 3) {
			this.formaPagamento = formaPagamento;
		}else {
			throw new Exception("Forma de pagamento invalida");
		}
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<VendaItens> getListaItens() {
		return listaItens;
	}
	public void setListaItens(List<VendaItens> listaItens) {
		this.listaItens = listaItens;
	}	

}
