package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.UsuarioDAO;
import excecao.UsuarioNaoEncontradoException;
import models.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {	

	@PersistenceContext
	private EntityManager em;
	
	public long inclui(Usuario umUsuario) {	
		em.persist(umUsuario);
		
		return umUsuario.getIdUsuario();
	}

	public void altera(Usuario umUsuario) throws UsuarioNaoEncontradoException {	
		Usuario usuario = em.find(Usuario.class, umUsuario.getIdUsuario(), LockModeType.PESSIMISTIC_WRITE);

		if(usuario == null) {
			throw new UsuarioNaoEncontradoException("Usuario não encontrado");
		}		
		em.merge(umUsuario);
	}

	@SuppressWarnings("deprecation")
	public void exclui(long numero) throws UsuarioNaoEncontradoException {
		Usuario usuario = em.find(Usuario.class, new Long(numero));  
		
		if(usuario == null)	{	
			throw new UsuarioNaoEncontradoException("Usuario não encontrado");
		}
 
		em.remove(usuario);
	}

	public Usuario recuperaUmUsuario(long numero) throws UsuarioNaoEncontradoException	{
		Usuario umUsuario = em.find(Usuario.class, numero);
		
		if(umUsuario == null) {	
			throw new UsuarioNaoEncontradoException("Usuario não encontrado");
		}
		return umUsuario;
	}

	public Usuario recuperaUmUsuarioComLock(long numero) throws UsuarioNaoEncontradoException {
		Usuario umUsuario = em.find(Usuario.class, numero, LockModeType.PESSIMISTIC_WRITE);
		
		if(umUsuario == null) {	
			throw new UsuarioNaoEncontradoException("Usuario não encontrado");
		}
		return umUsuario;
	}
	

	@SuppressWarnings("unchecked") //remover worn
	public List<Usuario> recuperaUsuarios()	{	
		List<Usuario> usuarios = em.createQuery("select p from Usuario p order by p.id").getResultList();
		
		return usuarios;
		
	}
}