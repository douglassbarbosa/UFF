package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Conteudo.recuperaConteudos", query = "select p from Conteudo p order by p.id"),
	@NamedQuery(name = "Conteudo.recuperaUmConteudo", query = "select p from Conteudo p where p.id = ?1 ")
	})


@Entity 				
@Table(name="conteudo") 
public class Conteudo {
	
	private Long id; // campo chave primaria, mas usamos L maiúsculo do tipo Class para ser Null enquanto for transiente.
	private String tituloConteudo;
	private String descricaoConteudo;
	private String imgConteudo;
	private String linkConteudo;

	private QrCode qrcode;
	
	
	
	// ********* Construtores *********

	public Conteudo()	{
	}

	public Conteudo(String tituloConteudo, String descricaoConteudo) {

		this.tituloConteudo = tituloConteudo;
		this.descricaoConteudo = descricaoConteudo;
	}
	public Conteudo(String tituloConteudo, String descricaoConteudo, String imgConteudo) {

		this.tituloConteudo = tituloConteudo;
		this.descricaoConteudo = descricaoConteudo;
		this.imgConteudo = imgConteudo;
	}
	public Conteudo(String tituloProjeto, String descricaoConteudo, String imgConteudo, String linkConteudo) {

		this.tituloConteudo = tituloProjeto;
		this.descricaoConteudo = descricaoConteudo;
		this.imgConteudo = imgConteudo;
		this.linkConteudo = linkConteudo;
	}

	public Conteudo(String tituloConteudo, String descricaoConteudo, String imgConteudo, String linkConteudo,
			QrCode qrcode) {

		this.tituloConteudo = tituloConteudo;
		this.descricaoConteudo = descricaoConteudo;
		this.imgConteudo = imgConteudo;
		this.linkConteudo = linkConteudo;
		this.qrcode = qrcode;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public String getTituloConteudo() {
		return tituloConteudo;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setTituloConteudo(String tituloConteudo) {
		this.tituloConteudo = tituloConteudo;
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

	
	// ********* Métodos para Associações *********

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idQrcode")
	public QrCode getQrCode() {
		return qrcode;
	}

	public void setQrCode(QrCode qrcode) {
		this.qrcode = qrcode;
	}
}
