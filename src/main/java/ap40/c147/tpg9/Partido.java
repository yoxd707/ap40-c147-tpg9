package ap40.c147.tpg9;

/** Clase {@code Partido} que representa un partido.
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 */
public class Partido {

    private int id;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;


    /** Crea una instancia de la clase {@code Partido} con los datos especificados.
     * @param id Identificador único del partido.
     * @param equipo1 Instancia de la clase {@code Equipo} para el primer equipo del partido.
     * @param equipo2 Instancia de la clase {@code Equipo} para el segundo equipo del partido.
     * @param golesEquipo1 Cantidad de goles del equipo 1.
     * @param golesEquipo2 Cantidad de goles del equipo 2.
     * @throws IllegalArgumentException Se devolverá en los siguientes casos:
     *          <ul>
     *          <li>Si {@code equipo1} o {@code equipo2} son nulos.
     *          <li>Si {@code equipo1} y {@code equipo2} son iguales o la misma instancia.
     *          <li>Si {@code golesEquipo1} o {@code golesEquipo2} son menores a cero.
     *          </ul>
     * @see Equipo
     */
    public Partido(int id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) throws IllegalArgumentException {
        if (equipo1 == null || equipo2 == null)
            throw new IllegalArgumentException("Los parámetros equipo1 y equipo2 no pueden ser nulos.");

        if (equipo1.equals(equipo2))
            throw new IllegalArgumentException("Los parámetros equipo1 y equipo2 no pueden ser iguales o la misma instancia.");

        if (golesEquipo1 < 0 || golesEquipo2 < 0)
            throw new IllegalArgumentException("Los parámetros golesEquipo1 y golesEquipo2 no pueden ser menor a cero.");

        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }


    /**
     * @return Devuelve el identificador único del partido.
     */
    public int getId() {
        return id;
    }

    /**
     * @return Devuelve el equipo1 del partido.
     * @see Equipo
     */
    public Equipo getEquipo1() {
        return equipo1;
    }

    /**
     * @return Devuelve el equipo2 del partido.
     * @see Equipo
     */
    public Equipo getEquipo2() {
        return equipo2;
    }

    /**
     * @return Devuelve la cantidad de goles del equipo1.
     */
    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    /**
     * @return Devuelve la cantidad de goles del equipo2.
     */
    public int getGolesEquipo2() {
        return golesEquipo2;
    }


    /** Devuelve el resultado del equipo representado por el enum {@code ResultadoEnum}.
     * <ul>
     * <li> Si la cantidad de goles del {@code equipo1} es igual al del {@code equipo2}; entonces,
     * para ambos equipos el resultado será {@code ResultadoEnum.EMPATE}
     * <li> Si la cantidad de goles del {@code equipo1} es mayor al del {@code equipo2}; entonces,
     * el resultado para el {@code equipo1} será {@code ResultadoEnum.GANADOR} y para
     * el {@code equipo2} será {@code ResultadoEnum.PERDEDOR}
     * <li> Si la cantidad de goles del {@code equipo1} es menor al del {@code equipo2}; entonces,
     * el resultado para el {@code equipo1} será {@code ResultadoEnum.PERDEDOR} y para
     * el {@code equipo2} será {@code ResultadoEnum.GANADOR}
     * </ul>
     * 
     * @param equipo Instancia de la clase {@code Equipo} perteneciente al partido.
     * @return Devuelve un {@code ResultadoEnum} como resultado del equipo.
     * @throws IllegalArgumentException Se devolverá en caso de que el parámetro {@code equipo} no
     *          sea igual al {@code equipo1} o al {@code equipo2} del partido.
     * @see ResultadoEnum
     * @see Equipo
     */
    public ResultadoEnum resultado(Equipo equipo) throws IllegalArgumentException {
        boolean esEquipo1 = equipo1.equals(equipo);
        boolean esEquipo2 = equipo2.equals(equipo);

        // Si el equipo especificado no es igual al equipo1 o al equipo2, lanza una excepción.
        if (!esEquipo1 && !esEquipo2)
            throw new IllegalArgumentException("El parámetro equipo debe ser igual a equipo1 o equipo2.");

        if (golesEquipo1 == golesEquipo2)
            return ResultadoEnum.EMPATE;

        if (
            (golesEquipo1 > golesEquipo2 && esEquipo1) ||
            (golesEquipo2 > golesEquipo1 && esEquipo2)
        ) return ResultadoEnum.GANADOR;

        return ResultadoEnum.PERDEDOR;
    }


    @Override
    public boolean equals(Object obj) {
        // Si obj es nulo, o si la instancia no es de la clase Partido devuelve false.
        if (obj == null || !(obj instanceof Partido)) return false;

        Partido partido = (Partido)obj;
        return equals(partido);
    }


    /** Indica si algún otro partido es igual a este.
     * @param partido Instancia de la clase {@code Partido} a comparar.
     * @return Devuelve {@code true} si ambos partidos son iguales, {@code false} en caso contrario.
     * @see Partido
     */
    public boolean equals(Partido partido) {
        // Si partido es nulo devuelve false.
        if (partido == null) return false;

        // Si son la misma instancia devuelve true.
        if (partido == this) return true;

        // Devuelve true si todos sus atributos coinciden.
        return (
            id == partido.getId() &&
            equipo1.equals(partido.getEquipo1()) &&
            equipo2.equals(partido.getEquipo2()) &&
            golesEquipo1 == partido.getGolesEquipo1() &&
            golesEquipo2 == partido.getGolesEquipo2()
        );
    }

}
