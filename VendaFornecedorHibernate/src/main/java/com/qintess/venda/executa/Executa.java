package com.qintess.venda.executa;

import java.time.LocalDate;

import com.qintess.venda.dao.GenericDao;
import com.qintess.venda.model.Fornecedor;
import com.qintess.venda.model.Produto;
import com.qintess.venda.model.Venda;

public class Executa {

	public static void main(String[] args) {
		
		Fornecedor fornecedor = new Fornecedor("Distribuição", "(11)98172-5946", "distribuição@vendas.com");
		//preco de venda, estoqueMinimo, nome
		Produto produto = new Produto(250.00, (short) 0, "WebCam");
		Produto produto2 = new Produto(3500.50, (short) 0, "Play 5");
		//produto, estoque, preço de custo
		fornecedor.addProduto(produto, 50, 125.00);
		fornecedor.addProduto(produto2, 5, 2500.00);
		
		GenericDao<Fornecedor, Integer> fornecedorDao = new GenericDao<>(Fornecedor.class);
		fornecedor = fornecedorDao.persistir(fornecedor);

		GenericDao<Venda, Integer> vendaDao = new GenericDao<>(Venda.class);
		//id Cliente, desconto, formaPagamento, data
		Venda venda = new Venda(1, 10, 1, LocalDate.now());
		vendaDao.persistir(venda);

		GenericDao<Produto, Integer> prodDao = new GenericDao<Produto, Integer>(Produto.class);
		venda.addProduto(prodDao.encontrarPorId(2), 3);
		venda.addProduto(prodDao.encontrarPorId(3), 3);
		vendaDao.atualizar(venda);
		
	}
	
} 
