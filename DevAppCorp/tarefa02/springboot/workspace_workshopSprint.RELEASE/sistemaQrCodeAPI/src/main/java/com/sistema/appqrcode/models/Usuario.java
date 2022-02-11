package com.sistema.appqrcode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
    private String nome;  	
	
	@Column(nullable = false)
    private String tituloQrcode;  	
	
	@Column(nullable = false)
    private String imgQrcode;  	
	
	@Column(nullable = false)
    private String tituloConteudo;  	
	
	@Column(nullable = false)
    private String descricaoConteudo;  
	
	@Column(nullable = false)
    private String linkConteudo;
    
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    
	public Usuario() {
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario(String nome, String tituloQrcode, String imgQrcode, String tituloConteudo, String descricaoConteudo,
			String linkConteudo) {
		this.nome = nome;
		this.tituloQrcode = tituloQrcode;
		this.imgQrcode = imgQrcode;
		this.tituloConteudo = tituloConteudo;
		this.descricaoConteudo = descricaoConteudo;
		this.linkConteudo = linkConteudo;
	}

	/* GETs */
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTituloQrcode() {
		return tituloQrcode;
	}

	public String getImgQrcode() {
		return imgQrcode;
	}

	public String getTituloConteudo() {
		return tituloConteudo;
	}

	public String getDescricaoConteudo() {
		return descricaoConteudo;
	}

	public String getLinkConteudo() {
		return linkConteudo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTituloQrcode(String tituloQrcode) {
		this.tituloQrcode = tituloQrcode;
	}

	public void setImgQrcode(String imgQrcode) {
		this.imgQrcode = imgQrcode;
	}

	public void setTituloConteudo(String tituloConteudo) {
		this.tituloConteudo = tituloConteudo;
	}

	public void setDescricaoConteudo(String descricaoConteudo) {
		this.descricaoConteudo = descricaoConteudo;
	}

	public void setLinkConteudo(String linkConteudo) {
		this.linkConteudo = linkConteudo;
	}  
    
	
    
}
