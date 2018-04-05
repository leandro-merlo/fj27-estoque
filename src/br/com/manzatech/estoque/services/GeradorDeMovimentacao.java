package br.com.manzatech.estoque.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.manzatech.estoque.Movimentacao;
import br.com.manzatech.estoque.Produto;
import br.com.manzatech.estoque.TipoMovimentacao;
import br.com.manzatech.estoque.dao.ProdutoDao;

@Service
public class GeradorDeMovimentacao {

	private final ProdutoDao dao;

	@Autowired
	public GeradorDeMovimentacao(ProdutoDao dao) {
		this.dao = dao;
	}

	public Movimentacao geraMovimentacao(Produto produto) {
		Movimentacao m = new Movimentacao();
		m.setData(Calendar.getInstance());
		m.setProduto(produto);
		Integer qtdAtual = dao.estoqueAtual(produto);
		
		if (produto.getQuantidade() > qtdAtual) {
			m.setTipo(TipoMovimentacao.ENTRADA);
		} else {
			m.setTipo(TipoMovimentacao.SAIDA);
		}
		m.setQuantidade(Math.abs(produto.getQuantidade() - qtdAtual));
		
		return m;
	}
	
}
