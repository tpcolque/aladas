package ar.com.ada.api.aladas.entities;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "staff")
public class Staff extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @NaturalId
    private String username;

    private String email;


    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuario.setStaff(this); //A este usuario setear este staff(this)
    }
   
    
}
