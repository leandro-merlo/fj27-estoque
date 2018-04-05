package br.com.manzatech.estoque.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.manzatech.estoque.Produto;

@Transactional
@Repository
@Primary
public class ProdutoDaoHibernate implements ProdutoDao {

	private SessionFactory sessionFactory;

	@Autowired
	public ProdutoDaoHibernate(SessionFactory factory) {
		sessionFactory = factory;
	}

	public List<Produto> listar() {
		@SuppressWarnings("unchecked")
		List<Produto> produtos = sessionFactory.getCurrentSession().createQuery("from Produto").list();
		return produtos;
	}

	public void salvar(Produto produto) {
		sessionFactory.getCurrentSession().save(produto);
	}

	public void alterar(Produto produto) {
		sessionFactory.getCurrentSession().merge(produto);
	}

	@Override
	public Produto buscarPorId(Long id) {
		return sessionFactory.getCurrentSession().get(Produto.class, id);
	}

	@Override
	public Integer estoqueAtual(Produto produto) {
		Query query = sessionFactory.getCurrentSession().createQuery("select quantidade from Produto where id = :pid");
		query.setParameter("pid", produto.getId());
		return (Integer) query.getSingleResult();
	}

}
