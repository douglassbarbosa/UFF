import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import corejava.Console;
import excecao.ConteudoNaoEncontradoException;
import excecao.EstadoDeObjetoObsoletoException;
import excecao.QrCodeNaoEncontradaException;
import excecao.UsuarioNaoEncontradoException;
import models.Conteudo;
import models.QrCode;
import models.Usuario;
import servico.ConteudoAppService;
import servico.QrCodeAppService;
import servico.UsuarioAppService;
import util.Util;

public class PrincipalUsuario
{	

	public static void main (String[] args) 
	{	
		String nome;
		String cpfUsuario; 
		String dtCadastro;
		
		Usuario umUsuario;
		QrCode umQrCode;
		Conteudo umConteudo;


		@SuppressWarnings("resource")
		ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");

		UsuarioAppService usuarioAppService = 
				(UsuarioAppService)fabrica.getBean ("usuarioAppService"); //usuarioAppService

		QrCodeAppService qrcodeAppService = 
				(QrCodeAppService) fabrica.getBean ("qrcodeAppService");
		
		ConteudoAppService conteudoAppService = 
				(ConteudoAppService) fabrica.getBean ("conteudoAppService");


		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "O que você deseja fazer?");
		System.out.println('\n' + "1. Cadastrar um usuario");
		System.out.println("2. Alterar um usuario");
		System.out.println("3. Remover um usuario");
		System.out.println("4. Listar os usuarios");
		System.out.println("5. Listar um usuarios e seus QrCodes");
		System.out.println("6. Listar todos os usuarios e seus QrCodes");
		System.out.println("7. Alterar Conteúdo");
		System.out.println("8. Sair");

		int opcao = Console.readInt('\n' + 
				"Digite um número entre 1 e 7:");

