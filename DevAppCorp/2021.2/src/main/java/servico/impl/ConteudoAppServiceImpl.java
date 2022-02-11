package servico.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.ConteudoDAO;
import excecao.ConteudoNaoEncontradoException;
import excecao.ObjetoNaoEncontradoException;
import models.Conteudo;
import servico.ConteudoAppService;

public class ConteudoAppServiceImpl implements ConteudoAppService{

	@Autowired
	private ConteudoDAO conteudoDAO;
	
	@Transactional
	public long inclui(Conteudo umaConteudo) {
		
		@SuppressWarnings("unused")
		Conteudo conteudo = conteudoDAO.inclui(umaConteudo);
		return umaConteudo.getId();
	}


	@Transactional
	public void altera(Conteudo umaConteudo) throws ConteudoNaoEncontradoException {
		try {
			conteudoDAO.getPorIdComLock(umaConteudo.getId());
			conteudoDAO.altera(umaConteudo);
		} catch (ObjetoNaoEncontradoException e) {
			throw new ConteudoNaoEncontradoException("Conteudo não encontrada");
		}
	}

	@Transactional
	public void exclui(long idConteudo) throws ConteudoNaoEncontradoException {
		try {
			Conteudo umaConteudo = conteudoDAO.getPorIdComLock(idConteudo); // tratar Usuario com tarefa ****************
			
			conteudoDAO.exclui(umaConteudo);

		} catch (ObjetoNaoEncontradoException e) {
			throw new ConteudoNaoEncontradoException("Conteudo não encontrada");
		}
	}

	public Conteudo recuperaUmConteudo(long idConteudo) throws ConteudoNaoEncontradoException {
		try {
			return conteudoDAO.getPorId(idConteudo);
		} catch (ObjetoNaoEncontradoException e) {
			throw new ConteudoNaoEncontradoException("Conteudo não encontrada");
		}
	}

	// Listar todas as Conteudo no Banco
	public List<Conteudo> recuperaConteudos() {
		return conteudoDAO.recuperaConteudos();
	}


}
