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
@Table(name="periodo")

public class Periodo {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dtOn;  
    private String dtOff;  
    private String horaOn;  
    private String horaOff;  
    private String repeteDia;  
   // private int idConteudo;  
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCadastro;

	public Periodo()
	{
	}

	public Periodo(Long id, String dtOn, String dtOff, String horaOn, String horaOff, String repeteDia, Date dtCadastro) {
		super();
		this.id = id;
		this.dtOn = dtOn;
		this.dtOff = dtOff;
		this.horaOn = horaOn;
		this.horaOff = horaOff;
		this.repeteDia = repeteDia;
		this.dtCadastro = dtCadastro;
	}

	public Long getId() {
		return id;
	}

	public String getDtOn() {
		return dtOn;
	}

	public String getDtOff() {
		return dtOff;
	}

	public String getHoraOn() {
		return horaOn;
	}

	public String getHoraOff() {
		return horaOff;
	}

	public String getRepeteDia() {
		return repeteDia;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDtOn(String dtOn) {
		this.dtOn = dtOn;
	}

	public void setDtOff(String dtOff) {
		this.dtOff = dtOff;
	}

	public void setHoraOn(String horaOn) {
		this.horaOn = horaOn;
	}

	public void setHoraOff(String horaOff) {
		this.horaOff = horaOff;
	}

	public void setRepeteDia(String repeteDia) {
		this.repeteDia = repeteDia;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
}
