package ar.com.ada.api.aladas.entities;

import java.util.Date;

import javax.persistence.*;

import ar.com.ada.api.aladas.entities.Pais.PaisEnum;
import ar.com.ada.api.aladas.entities.Pais.PaisEnum.TipoDocuEnum;

@MappedSuperclass
public abstract class Persona {

    private String nombre;
    @Column(name = "tipo_documento_id")
    private Integer tipoDocumentoId;

    private String documento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "pais_id")
    private Integer paisId; // Este es enumerado, en java queda igual, cambia en getter/setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocuEnum getTipoDocumentoId() {
        return TipoDocuEnum.parse(this.tipoDocumentoId);
    }

    public void setTipoDocumentoId(TipoDocuEnum tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId.getValue();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public PaisEnum getPaisId() { // aca es alreves, se cambia paisId a PaisEnum y para que pueda asignarse se
                                  // pone la
        return PaisEnum.parse(paisId); // notacion PaisEnum.parse y entre parentesis el parametro.
    }

    public void setPaisId(PaisEnum paisId) {
        this.paisId = paisId.getValue(); // paisId es Integer del lado iz, por eso del lado derecho le pongo getValue()
        // y llama del enumerado a ese numero que despues lo asigna a paisId, lado izq.
    }

}
