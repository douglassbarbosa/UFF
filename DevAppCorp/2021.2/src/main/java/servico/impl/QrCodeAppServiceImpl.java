package servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.QrCodeDAO;
import excecao.ObjetoNaoEncontradoException;
import excecao.QrCodeNaoEncontradaException;
import models.QrCode;
import servico.QrCodeAppService;

public class QrCodeAppServiceImpl implements QrCodeAppService {

	
	@Autowired
	private QrCodeDAO qrcodeDAO;

	@Transactional
	public long inclui(QrCode umQrCode)  {
		
		QrCode qrcode = qrcodeDAO.inclui(umQrCode);
		
		return qrcode.getId();
	}
	
	@Transactional
	public void altera(QrCode umaQrCode) throws QrCodeNaoEncontradaException {
		try {
			qrcodeDAO.getPorIdComLock(umaQrCode.getId());
			qrcodeDAO.altera(umaQrCode);
		} catch (ObjetoNaoEncontradoException e) {
			throw new QrCodeNaoEncontradaException("QrCode não encontrada");
		}
	}

	@Transactional
	public void exclui(long idQrCode) throws QrCodeNaoEncontradaException {
		try {
			QrCode qrcode = qrcodeDAO.getPorIdComLock(idQrCode);  
		
			qrcodeDAO.exclui(qrcode);

		} catch (ObjetoNaoEncontradoException e) {
			throw new QrCodeNaoEncontradaException("QrCode não encontrada");
		}
	}

	public QrCode recuperaUmQrCode(long idQrCode) throws QrCodeNaoEncontradaException {
		try {
			return qrcodeDAO.getPorId(idQrCode);
		} catch (ObjetoNaoEncontradoException e) {
			throw new QrCodeNaoEncontradaException("QrCode não encontrada");
		}
	}

	public QrCode recuperaUmQrCodeEConteudos(long idQrCode) throws QrCodeNaoEncontradaException {
		try {
			return qrcodeDAO.recuperaUmQrCodeEConteudos(idQrCode);
		} catch (ObjetoNaoEncontradoException e) {
			throw new QrCodeNaoEncontradaException("QrCode não encontrada");
		}
	}


	// Listar todas os QrCodes no Banco
	public List<QrCode> recuperaOsQrCodes() {
		return qrcodeDAO.recuperaOsQrCodes();
	}

	public List<QrCode> recuperaQrCodesEConteudos() {
		System.out.println(qrcodeDAO.getClass().getName() + " - " + qrcodeDAO.getClass().hashCode());

		return qrcodeDAO.recuperaQrCodesEConteudos();
	}
	
	
}