/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Douglas
 */
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConteudo;
    private String tituloProjeto;  
    private String descricaoConteudo; 
    private String imgConteudo;  
    private String linkConteudo;
    private int periodoConteudo;
    private int ordemConteudo;   
    private Date dtCriacao; 

    public Long getIdConteudo() {
        return idConteudo;
    }

    public void setIdConteudo(Long idConteudo) {
        this.idConteudo = idConteudo;
    }

    public String getTituloProjeto() {
        return tituloProjeto;
    }

    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public void setDescricaoConteudo(String descricaoConteudo) {
        this.descricaoConteudo = descricaoConteudo;
    }

    public String getImgConteudo() {
        return imgConteudo;
    }

    public void setImgConteudo(String imgConteudo) {
        this.imgConteudo = imgConteudo;
    }

    public String getLinkConteudo() {
        return linkConteudo;
    }

    public void setLinkConteudo(String linkConteudo) {
        this.linkConteudo = linkConteudo;
    }

    public int getPeriodoConteudo() {
        return periodoConteudo;
    }

    public void setPeriodoConteudo(int periodoConteudo) {
        this.periodoConteudo = periodoConteudo;
    }

    public int getOrdemConteudo() {
        return ordemConteudo;
    }

    public void setOrdemConteudo(int ordemConteudo) {
        this.ordemConteudo = ordemConteudo;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
    
    
}
