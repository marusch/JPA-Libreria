
package libreria.entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Integer Id;
    
    @Column(name = "editorial_nombre", length = 100, nullable = false)
    private String nombreEd;
    
    @Column(name = "editorial_alta", nullable = false)
    private boolean alta;

    public Editorial(Integer Id, String nombreEd, boolean alta) {
        this.Id = Id;
        this.nombreEd = nombreEd;
        this.alta = alta;
    }

    public Editorial() {
    }

    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombreEd;
    }

    public void setNombre(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    
}
