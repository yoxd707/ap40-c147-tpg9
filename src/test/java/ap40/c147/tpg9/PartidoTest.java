package ap40.c147.tpg9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Pruebas unitarias para el constructor y las propiedades de la clase {@code Partido}
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 * @see Partido
 */
public class PartidoTest {

    @Test
    public void constructor_deberiaSerCorrecto() {
        Assertions.assertDoesNotThrow(
            () -> new Partido(1, new Equipo(), new Equipo(), 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquiposIguales_deberiaLanzarExcepcion() {
        Equipo equipo = new Equipo();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, equipo, equipo, 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquipo1Nulo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, null, new Equipo(), 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquipo2Nulo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, new Equipo(), null, 0, 0)
        );
    }

    @Test
    public void constructor_pasandoGolesEquipo1Negativo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, new Equipo(), new Equipo(), -1, 0)
        );
    }

    @Test
    public void constructor_pasandoGolesEquipo2Negativo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, new Equipo(), new Equipo(), 0, -1)
        );
    }

    @Test
    public void propiedades_deberianSerCorrectas() {
        int id = 1;
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        int golesEquipo1 = 2;
        int golesEquipo2 = 3;

        Partido partido = new Partido(id, equipo1, equipo2, golesEquipo1, golesEquipo2);

        Assertions.assertEquals(id, partido.getId());
        Assertions.assertEquals(equipo1, partido.getEquipo1());
        Assertions.assertEquals(equipo2, partido.getEquipo2());
        Assertions.assertEquals(golesEquipo1, partido.getGolesEquipo1());
        Assertions.assertEquals(golesEquipo2, partido.getGolesEquipo2());
    }

}
