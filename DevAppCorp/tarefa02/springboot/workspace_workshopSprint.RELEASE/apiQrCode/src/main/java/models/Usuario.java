package models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.OrderBy;

import antlr.collections.List;

@Entity /// Identificar que é uma clásse imp no BD
/// mudando o nome da tabela
@Table(name="usuario")

public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;  
    private String cpfUsuario;  
    private String senhaUsuario;  
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCadastro;
    
    
    private List<QrCode> qrCodes = new ArrayList<QrCode>();

	public Usuario()
	{
	}


	public Usuario(String nome, String cpfUsuario, String senhaUsuario) {
		super();
		this.nome = nome;
		this.cpfUsuario = cpfUsuario;
		this.senhaUsuario = senhaUsuario;
	}


	


	//	 *********** Gets and Sets *************
	
	public Long getIdUsuario() {
		return id;
	}


	public void setIdUsuario(Long idUsuario) {
		this.id = idUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpfUsuario() {
		return cpfUsuario;
	}


	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}


	public String getSenhaUsuario() {
		return senhaUsuario;
	}


	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	public Date getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	// ********* Métodos para Associações ********* IMPLEMENTAR

		@OneToMany(mappedBy = "qrcode")
		@OrderBy
		
		public List<QrCode> getQrCodes() {
			return qrCodes;
		}

		public void setLances(List<QrCode> qrCodes) {
			this.qrCodes = qrCodes;
		}

}
