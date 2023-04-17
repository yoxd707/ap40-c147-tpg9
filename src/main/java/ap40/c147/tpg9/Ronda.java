package ap40.c147.tpg9;

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

    public Ronda(int id, String nro, ArrayList<Partido> partidos) {

        if (id <= 0) {
            // lanzar una excepcion
        }

        if (Integer.parseInt(nro) <= 0 || nro.isEmpty()) {
            // lanzar una excepcion
        }

        if (partidos == null) {
            // lanzar una excepcion
        }

        this.id = id;
        this.nro = nro;
        this.partidos = partidos;
    }

}
