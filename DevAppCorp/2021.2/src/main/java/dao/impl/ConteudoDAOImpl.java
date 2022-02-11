package dao.impl;

import dao.ConteudoDAO;
import models.Conteudo;

public abstract class ConteudoDAOImpl extends JPADaoGenerico<Conteudo, Long> implements ConteudoDAO {

	public ConteudoDAOImpl() {
		super(Conteudo.class);
	}

}
