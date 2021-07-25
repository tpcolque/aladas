package ar.com.ada.api.aladas.entities;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    
    @Id
    @Column(name = "aeropuerto_id")
    private Integer aeropuertoID;

    public Integer getAeropuertoID() {
        return aeropuertoID;
    }

    public void setAeropuertoID(Integer aeropuertoID) {
        this.aeropuertoID = aeropuertoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    @Column(name = "nombre_aeropuerto")
    private String nombre;

    @Column(name = "codigo_Iata")
    private String codigoIATA;


}
