package models;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name = "QrCode.recuperaUmQrCode", query = "select p from QrCode p order by p.id"),
	@NamedQuery(name = "QrCode.recuperaUmQrCodeEConteudos", query = "select p from QrCode p left outer join fetch p.conteudo where p.id = ?1"),
	@NamedQuery(name = "QrCode.recuperaQrCodesEConteudos", query = "select distinct p from QrCode p left outer join fetch p.conteudo order by p.id asc")
	})


@Entity 				 
@Table(name="qrcode")
public class QrCode {
	
	private Long id; // campo chave primaria, mas usamos L maiúsculo do tipo Class para ser Null enquanto for transiente.
	private String tituloQrCode;
	private String imgQrCode;

	private Usuario usuario;


	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	
	public QrCode() {
		
	}
	
	public QrCode(String tituloQrCode, String imgQrCode) {
		this.tituloQrCode = tituloQrCode;
		this.imgQrCode = imgQrCode;
	}

	public QrCode(String tituloQrCode, String imgQrCode, Usuario usuario) {
		this.tituloQrCode = tituloQrCode;
		this.imgQrCode = imgQrCode;
		this.usuario = usuario;
	}

	
	public QrCode(String tituloQrCode, String imgQrCode, Usuario usuario, List<Conteudo> conteudos) {
		super();
		this.tituloQrCode = tituloQrCode;
		this.imgQrCode = imgQrCode;
		this.usuario = usuario;
		this.conteudos = conteudos;
	}

	// *********** Gets *********************//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public String getTituloQrCode() {
		return tituloQrCode;
	}

	public String getImgQrCode() {
		return imgQrCode;
	}
	
	// *************** SETs ************************** //

	public void setId(Long id) {
		this.id = id;
	}

	public void setTituloQrCode(String tituloQrCode) {
		this.tituloQrCode = tituloQrCode;
	}

	public void setImgQrCode(String imgQrCode) {
		this.imgQrCode = imgQrCode;
	}
	


	
	// ********* Métodos para Associações *********

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	// ****************************************************
	@OneToMany(mappedBy = "qrCode")
	@OrderBy	
	public List<Conteudo> getConteudo() {
		return conteudos;
	}
	public void setConteudo(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
}
