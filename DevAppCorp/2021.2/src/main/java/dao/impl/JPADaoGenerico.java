package dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.DaoGenerico;
import excecao.ObjetoNaoEncontradoException;
//Implementa��o do CRUD - DAO Generico

public class JPADaoGenerico<T, PK extends Serializable> implements DaoGenerico<T, PK> {
	private Class<T> tipo;
	
	@PersistenceContext
	protected EntityManager em; 
	
	public JPADaoGenerico(Class<T> tipo) {
		this.tipo = tipo;
	}
	public final T inclui(T o) {
		em.persist(o);
		return o;
	}

	public final void altera(T o) {
		em.merge(o);
	}

	public final void exclui(T o) {
		em.remove(o);
	}

	public final T getPorId(PK id) throws ObjetoNaoEncontradoException {
		T t = em.find(tipo, id);
		if (t == null) {
			throw new ObjetoNaoEncontradoException();
		}
		return t;
	}

	public final T getPorIdComLock(PK id) throws ObjetoNaoEncontradoException {
		T t = em.find(tipo, id, LockModeType.PESSIMISTIC_WRITE);

		if (t == null) {
			throw new ObjetoNaoEncontradoException();
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public final List<T> buscaLista(Method metodo, Object[] argumentos) {
		String nomeDaBusca = getNomeDaBuscaPeloMetodo(metodo);
		Query namedQuery = em.createNamedQuery(nomeDaBusca);

		if (argumentos != null) {
			for (int i = 0; i < argumentos.length; i++) {
				Object arg = argumentos[i];
				namedQuery.setParameter(i + 1, arg); // Par�metros de buscas s�o 1-based.
			}
		}
		return (List<T>) namedQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public final T busca(Method metodo, Object[] argumentos) throws ObjetoNaoEncontradoException {
		T t = null;
		try {
			String nomeDaBusca = getNomeDaBuscaPeloMetodo(metodo);
			Query namedQuery = em.createNamedQuery(nomeDaBusca);

			if (argumentos != null) {
				for (int i = 0; i < argumentos.length; i++) {
					Object arg = argumentos[i];
					namedQuery.setParameter(i + 1, arg); // Par�metros de buscas s�o 1-based.
				}
			}
			t = (T) namedQuery.getSingleResult();

			return t;
		} catch (NoResultException e) {
			throw new ObjetoNaoEncontradoException();
		}
	}


	@SuppressWarnings("unchecked")
	public final Set<T> buscaConjunto(Method metodo, Object[] argumentos) {
		String nomeDaBusca = getNomeDaBuscaPeloMetodo(metodo);
		Query namedQuery = em.createNamedQuery(nomeDaBusca);

		if (argumentos != null) {
			for (int i = 0; i < argumentos.length; i++) {
				Object arg = argumentos[i];
				namedQuery.setParameter(i + 1, arg); // Par�metros de buscas s�o 1-based.
			}
		}

		List<T> lista = namedQuery.getResultList();

		return new LinkedHashSet<T>(lista);
	}


	private String getNomeDaBuscaPeloMetodo(Method metodo) {
		return tipo.getSimpleName() + "." + metodo.getName();
	}
	
}
