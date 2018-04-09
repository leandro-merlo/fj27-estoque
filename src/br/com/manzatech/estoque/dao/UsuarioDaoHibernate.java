package br.com.manzatech.estoque.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.manzatech.estoque.Usuario;

@Transactional
@Repository
public class UsuarioDaoHibernate implements UsuarioDao {

	private SessionFactory factory;

	@Autowired
	public UsuarioDaoHibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = new Usuario();
		u.setLogin(username);
		CriteriaBuilder cb = factory.getCriteriaBuilder();
		CriteriaQuery<Usuario> select = cb.createQuery(Usuario.class);
		Root<Usuario> from = select.from(Usuario.class);
		select.where(cb.equal(from.get("login"), username));
		Query query = factory.getCurrentSession().createQuery(select);
		Usuario result = (Usuario) query.getSingleResult();
		if (null != result) {
			return result;
		}
		return null;

	}

}
