package ar.com.ada.api.aladas.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer reservaId;

    @ManyToOne
    @JoinColumn(name = "vuelo_id", referencedColumnName = "vuelo_id")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", referencedColumnName = "pasajero_id")
    private Pasajero pasajero; // aca cambiamos el nombre pasajeroId porque queremos todo el objeto

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) { //Aca podria haber creado mi relacion bidireccional, porque un set asigna valor a un pasaje,con lo cual agregando la ultima linea pasaje.setReserva(this), tambien lo creo.
        this.pasaje = pasaje;
    }

    @Column(name = "estado_reserva_id")
    private Integer estadoReservaId;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pasaje pasaje; //linea 27, nombre del atributo que hace referencia a la tabla de donde viene

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Column(name = "fecha_Emision")
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public EstadoReservaEnum getEstadoReservaId() {
        return EstadoReservaEnum.parse(estadoReservaId);
    }

    public void setEstadoReservaId(EstadoReservaEnum estadoReservaId) {
        this.estadoReservaId = estadoReservaId.getValue();
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    
    public void asociarPasaje(Pasaje pasaje){ //relacion OneToOne
        this.setPasaje(pasaje);
        this.pasaje.setReserva(this);
    }

    public enum EstadoReservaEnum{
        CREADA(1), TRANSMITIENDO_AL_PG(2), ERROR_AL_CONECTAR_PG(3), PENDIENTE_DE_PAGO(4), PAGADO(5), CANCELADO_POR_USUARIO(6), CANCELADO_POR_EMPRESA(7), PAGO_RECHAZADO(8), EXPIRADO(9), EMITIDA(10);

        private final Integer value;

        private EstadoReservaEnum(Integer value){
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }

        public static EstadoReservaEnum parse(Integer id){
            EstadoReservaEnum status = null;
            for (EstadoReservaEnum item : EstadoReservaEnum.values()){
                if (item.getValue().equals(id)){
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}
