
package cat.itacademy.barcelonactiva.apellidos.nom.s04.t02.n01.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table (name = "fruta_table")
public class Fruta {

    @Id //primary key de la tabla.
    @GeneratedValue(strategy = GenerationType.AUTO)//incremento automatico del id
    private long Id;
    
     //automaticamente se asigna como varchar en la db
    String nombre;
    int cantKilos;

   public Fruta(){};
    
    public Fruta(String nombre, int cantKilos) {
        this.nombre = nombre;
        this.cantKilos = cantKilos;
    }
    
    
    
    
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantKilos() {
        return cantKilos;
    }

    public void setCantKilos(int cantKilos) {
        this.cantKilos = cantKilos;
    }
}
