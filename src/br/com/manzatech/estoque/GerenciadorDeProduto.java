package br.com.manzatech.estoque;

import java.util.List;

import br.com.manzatech.estoque.dao.ProdutoDao;

public class GerenciadorDeProduto {

	private ProdutoDao produtoDao;

	public void novoProduto(Produto produto) {
		System.out.println("Salvando o Produto");
		this.produtoDao.salvar(produto);
	}

	public List<Produto> getProdutos() {
		return produtoDao.listar();
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

}
