package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Usuario.recuperaUsuarios", query = "select p from Usuario p order by p.id"),
	@NamedQuery(name = "Usuario.recuperaUmUsuarioEQrCodes", query = "select p from Usuario p left outer join fetch p.qrCode where p.id = ?1"),
	@NamedQuery(name = "Usuario.recuperaListaUsuariosEQrCodes", query = "select distinct p from Usuario p left outer join fetch p.qrCode order by p.id asc")
	
	
	})
/*
 * @NamedQuery(name = "Usuario.recuperaListaDeProdutosELances", query = "select distinct p from Usuario p left outer join fetch p.lances order by p.id asc"),
	@NamedQuery(name = "Usuario.recuperaListaUsuariosETarefas", query = "select p from Usuario p left outer join fetch p.lances order by p.id asc"),
	@NamedQuery(name = "Usuario.recuperaPrimeiroProduto", query = "select p from Usuario p order by p.nome asc")
 */

@Entity 				 /// Identificar que é uma clásse imp no BD
@Table(name="usuario") 	/// mudando o nome da tabela

public class Usuario {

	private Long id; // campo chave primaria, mas usamos L maiúsculo do tipo Class para ser Null enquanto for transiente.
	private String nomeUsuario;
	private String cpfUsuario;
	private String senhaUsuario;
	private Date dtCadastro;
	
	private List<QrCode> qrcode = new ArrayList<QrCode>();

	// ********* Construtores *********

	public Usuario()	{
	}
	
	public Usuario(String nomeUsuario, String cpfUsuario, Date dtCadastro) {
		this.nomeUsuario = nomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.dtCadastro = dtCadastro;
	}

	public Usuario(String nomeUsuario, String cpfUsuario, String senhaUsuario, Date dtCadastro) {
		this.nomeUsuario = nomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.senhaUsuario = senhaUsuario;
		this.dtCadastro = dtCadastro;
	}

	
	
	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}



	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public String getCpfUsuario() {
		return cpfUsuario;
	}



	public String getSenhaUsuario() {
		return senhaUsuario;
	}



	public Date getDtCadastro() {
		return dtCadastro;
	}

	// *************** SETs ************************** //


	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}



	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}



	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


		
	// ********* Métodos para Associações *********
	@OneToMany(mappedBy = "usuario")
	@OrderBy
	public List<QrCode> getQrCode() {
		return qrcode;
	}
	public void setQrCode(List<QrCode> qrcode) {
		this.qrcode = qrcode;			
	}

}
