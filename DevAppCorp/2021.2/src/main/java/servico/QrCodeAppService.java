package servico;

import java.util.List;

import excecao.QrCodeNaoEncontradaException;
import models.QrCode;

public interface QrCodeAppService {
    long inclui(QrCode idQrCode);

    void altera(QrCode idQrCode) throws QrCodeNaoEncontradaException;

    void exclui(long idQrCode) throws QrCodeNaoEncontradaException;

    QrCode recuperaUmQrCode(long idQrCode) throws QrCodeNaoEncontradaException;

    QrCode recuperaUmQrCodeEConteudos(long idQrCode) throws QrCodeNaoEncontradaException;
    
    List<QrCode> recuperaOsQrCodes();

    List<QrCode> recuperaQrCodesEConteudos();
}
