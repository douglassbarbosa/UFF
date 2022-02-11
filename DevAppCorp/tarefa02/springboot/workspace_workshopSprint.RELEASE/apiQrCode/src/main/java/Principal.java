import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.EstadoDeObjetoObsoletoException;
import excecao.UsuarioNaoEncontradoException;
import models.Usuario;
import servico.UsuarioAppService;

public class Principal
{	


public static void main (String[] args) 
	{	
		String nome;
		String CPF;
		String Senha;
		Usuario umUsuario;
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");


		///UsuarioDAO UsuarioDAO = FabricaDeDAOs.getDAO(UsuarioDAO.class);
		/// UsuarioDAO.class � Objeto em memoria, que representa a classe Usuario. 
		//// m�todo getDAO consulta o o arquivo dao.properties, identifica a interface UsuarioDAO e retorna um objeto do tipo UsuarioDAOImpl
		
		// System.out.println("\nVai criar o proxy de servi�o");

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	    UsuarioAppService usuarioAppService = 
	    	(UsuarioAppService)fabrica.getBean ("usuarioAppService");

	    // System.out.println("\nCriou o proxy. Classe de implementa��o = " +
		// produtoAppService.getClass().getName());

		
		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um usuario");
			System.out.println("2. Alterar um usuario");
			System.out.println("3. Remover um usuario");
			System.out.println("4. Listar todos os usuarios");
			System.out.println("5. Sair");
						
			int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 5:");
					
			switch (opcao)
			{	case 1:
				{
					nome = Console.readLine('\n' + 
						"Informe o nome do Usu�rio: ");
					CPF = Console.readLine(
						"Informe o CPF (somente n�meros): ");
					Senha = Console.readLine(
						"Informe uma senha de at� 8 caract�res: ");
						
					umUsuario = new Usuario(nome, CPF, Senha);

					long numero = usuarioAppService.inclui(umUsuario);
					
					System.out.println('\n' + "Usu�rio n�mero " + 
					    numero + " inclu�do com sucesso!");	

					break;
				}
				case 2:
				{	
					int resposta = Console.readInt('\n' + 
						"Digite o n�mero do usu�rio que voc� deseja alterar: ");
										
					try {	
						umUsuario = usuarioAppService.recuperaUmUsuario(resposta);
					}
					catch(UsuarioNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"N�mero = " + umUsuario.getIdUsuario() + 
						"    Nome Usu�rio = " + umUsuario.getNome() +
						"    CPF do Perfil = " + umUsuario.getCpfUsuario() +
						"    Senha cadastrada = " + umUsuario.getSenhaUsuario() + 
						"    Data do cadastro = " + formatador.format(umUsuario.getDtCadastro())
						);
					//						"    Senha cadastrada = " + ((Integer.parseInt(umUsuario.getCpfUsuario())) != 0) + 

												
					System.out.println('\n' + "O que voc� deseja alterar?");
					System.out.println('\n' + "1. Nome");
					System.out.println("2. CPF");
					System.out.println("3. Senha");

					int opcaoAlteracao = Console.readInt('\n' + "Digite um n�mero de 1 ou 2:");
					
					switch (opcaoAlteracao) {	
						case 1:
							String novoNome = Console.
										readLine("Digite o novo nome: ");
							
							umUsuario.setNome(novoNome);
							
							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Altera��o de nome efetuada com sucesso!");
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)  /// ######## Exerc�cio 3 
							{	System.out.println('\n' + "A opera��o n�o foi " +
							        "efetuada: os dados que voc� " +
							    	"tentou salvar foram modificados " +
							    	"por outro usu�rio.");
							}
							break;
					
						case 2:
							String novoCPF = Console.
									readLine("Informe o novo CPF: ");
							
							umUsuario.setCpfUsuario(novoCPF);

							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Altera��o do CPF foi efetuada " +
									"com sucesso!");						
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)
							{	System.out.println('\n' + "A opera��o n�o foi " +
							        "efetuada: os dados que voc� " +
							    	"tentou salvar foram modificados " +
							    	"por outro usu�rio.");
							}
							break;
					
						case 3:
							String novaSenha = Console.
									readLine("Informe a nova senha: ");
							
							umUsuario.setSenhaUsuario(novaSenha);

							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Altera��o do CPF foi efetuada " +
									"com sucesso!");						
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)
							{	System.out.println('\n' + "A opera��o n�o foi " +
							        "efetuada: os dados que voc� " +
							    	"tentou salvar foram modificados " +
							    	"por outro usu�rio.");
							}
							break;
							
						default:
							System.out.println('\n' + "Op��o inv�lida!");
					}

					break;
				}

				case 3:
				{	
					int resposta = Console.readInt('\n' + 
						"Digite o n�mero do usu�rio que voc� deseja remover: ");
									
					try {	
						umUsuario = usuarioAppService.recuperaUmUsuario(resposta);
					}
					catch(UsuarioNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
							"N�mero = " + umUsuario.getIdUsuario() + 
							"    Nome Usu�rio = " + umUsuario.getNome() +
							"    CPF do Perfil = " + umUsuario.getCpfUsuario() +
							"    Senha cadastrada = " + ((Integer.parseInt(umUsuario.getCpfUsuario())) != 0) + 
							"    Data do cadastro = " + formatador.format(umUsuario.getDtCadastro())
							);
														
					String resp = Console.readLine('\n' + 
						"Confirma a remo��o do usu�rio?");

					if(resp.equals("s"))
					{	try
						{	usuarioAppService.exclui(umUsuario.getIdUsuario());
							System.out.println('\n' + 
								"Usu�rio removido com sucesso!");
						}
						catch(UsuarioNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
					}
					else
					{	System.out.println('\n' + 
							"Usu�rio n�o removido.");
					}
					
					break;
				}

				case 4:
				{	
					List<Usuario> usuarios = usuarioAppService.recuperaUsuarios();

					for (Usuario usuario : usuarios)
					{	
						System.out.println('\n' + 
								"  | N�mero = " + usuario.getIdUsuario() + 
								"  | Nome Usu�rio = " + usuario.getNome() +
								"  | CPF do Perfil = " + usuario.getCpfUsuario() +
								"  | Senha cadastrada = " + usuario.getSenhaUsuario() + 
								"  | Data do cadastro = " + formatador.format(usuario.getDtCadastro()) 
								);
					}
					
					break;
				}

				case 5:
				{	continua = false;
					break;
				}

				default:
					System.out.println('\n' + "Op��o inv�lida!");
			}
		}		
	}
}
