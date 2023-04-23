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
            () -> new Partido(1, 1,new Equipo(0, "eq1", ""), new Equipo(1, "eq2", ""), 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquiposIguales_deberiaLanzarExcepcion() {
        var equipo = new Equipo(0, "eq1", "");
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, 1,equipo, equipo, 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquipo1Nulo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            NullPointerException.class,
            () -> new Partido(1, 1,null, new Equipo(0, "eq1", ""), 0, 0)
        );
    }

    @Test
    public void constructor_pasandoEquipo2Nulo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            NullPointerException.class,
            () -> new Partido(1, 1,new Equipo(0, "eq1", ""), null, 0, 0)
        );
    }

    @Test
    public void constructor_pasandoGolesEquipo1Negativo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, 1,new Equipo(0, "eq1", ""), new Equipo(0, "eq2", ""), -1, 0)
        );
    }

    @Test
    public void constructor_pasandoGolesEquipo2Negativo_deberiaLanzarExcepcion() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Partido(1, 1,new Equipo(0, "eq1", ""), new Equipo(0, "eq2", ""), 0, -1)
        );
    }

    @Test
    public void propiedades_deberianSerCorrectas() {
        var id = 1;
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var golesEquipo1 = 2;
        var golesEquipo2 = 3;

        var partido = new Partido(id, 1,equipo1, equipo2, golesEquipo1, golesEquipo2);

        Assertions.assertEquals(id, partido.getId());
        Assertions.assertEquals(equipo1, partido.getEquipo1());
        Assertions.assertEquals(equipo2, partido.getEquipo2());
        Assertions.assertEquals(golesEquipo1, partido.getGolesEquipo1());
        Assertions.assertEquals(golesEquipo2, partido.getGolesEquipo2());
    }

}
