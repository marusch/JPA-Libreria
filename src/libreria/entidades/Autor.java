package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Integer Id;
    
    @Column(name = "autor_nombre", length = 100, nullable = false)
    private String nombreAut;
    
    @Column(name = "autor_alta", nullable = false)
    private boolean alta;

    public Autor(Integer Id, String nombreAut, boolean alta) {
        this.Id = Id;
        this.nombreAut = nombreAut;
        this.alta = alta;
    }

    public Autor() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombreAut;
    }

    public void setNombre(String nombreAut) {
        this.nombreAut = nombreAut;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    
}
