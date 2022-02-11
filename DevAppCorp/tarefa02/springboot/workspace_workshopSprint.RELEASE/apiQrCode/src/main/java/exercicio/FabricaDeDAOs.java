package exercicio;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FabricaDeDAOs
{	
	private static ResourceBundle prop;

	static
	{	try
		{	prop = ResourceBundle.getBundle("dao");
		}
		catch(MissingResourceException e)
		{	System.out.println("Aquivo dao.properties n�o encontrado.");
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T getDAO(Class<T> tipo)
	{			
		T dao = null;
		String nomeDaClasse = null; 
	
		try
		{	nomeDaClasse = prop.getString(tipo.getSimpleName());
			dao = (T) Class.forName(nomeDaClasse).newInstance();
		} 
		catch (InstantiationException e)  // se Instaciarmos uma Interface
		{	System.out.println("N�o foi poss�vel criar um objeto do tipo " + nomeDaClasse);
			throw new RuntimeException(e);
		} 
		catch (IllegalAccessException e)  // se o instanciarmos um construtor Private
		{	System.out.println("N�o foi poss�vel criar um objeto do tipo " + nomeDaClasse);
			throw new RuntimeException(e);
		} 
		catch (ClassNotFoundException e)  // Classe n�o encontrada
		{	System.out.println("Classe " + nomeDaClasse + " n�o encontrada");
			throw new RuntimeException(e);
		}
		catch(MissingResourceException e)  // Se o arquivo dao.properties n�o for encontrado e Nome com letra min�scula
		{	System.out.println("Chave " + tipo + " n�o encontrada em dao.properties");
			throw new RuntimeException(e);
		}
		
		return dao;
	}
}
