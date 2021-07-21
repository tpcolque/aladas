package ar.com.ada.api.aladas.entities;

import java.util.ArrayList;
import java.util.*;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pasajero_id")
    private Integer pasajeroId;

    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //atributo con el que lo voy a relacion en el objeto reserva
    private List<Reserva> reservas = new ArrayList<>();

    public Integer getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId) {
        this.pasajeroId = pasajeroId;
    }
    public void agregarReserva(Reserva reserva){ //aca agrego el elemento con el cual estoy haciendo la relacion
        this.reservas.add(reserva); //esto agrega el objeto reserva a la lista, nos falta...
        reserva.setPasajero(this); //a la reserva la agrego a Pasajero y al poner this lo asigna a todo el objeto.
    }
}
