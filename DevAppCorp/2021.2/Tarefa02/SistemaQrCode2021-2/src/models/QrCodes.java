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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Douglas
 */
public class QrCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQrCode;
    private String tituloProjeto;  
    private String imageQrCode; 
    private Date dtCriacao; 
    private Date data_ultimaModificacao; 

    public Long getIdQrCode() {
        return idQrCode;
    }

    public void setIdQrCode(Long idQrCode) {
        this.idQrCode = idQrCode;
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

    public Date getData_ultimaModificacao() {
        return data_ultimaModificacao;
    }

    public void setData_ultimaModificacao(Date data_ultimaModificacao) {
        this.data_ultimaModificacao = data_ultimaModificacao;
    }


    
}
