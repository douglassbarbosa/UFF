package dao.impl;

import dao.QrCodeDAO;
import models.QrCode;

public abstract class QrCodeDAOImpl extends JPADaoGenerico<QrCode, Long> implements QrCodeDAO {	

	public QrCodeDAOImpl() {
		super(QrCode.class);
	}

}