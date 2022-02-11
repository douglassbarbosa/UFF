package dao;

import java.util.List;

import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;
import models.Usuario;

//CRUD passa para DAO Gen�rico
public interface UsuarioDAO extends DaoGenerico<Usuario, Long> {	
	// Recupera lista S� COM Usuarios
	@RecuperaLista
	List<Usuario> recuperaUsuarios();
	
	//Recupera UM usu�rio e SUAS tarefas
	@RecuperaObjeto
	Usuario recuperaUmUsuarioEQrCodes(long numero) throws ObjetoNaoEncontradoException;

	// Recupera lista de TODOS Usuarios com suas Tarefas
	@RecuperaLista
	List<Usuario> recuperaListaUsuariosEQrCodes();
}