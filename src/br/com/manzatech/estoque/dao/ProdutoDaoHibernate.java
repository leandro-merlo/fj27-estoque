package br.com.manzatech.estoque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.manzatech.estoque.Produto;

@Repository
public class ProdutoDaoHibernate implements ProdutoDao {

	private Session session;

	@Autowired
	public ProdutoDaoHibernate(SessionFactory factory) {
	session = factory.openSession();
	}

	public List<Produto> listar() {
		@SuppressWarnings("unchecked")
		List<Produto> produtos = session.createQuery("from Produto").list();
		return produtos;
	}

	public void salvar(Produto produto) {
		session.save(produto);
	}

	public void alterar(Produto produto) {
		session.update(produto);
	}

	@Override
	public Produto buscarPorId(Long id) {
		return session.get(Produto.class, id);
	}

}
