package dao;

import java.util.List;

import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;
import models.QrCode;

//CRUD passa para DAO Genérico
public interface QrCodeDAO extends DaoGenerico<QrCode, Long> {	
	// Recupera lista de Usuarios
	@RecuperaLista
	List<QrCode> recuperaOsQrCodes();
	
	// Recuperar Um tarefa e Sua Categoria
	@RecuperaObjeto
	QrCode recuperaUmQrCodeEConteudos(long idQrCode) throws ObjetoNaoEncontradoException;
	
	// Recuperar ultima tarefa
	@RecuperaLista
	List<QrCode> recuperaQrCodesEConteudos();
	
}