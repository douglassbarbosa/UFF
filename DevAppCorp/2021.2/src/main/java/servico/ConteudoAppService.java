package servico;

import java.util.List;

import excecao.ConteudoNaoEncontradoException;
import models.Conteudo;

public interface ConteudoAppService {

	long inclui(Conteudo umConteudo);

	void altera(Conteudo umConteudo) throws ConteudoNaoEncontradoException;
	
	void exclui(long idConteudo) throws ConteudoNaoEncontradoException;

	Conteudo recuperaUmConteudo(long idConteudo) throws ConteudoNaoEncontradoException;
	
	List<Conteudo> recuperaConteudos();
}
