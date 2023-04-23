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
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var partido = new Partido(1, equipo1, equipo2, 0, 0);

        var resultadoEquipo1 = partido.resultado(equipo1);
        var resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.EMPATE, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.EMPATE, resultadoEquipo2);
    }

    @Test
    public void equipo1_deberiaSerGanador_equipo2_deberiaSerPerdedor() {
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var partido = new Partido(1, equipo1, equipo2, 1, 0);

        var resultadoEquipo1 = partido.resultado(equipo1);
        var resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.GANADOR, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.PERDEDOR, resultadoEquipo2);
    }

    @Test
    public void equipo1_deberiaSerPerdedor_equipo2_deberiaSerGanador() {
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var partido = new Partido(1, equipo1, equipo2, 0, 1);

        var resultadoEquipo1 = partido.resultado(equipo1);
        var resultadoEquipo2 = partido.resultado(equipo2);

        Assertions.assertEquals(ResultadoEnum.PERDEDOR, resultadoEquipo1);
        Assertions.assertEquals(ResultadoEnum.GANADOR, resultadoEquipo2);
    }

    @Test
    public void pasandoEquipoNoPerteneciente_deberiaLanzarExcepcion() {
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var equipo3 = new Equipo(2, "eq3", "");
        var partido = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> partido.resultado(equipo3));
    }

    @Test
    public void pasandoEquipoNulo_deberiaLanzarExcepcion() {
        var equipo1 = new Equipo(0, "eq1", "");
        var equipo2 = new Equipo(1, "eq2", "");
        var partido = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertThrows(NullPointerException.class, () -> partido.resultado(null));
    }

}
