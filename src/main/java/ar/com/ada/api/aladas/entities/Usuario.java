package ar.com.ada.api.aladas.entities;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId; // esto ya es un id con lo cual no tiene sentido ponerle @naturalid

    @NaturalId
    private String username;

    private String password;

    private String email;

    @Column(name = "fecha_login")
    private Date fechaLogin;

    @Column(name = "tipo_usuario")
    private Integer tipoUsuario;

    @OneToOne
    @JoinColumn(name = "pasajero_id", referencedColumnName = "pasajero_id")
    private Pasajero pasajero;

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staff;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(Date fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    public TipoUsusarioEnum getTipoUsuario() {
        return TipoUsusarioEnum.parse(this.tipoUsuario);
    }

    public void setTipoUsuario(TipoUsusarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario.getValue();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public enum TipoUsusarioEnum{
        STAFF(1), PASAJERO(2);
      
        private final Integer value;

        private TipoUsusarioEnum(Integer value){
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }
        public static TipoUsusarioEnum parse(Integer id){
            TipoUsusarioEnum status = null;
            for (TipoUsusarioEnum item : TipoUsusarioEnum.values()){
                if (item.getValue().equals(id)){
                    status = item;
                    break;
                }
            }
            return status;
        }
    
    }
}
// el mapped by la lleva la que tiene la PK y no la FK, la FK esta en usuarios
// aca no va el mappedby!!!!
