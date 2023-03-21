package ap40.c147.tpg9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Pruebas unitarias para el método {@code resultado} de la clase {@code Partido}
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 * @see Partido
 */
public class PartidoResultadoTest {

    @Test
    public void deberiaSerEmpate() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido = new Partido(1, equipo1, equipo2, 0, 0);

        ResultadoEnum resultadoEquipo1 = partido.resultado(equipo1);
        ResultadoEnum resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.EMPATE, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.EMPATE, resultadoEquipo2);
    }

    @Test
    public void equipo1_deberiaSerGanador_equipo2_deberiaSerPerdedor() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido = new Partido(1, equipo1, equipo2, 1, 0);

        ResultadoEnum resultadoEquipo1 = partido.resultado(equipo1);
        ResultadoEnum resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.GANADOR, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.PERDEDOR, resultadoEquipo2);
    }

    @Test
    public void equipo1_deberiaSerPerdedor_equipo2_deberiaSerGanador() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido = new Partido(1, equipo1, equipo2, 0, 1);

        ResultadoEnum resultadoEquipo1 = partido.resultado(equipo1);
        ResultadoEnum resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.PERDEDOR, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.GANADOR, resultadoEquipo2);
    }

    @Test
    public void pasandoEquipoNoPerteneciente_deberiaLanzarExcepcion() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Equipo equipo3 = new Equipo();
        Partido partido = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> partido.resultado(equipo3));
    }

    @Test
    public void pasandoEquipoNulo_deberiaLanzarExcepcion() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> partido.resultado(null));
    }

}
