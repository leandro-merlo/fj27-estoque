package br.com.manzatech.estoque.dao;

import java.util.List;

import br.com.manzatech.estoque.Produto;

public interface ProdutoDao {

	
	void salvar(Produto produto);
	void alterar(Produto produto);
	List<Produto> listar();
	Produto buscarPorId(Long id);
}
