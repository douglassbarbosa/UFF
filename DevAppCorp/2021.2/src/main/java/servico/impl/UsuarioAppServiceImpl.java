package servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDAO;
import excecao.ObjetoNaoEncontradoException;
import excecao.UsuarioNaoEncontradoException;
import models.Usuario;
import servico.UsuarioAppService;

public class UsuarioAppServiceImpl implements UsuarioAppService {

	@Autowired
	private UsuarioDAO usuarioDAO; 

	@Transactional
	public long inclui(Usuario umUsuario) {
		usuarioDAO.inclui(umUsuario);
		return umUsuario.getId();
	}

	@Transactional 
	public void altera(Usuario umUsuario) throws UsuarioNaoEncontradoException {
		try {
			usuarioDAO.getPorIdComLock(umUsuario.getId());
			usuarioDAO.altera(umUsuario);
		} catch ( ObjetoNaoEncontradoException e) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
		}
	}

	@Transactional 
	public void exclui(long numero) throws UsuarioNaoEncontradoException {
		try {
			Usuario user = usuarioDAO.getPorIdComLock(numero); // tratar Usuario com tarefa ****************
			/* Necessário tratar as tarefas
			 * if(produto.getLances().size() > 0){
			 * 		throw new ProdutoNaoEncontradoException("Este produto possui lances e não pode ser removido");
			}
			 */
			usuarioDAO.exclui(user);
			
		} catch ( ObjetoNaoEncontradoException e) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
		}
	}

	
	//Tratar recuperar todos os Usuarios SEM TAREFAS e SEM CATEGORIA
	public List<Usuario> recuperaUsuarios() {
		return usuarioDAO.recuperaUsuarios();
	}
	
	
	public Usuario recuperaUmUsuario(long numero) throws UsuarioNaoEncontradoException { 
		try {
			return usuarioDAO.getPorId(numero);
		} catch (ObjetoNaoEncontradoException e) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
		}
	}
	
	public Usuario recuperaUmUsuarioEQrCodes(long numero) throws UsuarioNaoEncontradoException {
		try {
			return usuarioDAO.recuperaUmUsuarioEQrCodes(numero);
		} catch (ObjetoNaoEncontradoException e) {
			throw new UsuarioNaoEncontradoException("Usuario não encontrado");
		}
	}

	public List<Usuario> recuperaUsuariosEQrcodes() {
		System.out.println(usuarioDAO.getClass().getName() + " - " + usuarioDAO.getClass().hashCode());

		return usuarioDAO.recuperaListaUsuariosEQrCodes();
	}
	
	
}