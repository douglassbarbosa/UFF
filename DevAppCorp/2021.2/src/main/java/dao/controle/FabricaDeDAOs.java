package dao.controle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.impl.ConteudoDAOImpl;
import dao.impl.QrCodeDAOImpl;
import dao.impl.UsuarioDAOImpl;
import net.sf.cglib.proxy.Enhancer;

//A anotação @Configuration indica que esta classe possui um ou mais métodos anotados com @Bean.

@Configuration
public class FabricaDeDAOs
{	
	@Bean
	public static UsuarioDAOImpl getUsuarioDAO() throws Exception {
		return getDao(dao.impl.UsuarioDAOImpl.class);
	}
	
	@Bean
	public static QrCodeDAOImpl getQrCodeDAO() throws Exception {
		return getDao(dao.impl.QrCodeDAOImpl.class);
	}
	

	@Bean
	public static ConteudoDAOImpl getConteudoDAO() throws Exception {
		return getDao(dao.impl.ConteudoDAOImpl.class);
	}


	@SuppressWarnings("unchecked")
	public static <T> T getDao(Class<T> classeDoDao) throws Exception {
		return (T) Enhancer.create(classeDoDao, new InterceptadorDeDAO());
	}
}