		switch (opcao) {
		//	Inserir usuário NOVO e Já cria um Painel
		case 1:
		{
			// captura dados
			nome = Console.readLine('\n' + 
					"Informe o nome do Usuário: ");
			cpfUsuario = Console.readLine(
					"Informe o CPF: ");
			dtCadastro = new Date().toString();
			//Cria o usuário
			umUsuario = new Usuario(nome,cpfUsuario, Util.strToDate(dtCadastro));
			
			long numero = usuarioAppService.inclui(umUsuario);

			System.out.println('\n' + "Usuário número " + 
					numero + " incluído com sucesso!");	
			
			// Criou o Usuario
			//// Vamos criar seu QRCode
				long numTemp = -1;
				
				// captura dados
				String tituloProjeto= Console.readLine('\n' + 
						"Informe o nome do Usuário: ");
				String imgQrCode = "/localhost:NotFound/";
				
				umQrCode = new QrCode(tituloProjeto,imgQrCode,umUsuario);
				
				numTemp = qrcodeAppService.inclui(umQrCode);
				
				if (numTemp != -1) {
					System.out.println('\n' + "QrCode Criado com SUCESSO!");				
				}
				
				// Criou o Usuario
				//// Vamos criar seu QRCode
					long numTemp2 = -1;
					
					// captura dados
					String tituloConteudo= Console.readLine('\n' + 
							"Informe o Título do Conteúdo: ");
					String descricaoConteudo = Console.readLine('\n' + 
							"Informe a descrição: ");
					String imgConteudo = "/localhost:NotFound/";
					String linkConteudo = "www.google.com";
					
					umConteudo = new Conteudo(tituloConteudo,descricaoConteudo,imgConteudo,linkConteudo);
					
					numTemp2 = conteudoAppService.inclui(umConteudo);
					
					if (numTemp2 != -1) {
						System.out.println('\n' + "Painel do Usuário= " + umUsuario.getNomeUsuario()
							+ " incluído com sucesso!");				
					}
			
			break;
		}
			
		
		
		//	ALTERAR USUÁRIO   
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


			System.out.println('\n' + "Esse é o Usuário que vc selecionou" +
					" Número = " + umUsuario.getId() + 
					"  Nome = " + umUsuario.getNomeUsuario() +
					"  CPF  = " + umUsuario.getCpfUsuario()
					);

			System.out.println('\n' + "O que você deseja alterar?");
			System.out.println('\n' + "1. Nome");
			System.out.println("2. CPF");

			int opcaoAlteracao = Console.readInt('\n' + 
					"Digite um número de 1 ou 2:");

			switch (opcaoAlteracao) {	
			
			//	//	alterar NOME
			case 1:
				String novoNome = Console.
				readLine("Digite o novo nome: ");

				umUsuario.setNomeUsuario(novoNome);

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
			//	//	Alterar CPF
			case 2:
				String novoCpfUsuario = Console.
				readLine("Informe o CPF correto: ");

				umUsuario.setCpfUsuario(novoCpfUsuario);

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
		// EXCLUIR USUÁRIO 
		case 3:
		{	
			int resposta = Console.readInt('\n' + 
					"Digite o número do usuário que você deseja remover: ");

			try {	
				umUsuario = usuarioAppService.recuperaUmUsuarioEQrCodes(resposta);
			}
			catch(UsuarioNaoEncontradoException e)
			{	System.out.println('\n' + e.getMessage());
			break;
			}
			
			try {	
				umQrCode = qrcodeAppService.recuperaUmQrCodeEConteudos(umUsuario.getId());
				}
				catch(QrCodeNaoEncontradaException e)
				{	System.out.println('\n' + e.getMessage());
				break;
				}
			System.out.println('\n' + "Esse é o Usuário que vc selecionou" +
					" Número = " + umUsuario.getId() + 
					"  Nome = " + umUsuario.getNomeUsuario() +
					"  CPF  = " + umUsuario.getCpfUsuario()
					);
			
			String resp = Console.readLine('\n' + 
					"Confirma a remoção do usuário? s - sim ou n - não");

			if(resp.equals("s"))
			{	
				
				
				List<QrCode> qrcodes = umUsuario.getQrCode();
				for (QrCode qrcode : qrcodes)
				{
					try {
							List<Conteudo> conteudos = umQrCode.getConteudo();
							for (Conteudo conteudo : conteudos)
							{
								try {
									conteudoAppService.exclui(conteudo.getId());
								} catch (ConteudoNaoEncontradoException e) {
									System.out.println('\n' + e.getMessage());
									}		
							}
							
							qrcodeAppService.exclui(qrcode.getId());
					} catch (QrCodeNaoEncontradaException e) {
						System.out.println('\n' + e.getMessage());
						}		
				}
				
				
				try	{	
					usuarioAppService.exclui(umUsuario.getId());
					System.out.println('\n' + 
							"Usuário removido com sucesso!");
				}
				catch(UsuarioNaoEncontradoException e)
				{	
					System.out.println('\n' + e.getMessage());
				}
			}
			else
			{	System.out.println('\n' + 
					"Usuário não removido.");
			}

			break;
		}
		//	LISTAR TODOS UM USUARIOS
		case 4:
		{	
			List<Usuario> usuarios = usuarioAppService.recuperaUsuarios();

			if (usuarios.size() != 0) {
				System.out.println("");

				for (Usuario usuario : usuarios)
				{	
					System.out.println('\n' + "Esse é o Usuário que vc selecionou" +
							" Número = " + usuario.getId() + 
							"  Nome = "  + usuario.getNomeUsuario() +
							"  CPF  = "  + usuario.getCpfUsuario()
							);
				}
			} else {
				System.out.println('\n' + "Não há Usuários cadastrados.");
			}					
			break;
		}

		case 5:   /// Lista um Usuário e todas os seus QrCode
		{	
			long idUsuario = Console.readInt('\n' + "Informe o número do usuário: ");
			
			try {	
				umUsuario = usuarioAppService.recuperaUmUsuarioEQrCodes(idUsuario);
			}
			catch(UsuarioNaoEncontradoException e){	
				System.out.println('\n' + e.getMessage());
			break;
			}
			System.out.println('\n' + "Usuário: " +
					" Número = " + umUsuario.getId() + 
					"  Nome = " + umUsuario.getNomeUsuario() +
					"  CPF  = " + umUsuario.getCpfUsuario()
					);
			
			List<QrCode> qrcodes = umUsuario.getQrCode();				
			for (QrCode qrcode : qrcodes)
			{
				System.out.println('\n' + "QrCode: " +
						"|| Id = " + qrcode.getId() + " |" +
						"| Título = " + qrcode.getTituloQrCode() + " |" + 
						"| Descricao = " + qrcode.getImgQrCode() 
						);	
				try {	
					umQrCode = qrcodeAppService.recuperaUmQrCodeEConteudos(qrcode.getId());
					List<Conteudo> osConteudos = umQrCode.getConteudo();
					for (Conteudo oConteudo : osConteudos)
					{
						System.out.println('\n'  + "Conteúdo: "+ '\n' +
								"- ID = " 		 + oConteudo.getId() + " |" +
								"- Título = " 	 + oConteudo.getTituloConteudo() + " |" + 
								"- Descrição = " + oConteudo.getDescricaoConteudo() + " |" + 
								"- Imagem = " 	 + oConteudo.getImgConteudo() + " |" + 
								"- Link = " 	 + oConteudo.getLinkConteudo()
								);
					}
						
				}
				catch(QrCodeNaoEncontradaException e){	
					System.out.println('\n' + e.getMessage());
				break;
				}
			}	
						
			break;
		}
		
		//	LISTAR TODOS OS USUARIOS E Seus QrCodes
		case 6:
		{	
			List<Usuario> usuarios = usuarioAppService.recuperaUsuariosEQrcodes();

			if (usuarios.size() != 0) {
				System.out.println("");

				for (Usuario usuario : usuarios)
				{	
					System.out.println('\n' + "Esse é o Usuário que vc selecionou" +
							" Número = " + usuario.getId() + 
							"  Nome = "  + usuario.getNomeUsuario() +
							"  CPF  = "  + usuario.getCpfUsuario()
							);
					
					List<QrCode> qrcodes = usuario.getQrCode();				
					for (QrCode qrcode : qrcodes)
					{
						System.out.println('\n' + 
								"|| Id = " + qrcode.getId() + " |" +
								"| Título = " + qrcode.getTituloQrCode() + " |" + 
								"| Descricao = " + qrcode.getImgQrCode() 
								);					
					}
								
				}
			} else {
				System.out.println('\n' + "Não há Usuários cadastrados.");
			}
						
			break;
		}
		
			// ALTERAR UM CONTEUDO
			case 7:
			{
				// lista todos os conteudos disponíveis
				List<Conteudo> conteudos = conteudoAppService.recuperaConteudos();	
				for (Conteudo conteudo : conteudos)
				{
					System.out.println('\n'  + 
							"|| ID = " 		 + conteudo.getId() + " |" +
							"| Título = " 	 + conteudo.getTituloConteudo() + " |" + 
							"| Descrição = " + conteudo.getDescricaoConteudo() + " |" + 
							"| Imagem = " 	 + conteudo.getImgConteudo() + " |" + 
							"| Link = " 	 + conteudo.getLinkConteudo()
							);					
				}	
				
				long idConteudo = Console.readInt('\n' + "Informe o ID do conteúdo que deseja alterar: ");
				
				try {
					umConteudo = conteudoAppService.recuperaUmConteudo(idConteudo);
					System.out.println('\n'  + "Você selecionou o seguinte conteúdo: "+ '\n' +
							"|| ID = " 		 + umConteudo.getId() + " |" +
							"| Título = " 	 + umConteudo.getTituloConteudo() + " |" + 
							"| Descrição = " + umConteudo.getDescricaoConteudo() + " |" + 
							"| Imagem = " 	 + umConteudo.getImgConteudo() + " |" + 
							"| Link = " 	 + umConteudo.getLinkConteudo()
							);	
				} catch (ConteudoNaoEncontradoException e) {
					System.out.println('\n' + e.getMessage());
				}		
				
				System.out.println('\n' + "O que você deseja alterar?");
				System.out.println('\n' + "1. Título");
				System.out.println("2. Descrição");
				System.out.println("3. Imagem");
				System.out.println("4. Link");

				int opcaoAlteracao = Console.readInt('\n' + 
						"Digite um número de 1 a 4:");

				switch (opcaoAlteracao) {	
				
				//	//	alterar Título
				case 1:
					try {
						umConteudo = conteudoAppService.recuperaUmConteudo(idConteudo);
						String novoTitulo = Console.
								readLine("Digite o novo Título: ");
						
						umConteudo.setTituloConteudo(novoTitulo);
						
						try {	
							conteudoAppService.altera(umConteudo);
	
							System.out.println('\n' + 
									"Alteração de Título efetuada com sucesso!");
						}
						catch(ConteudoNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
						catch(EstadoDeObjetoObsoletoException e)  /// ######## Exercício 3 
						{	System.out.println('\n' + "A operação não foi " +
								"efetuada: os dados que você " +
								"tentou salvar foram modificados " +
								"por outro usuário.");
						}
					} catch (ConteudoNaoEncontradoException e) {
						System.out.println('\n' + e.getMessage());
					}
					break;
				//	//	Alterar Descrição
				case 2:
					try {
						umConteudo = conteudoAppService.recuperaUmConteudo(idConteudo);
						String descricaoConteudo = Console.readLine("digite a nova descrição: ");
	
						umConteudo.setDescricaoConteudo(descricaoConteudo);
							
						try {	
							conteudoAppService.altera(umConteudo);
	
							System.out.println('\n' + 
									"Descrição alterada " +
									"com sucesso!");						
						} catch(ConteudoNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
						catch(EstadoDeObjetoObsoletoException e)
						{	System.out.println('\n' + "A operação não foi " +
								"efetuada: os dados que você " +
								"tentou salvar foram modificados " +
								"por outro usuário.");
						}
					} catch(ConteudoNaoEncontradoException e)
					{	System.out.println('\n' + e.getMessage());
					}
					break;		
					
					//	//	Alterar Imagem
					case 3:
						try {
							umConteudo = conteudoAppService.recuperaUmConteudo(idConteudo);
							String imagemNova = Console.readLine("Insira a nova imagem: ");
		
							umConteudo.setImgConteudo(imagemNova);
								
							try {	
								conteudoAppService.altera(umConteudo);
		
								System.out.println('\n' + 
										"Imagem alterada " +
										"com sucesso!");						
							} catch(ConteudoNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							catch(EstadoDeObjetoObsoletoException e)
							{	System.out.println('\n' + "A operação não foi " +
									"efetuada: os dados que você " +
									"tentou salvar foram modificados " +
									"por outro usuário.");
							}
						} catch(ConteudoNaoEncontradoException e)
						{	System.out.println('\n' + e.getMessage());
						}
						break;
						
						
						//	//	Alterar Link
						case 4:
							try {
								umConteudo = conteudoAppService.recuperaUmConteudo(idConteudo);
								String linkNovo = Console.readLine("Infome o novo link: ");
			
								umConteudo.setLinkConteudo(linkNovo);
									
								try {	
									conteudoAppService.altera(umConteudo);
			
									System.out.println('\n' + 
											"Link alterado" +
											"com sucesso!");						
								} catch(ConteudoNaoEncontradoException e)
								{	System.out.println('\n' + e.getMessage());
								}
								catch(EstadoDeObjetoObsoletoException e)
								{	System.out.println('\n' + "A operação não foi " +
										"efetuada: os dados que você " +
										"tentou salvar foram modificados " +
										"por outro usuário.");
								}
							} catch(ConteudoNaoEncontradoException e)
							{	System.out.println('\n' + e.getMessage());
							}
							break;
				default:
					System.out.println('\n' + "Opção inválida!");
				}

				break;
			}
			
			
		case 8:
		{	continua = false;
		break;
		}

		default:
			System.out.println('\n' + "Opção inválida!");
		}
		}		
	}
}
