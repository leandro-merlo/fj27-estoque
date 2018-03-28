package br.com.manzatech.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.manzatech.estoque.Produto;

@Component
public class ProdutoDaoMemoria implements ProdutoDao {

	private List<Produto> produtos = new ArrayList<>();

	public ProdutoDaoMemoria() {
		Produto p = new Produto();
		p.setId(1l);
		p.setQuantidade(10);
		p.setDescricao("Produto 1");
		salvar(p);
		
		p = new Produto();
		p.setId(2l);
		p.setQuantidade(20);
		p.setDescricao("Produto 2");
		salvar(p);
		
		p = new Produto();
		p.setId(3l);
		p.setQuantidade(30);
		p.setDescricao("Produto 3");
		salvar(p);
	}

	@Override
	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public void alterar(Produto produto) {
	}

	@Override
	public List<Produto> listar() {
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		return produtos.get(id.intValue() - 1);
	}

}
