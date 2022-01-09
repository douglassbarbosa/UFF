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
public class Periodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPeriodo;  
    private Date dtOn;    
    private Date dtOff;  
    private String horaOn; 
    private String horaOff; 
    private String tituloProjeto;  

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getDtOn() {
        return dtOn;
    }

    public void setDtOn(Date dtOn) {
        this.dtOn = dtOn;
    }

    public Date getDtOff() {
        return dtOff;
    }

    public void setDtOff(Date dtOff) {
        this.dtOff = dtOff;
    }

    public String getHoraOn() {
        return horaOn;
    }

    public void setHoraOn(String horaOn) {
        this.horaOn = horaOn;
    }

    public String getHoraOff() {
        return horaOff;
    }

    public void setHoraOff(String horaOff) {
        this.horaOff = horaOff;
    }

    public String getTituloProjeto() {
        return tituloProjeto;
    }

    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }
    
    
}
