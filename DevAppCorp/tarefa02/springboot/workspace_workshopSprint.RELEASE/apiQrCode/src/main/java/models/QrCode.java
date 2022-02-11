package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity /// Identificar que é uma clásse imp no BD
/// mudando o nome da tabela
@Table(name="qrcode")
public class QrCode {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tituloProjeto;  
    private String imageQrCode;  
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCriacao;

    
    
	public QrCode() {
	}

	public QrCode(String tituloProjeto, String imageQrCode) {
		
		this.tituloProjeto = tituloProjeto;
		this.imageQrCode = imageQrCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloProjeto() {
		return tituloProjeto;
	}

	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}

	public String getImageQrCode() {
		return imageQrCode;
	}

	public void setImageQrCode(String imageQrCode) {
		this.imageQrCode = imageQrCode;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
    
    
}
