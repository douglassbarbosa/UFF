package dao.impl;

import dao.UsuarioDAO;
import models.Usuario;

public abstract class UsuarioDAOImpl extends JPADaoGenerico<Usuario, Long> implements UsuarioDAO {	

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

}