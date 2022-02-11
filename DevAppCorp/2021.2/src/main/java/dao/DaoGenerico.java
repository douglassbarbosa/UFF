package dao;

import java.io.Serializable;

import excecao.ObjetoNaoEncontradoException;

public interface DaoGenerico<T, PK extends Serializable> { 
	T inclui(T obj);

	void altera(T obj);

	void exclui(T obj);

	T getPorId(PK id) throws ObjetoNaoEncontradoException;

	T getPorIdComLock(PK id) throws ObjetoNaoEncontradoException;
}
