package ar.com.ada.api.aladas.entities;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "staff")
public class staff extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="staff_id")
    private Integer staffId;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    
}
