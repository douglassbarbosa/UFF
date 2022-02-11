package dao;

import java.util.List;

import excecao.UsuarioNaoEncontradoException;
import models.Usuario;

public interface UsuarioDAO
{	
	long inclui(Usuario umUsuario); 

	void altera(Usuario umUsuario)
		throws UsuarioNaoEncontradoException; 
	
	void exclui(long id) 
		throws UsuarioNaoEncontradoException; 
	
	Usuario recuperaUmUsuario(long numero) 
		throws UsuarioNaoEncontradoException; 
	
	List<Usuario> recuperaUsuarios();
}