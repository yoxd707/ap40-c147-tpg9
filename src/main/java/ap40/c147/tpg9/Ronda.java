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

    /**
     *
     * Constructor para crear una instancia de Ronda
     *
     * @param id identificador unico de la ronda. Debe ser un valor positivo
     * distinto de cero
     * @param nro numero de la ronda. No puede estar vacio
     * @param partidos lista de partidos asociados a la ronda. No puede ser nula
     * @throws ap40.c147.exceptions.RondaException si alguno de los argumentos
     * es nulo o invalido
     */
    public Ronda(int id, String nro, ArrayList<Partido> partidos) throws RondaException {

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

    /**
     *
     * Obtiene un partido de la lista de partidos de la ronda, dado su
     * identificador.
     *
     * @param partidoId identificador único del partido a buscar.
     * @return Partido encontrado o null si no se encuentra el partido con el
     * identificador dado.
     * @throws ap40.c147.exceptions.RondaException si alguno de los argumentos
     * es nulo o invalido
     */
    public Partido obtenerPartido(int partidoId) throws RondaException {

        if (partidoId <= 0) {
            throw new RondaException("El id no puede ser un numero cero o menor a cero");
        }

        Partido partidoBuscado = null;

        for (Partido partido : partidos) {
            if (partido.getId() == partidoId) {
                partidoBuscado = partido;
                break;
            }
        }

        return partidoBuscado;

    }

}
