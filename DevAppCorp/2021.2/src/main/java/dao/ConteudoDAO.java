package dao;

import java.util.List;

import anotacao.RecuperaLista;
import models.Conteudo;

public interface ConteudoDAO extends DaoGenerico<Conteudo, Long> {
	// Recupera lista de Usuarios
	@RecuperaLista
	List<Conteudo> recuperaConteudos();
}
