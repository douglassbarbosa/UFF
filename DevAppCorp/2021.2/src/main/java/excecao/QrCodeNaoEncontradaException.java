package excecao;

public class QrCodeNaoEncontradaException extends Exception {
	private final static long serialVersionUID = 1;
	
	public QrCodeNaoEncontradaException(String msg)  {	
		super(msg);
	}

	public QrCodeNaoEncontradaException(int codigo, String msg) {	
		super(msg);
	}
}	