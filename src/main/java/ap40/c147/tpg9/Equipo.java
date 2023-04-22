package ap40.c147.tpg9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/** Clase {@code Partido} que representa un partido.
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 */
@ToString
@Getter
@NonNull
@AllArgsConstructor
public class Equipo {

    /** Identificador único del equipo. */
    private final int id;
    /** Nombre del equipo. */
    private final String nombre;
    /** Descripción del equipo. */
    private final String descripcion;


    @Override
    public boolean equals(Object obj) {
        // Si obj es nulo, o si la instancia no es de la clase Equipo devuelve false.
        if (obj == null || !(obj instanceof Equipo)) return false;

        Equipo equipo = (Equipo)obj;
        return equals(equipo);
    }


    /** Indica si algún otro equipo es igual a este.
     * @param equipo Instancia de la clase {@code Equipo} a comparar.
     * @return Devuelve {@code true} si ambos equipos son iguales, {@code false} en caso contrario.
     * @see Partido
     */
    public boolean equals(Equipo equipo) {
        // Si equipo es nulo devuelve false.
        if (equipo == null) return false;

        // Si son la misma instancia devuelve true.
        if (equipo == this) return true;

        // Devuelve true si todos sus atributos coinciden.
        return (
            id == equipo.getId() &&
            nombre == equipo.getNombre() &&
            descripcion == equipo.getDescripcion()
        );
    }

}
