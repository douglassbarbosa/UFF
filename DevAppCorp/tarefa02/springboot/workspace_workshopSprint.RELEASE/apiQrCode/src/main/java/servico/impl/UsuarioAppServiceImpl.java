package servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDAO;
import excecao.UsuarioNaoEncontradoException;
import models.Usuario;
import servico.UsuarioAppService;

public class UsuarioAppServiceImpl implements UsuarioAppService {

	@Autowired
	private UsuarioDAO usuarioDAO; 

	@Transactional
	public long inclui(Usuario umUsuario) {
		return usuarioDAO.inclui(umUsuario);
	}

	@Transactional (rollbackFor={UsuarioNaoEncontradoException.class})
	public void altera(Usuario umUsuario) throws UsuarioNaoEncontradoException {
		usuarioDAO.altera(umUsuario);
	}

	@Transactional (rollbackFor={UsuarioNaoEncontradoException.class})
	public void exclui(long numero) throws UsuarioNaoEncontradoException {
		usuarioDAO.exclui(numero);
	}

	public Usuario recuperaUmUsuario(long numero) throws UsuarioNaoEncontradoException {
		return usuarioDAO.recuperaUmUsuario(numero);
	}

	public List<Usuario> recuperaUsuarios() {
			return usuarioDAO.recuperaUsuarios();
	}
}