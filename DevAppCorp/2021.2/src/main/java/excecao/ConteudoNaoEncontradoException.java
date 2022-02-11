package excecao;

public class ConteudoNaoEncontradoException extends Exception {
	private final static long serialVersionUID = 1;
	
	public ConteudoNaoEncontradoException(String msg)  {	
		super(msg);
	}

	public ConteudoNaoEncontradoException(int codigo, String msg) {	
		super(msg);
	}
}	