package servico;

import java.util.List;

import excecao.UsuarioNaoEncontradoException;
import models.Usuario;

public interface UsuarioAppService {
    long inclui(Usuario umUsuario);

    void altera(Usuario umUsuario) throws UsuarioNaoEncontradoException;

    void exclui(long idUsuario) throws UsuarioNaoEncontradoException;

    Usuario recuperaUmUsuario(long idUsuario) throws UsuarioNaoEncontradoException;
    
    Usuario recuperaUmUsuarioEQrCodes(long idUsuario) throws UsuarioNaoEncontradoException;
    
    List<Usuario> recuperaUsuarios();

    List<Usuario> recuperaUsuariosEQrcodes();
}
