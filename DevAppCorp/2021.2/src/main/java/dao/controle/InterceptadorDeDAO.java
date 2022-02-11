package dao.controle;

import java.lang.reflect.Method;

import anotacao.RecuperaConjunto;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import dao.impl.JPADaoGenerico;
import excecao.InfraestruturaException;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class InterceptadorDeDAO implements MethodInterceptor {

	@Override
	public Object intercept(Object objeto, Method metodo, Object[] args, MethodProxy metodoProxy) throws Throwable {
		
		// O s�mbolo ? representa um tipo desconhecido.
				JPADaoGenerico<?, ?> daoGenerico = (JPADaoGenerico<?, ?>) objeto;

				if (metodo.isAnnotationPresent(RecuperaLista.class)) {
					return daoGenerico.buscaLista(metodo, args);
				} else if (metodo.isAnnotationPresent(RecuperaConjunto.class)) {
					return daoGenerico.buscaConjunto(metodo, args);
				}  else if (metodo.isAnnotationPresent(RecuperaObjeto.class)) {
					return daoGenerico.busca(metodo, args);
				} else {
					throw new InfraestruturaException(
						"O m�todo " + metodo.getName() + " da classe " + metodo.getDeclaringClass() + " n�o foi anotado");
				}
	}
	


}
