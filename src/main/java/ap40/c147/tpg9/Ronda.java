package ap40.c147.tpg9;

import ap40.c147.exceptions.RondaException;
import java.util.ArrayList;
import lombok.Getter;

/**
 * Clase que representa una ronda
 *
 * @author david
 */
@Getter
public class Ronda {

    // Identificador unico de la ronda
    private int id;
    // Numero de la ronda
    private String nro;
    // Lista de partidos de la ronda
    private ArrayList<Partido> partidos;

    public Ronda(int id, String nro, ArrayList<Partido> partidos) throws RondaException{

        if (id <= 0) {
            throw new RondaException("El id no puede ser un numero cero o menor a cero");
        }

        if (nro.isEmpty()) {
            throw new RondaException("El nro no puede estar vacio");
        }

        if (partidos == null) {
            throw new RondaException("La lista de partidos no puede ser nula");
        }

        this.id = id;
        this.nro = nro;
        this.partidos = partidos;
    }

}
