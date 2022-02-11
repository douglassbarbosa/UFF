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
@Table(name="conteudo")

public class Conteudo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tituloProjeto;  
    private String descricaoConteudo;  
    private String imgConteudo;  
    private String linkConteudo;  
    private int periodoConteudo;  
    private int ordemConteudo;  
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCadastro; 
    
    //private int idQrcode; 

	public Conteudo()
	{
	}

	public Conteudo(String tituloProjeto, String descricaoConteudo, String imgConteudo, String linkConteudo,
			int periodoConteudo, int ordemConteudo) {
		super();
		this.tituloProjeto = tituloProjeto;
		this.descricaoConteudo = descricaoConteudo;
		this.imgConteudo = imgConteudo;
		this.linkConteudo = linkConteudo;
		this.periodoConteudo = periodoConteudo;
		this.ordemConteudo = ordemConteudo;
	}


	public Long getId() {
		return id;
	}


	public String getTituloProjeto() {
		return tituloProjeto;
	}


	public String getDescricaoConteudo() {
		return descricaoConteudo;
	}


	public String getImgConteudo() {
		return imgConteudo;
	}


	public String getLinkConteudo() {
		return linkConteudo;
	}


	public int getPeriodoConteudo() {
		return periodoConteudo;
	}


	public int getOrdemConteudo() {
		return ordemConteudo;
	}


	public Date getDtCadastro() {
		return dtCadastro;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}


	public void setDescricaoConteudo(String descricaoConteudo) {
		this.descricaoConteudo = descricaoConteudo;
	}


	public void setImgConteudo(String imgConteudo) {
		this.imgConteudo = imgConteudo;
	}


	public void setLinkConteudo(String linkConteudo) {
		this.linkConteudo = linkConteudo;
	}


	public void setPeriodoConteudo(int periodoConteudo) {
		this.periodoConteudo = periodoConteudo;
	}


	public void setOrdemConteudo(int ordemConteudo) {
		this.ordemConteudo = ordemConteudo;
	}


	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	
	
}
