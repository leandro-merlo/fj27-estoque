package br.com.manzatech.estoque.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.manzatech.estoque.Movimentacao;

@Repository
public class MovimentacaoDao {
	
	private SessionFactory factory;

	@Autowired
	public MovimentacaoDao(SessionFactory factory) {
		this.factory = factory;
	}

	public void salvar(Movimentacao movimentacao) {
		factory.getCurrentSession().save(movimentacao);
	}
}
