package servico;

import java.util.List;

import excecao.UsuarioNaoEncontradoException;
import models.Usuario;

public interface UsuarioAppService {
    long inclui(Usuario umUsuario);

    void altera(Usuario umUsuario) throws UsuarioNaoEncontradoException;

    void exclui(long numero) throws UsuarioNaoEncontradoException;

    Usuario recuperaUmUsuario(long numero) throws UsuarioNaoEncontradoException;

    List<Usuario> recuperaUsuarios();

}
