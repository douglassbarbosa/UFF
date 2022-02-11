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
		/// UsuarioDAO.class é Objeto em memoria, que representa a classe Usuario. 
		//// método getDAO consulta o o arquivo dao.properties, identifica a interface UsuarioDAO e retorna um objeto do tipo UsuarioDAOImpl
		
		// System.out.println("\nVai criar o proxy de serviço");

		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

	    UsuarioAppService usuarioAppService = 
	    	(UsuarioAppService)fabrica.getBean ("usuarioAppService");

	    // System.out.println("\nCriou o proxy. Classe de implementação = " +
		// produtoAppService.getClass().getName());

		
		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um usuario");
			System.out.println("2. Alterar um usuario");
			System.out.println("3. Remover um usuario");
			System.out.println("4. Listar todos os usuarios");
			System.out.println("5. Sair");
						
			int opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");
					
			switch (opcao)
			{	case 1:
				{
					nome = Console.readLine('\n' + 
						"Informe o nome do Usuário: ");
					CPF = Console.readLine(
						"Informe o CPF (somente números): ");
					Senha = Console.readLine(
						"Informe uma senha de até 8 caractéres: ");
						
					umUsuario = new Usuario(nome, CPF, Senha);

					long numero = usuarioAppService.inclui(umUsuario);
					
					System.out.println('\n' + "Usuário número " + 
					    numero + " incluído com sucesso!");	

					break;
				}
				case 2:
				{	
					int resposta = Console.readInt('\n' + 
						"Digite o número do usuário que você deseja alterar: ");
										
					try {	
						umUsuario = usuarioAppService.recuperaUmUsuario(resposta);
					}
					catch(UsuarioNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
						"Número = " + umUsuario.getIdUsuario() + 
						"    Nome Usuário = " + umUsuario.getNome() +
						"    CPF do Perfil = " + umUsuario.getCpfUsuario() +
						"    Senha cadastrada = " + umUsuario.getSenhaUsuario() + 
						"    Data do cadastro = " + formatador.format(umUsuario.getDtCadastro())
						);
					//						"    Senha cadastrada = " + ((Integer.parseInt(umUsuario.getCpfUsuario())) != 0) + 

												
					System.out.println('\n' + "O que você deseja alterar?");
					System.out.println('\n' + "1. Nome");
					System.out.println("2. CPF");
					System.out.println("3. Senha");

					int opcaoAlteracao = Console.readInt('\n' + "Digite um número de 1 ou 2:");
					
					switch (opcaoAlteracao) {	
						case 1:
							String novoNome = Console.
										readLine("Digite o novo nome: ");
							
							umUsuario.setNome(novoNome);
							
							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Alteração de nome efetuada com sucesso!");
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)  /// ######## Exercício 3 
							{	System.out.println('\n' + "A operação não foi " +
							        "efetuada: os dados que você " +
							    	"tentou salvar foram modificados " +
							    	"por outro usuário.");
							}
							break;
					
						case 2:
							String novoCPF = Console.
									readLine("Informe o novo CPF: ");
							
							umUsuario.setCpfUsuario(novoCPF);

							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Alteração do CPF foi efetuada " +
									"com sucesso!");						
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)
							{	System.out.println('\n' + "A operação não foi " +
							        "efetuada: os dados que você " +
							    	"tentou salvar foram modificados " +
							    	"por outro usuário.");
							}
							break;
					
						case 3:
							String novaSenha = Console.
									readLine("Informe a nova senha: ");
							
							umUsuario.setSenhaUsuario(novaSenha);

							try {	
								usuarioAppService.altera(umUsuario);

								System.out.println('\n' + 
									"Alteração do CPF foi efetuada " +
									"com sucesso!");						
							}
							catch(UsuarioNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)
							{	System.out.println('\n' + "A operação não foi " +
							        "efetuada: os dados que você " +
							    	"tentou salvar foram modificados " +
							    	"por outro usuário.");
							}
							break;
							
						default:
							System.out.println('\n' + "Opção inválida!");
					}

					break;
				}

				case 3:
				{	
					int resposta = Console.readInt('\n' + 
						"Digite o número do usuário que você deseja remover: ");
									
					try {	
						umUsuario = usuarioAppService.recuperaUmUsuario(resposta);
					}
					catch(UsuarioNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
						break;
					}
										
					System.out.println('\n' + 
							"Número = " + umUsuario.getIdUsuario() + 
							"    Nome Usuário = " + umUsuario.getNome() +
							"    CPF do Perfil = " + umUsuario.getCpfUsuario() +
							"    Senha cadastrada = " + ((Integer.parseInt(umUsuario.getCpfUsuario())) != 0) + 
							"    Data do cadastro = " + formatador.format(umUsuario.getDtCadastro())
							);
														
					String resp = Console.readLine('\n' + 
						"Confirma a remoção do usuário?");

					if(resp.equals("s"))
					{	try
						{	usuarioAppService.exclui(umUsuario.getIdUsuario());
							System.out.println('\n' + 
								"Usuário removido com sucesso!");
						}
						catch(UsuarioNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
					}
					else
					{	System.out.println('\n' + 
							"Usuário não removido.");
					}
					
					break;
				}

				case 4:
				{	
					List<Usuario> usuarios = usuarioAppService.recuperaUsuarios();

					for (Usuario usuario : usuarios)
					{	
						System.out.println('\n' + 
								"  | Número = " + usuario.getIdUsuario() + 
								"  | Nome Usuário = " + usuario.getNome() +
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
					System.out.println('\n' + "Opção inválida!");
			}
		}		
	}
}
