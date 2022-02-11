package excecao;

public class InfraestruturaException extends RuntimeException {
    private final static long serialVersionUID = 1;

    public InfraestruturaException(Exception e) {
	super(e);
    }
// add para atender no Interceptador
	public InfraestruturaException(String msg) {
		super(msg);
	}
}