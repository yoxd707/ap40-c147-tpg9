package ap40.c147.tpg9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Pruebas unitarias para los métodos {@code equals} de la clase {@code Partido}
 * @author Castaño Ulises.
 * @author ulises27.000@gmail.com
 * @see Partido
 */
public class PartidoEqualsTest {

    @Test
    public void pasandoObjeto_deberianSerIguales() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);
        Partido partido2 = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertEquals(partido1, partido2);
    }

    @Test
    public void pasandoPartido_deberianSerIguales() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);
        Partido partido2 = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertTrue(partido1.equals(partido2));
    }

    @Test
    public void pasandoObjeto_deberianSerDistintos() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);
        Partido partido2 = new Partido(2, equipo1, equipo2, 0, 0);

        Assertions.assertNotEquals(partido1, partido2);
    }

    @Test
    public void pasandoPartido_deberianSerDistintos() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);
        Partido partido2 = new Partido(2, equipo1, equipo2, 0, 0);

        Assertions.assertFalse(partido1.equals(partido2));
    }

    @Test
    public void pasandoNulo_deberianSerDistintos() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertNotEquals(partido1, null);
    }

    @Test
    public void pasandoObjetoDeDistintaClase_deberianSerDistintos() {
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido1 = new Partido(1, equipo1, equipo2, 0, 0);

        Assertions.assertNotEquals(equipo1, partido1);
    }

}
