package ap40.c147.tpg9;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author david
 */
@Setter
@Getter
public class Participante {

    private int id;
    private String nombre;

    public Participante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
