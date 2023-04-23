package ap40.c147.tpg9;

import ap40.c147.exceptions.RondaException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author david
 */
public class RondaTest {

    @Test
    public void constructorRondaCorrecto() throws RondaException {

        Map<Integer, Partido> partidos = new LinkedHashMap<>();
        Ronda ronda = new Ronda(1, "Ronda 1", partidos);

        Assertions.assertEquals(1, ronda.getId());
        Assertions.assertEquals("Ronda 1", ronda.getNro());
        Assertions.assertEquals(partidos, ronda.getPartidos());

    }

    @Test
    public void constructorRondaIncorrecto() {

        Map<Integer, Partido> partidos = new LinkedHashMap<>();

        Assertions.assertThrows(RondaException.class, () -> new Ronda(0, "Ronda 1", partidos));
        Assertions.assertThrows(RondaException.class, () -> new Ronda(1, "", partidos));
        Assertions.assertThrows(RondaException.class, () -> new Ronda(0, "Ronda 1", null));
    }

    @Test
    public void obtenerPartidoEncuentraPartido() throws RondaException {

        Equipo equipo1 = new Equipo(0, "eq1", "");
        Equipo equipo2 = new Equipo(1, "eq2", "");
        Partido partido = new Partido(1, 1, equipo1, equipo2, 2, 0);

        Map<Integer, Partido> partidos = new LinkedHashMap<>();

        partidos.put(1,partido);

        Ronda ronda = new Ronda(1, "Numero 1", partidos);

        Partido partidoEncontrado = ronda.obtenerPartido(1);

        Assertions.assertNotNull(partidoEncontrado);

    }

    @Test
    public void obtenerPartidoNoEncuentraPartido() throws Exception {
        Equipo equipo1 = new Equipo(0, "eq1", "");
        Equipo equipo2 = new Equipo(1, "eq2", "");
        Partido partido = new Partido(1, 1, equipo1, equipo2, 2, 1);

        Map<Integer, Partido> partidos = new LinkedHashMap<>();
        partidos.put(1, partido);

        Ronda ronda = new Ronda(1, "Ronda 1", partidos);

        Assertions.assertNull(ronda.obtenerPartido(2));
    }

    @Test
    public void obtenerPartidoArgumentoInvalido() throws RondaException {
        Equipo equipo1 = new Equipo(0, "eq1", "");
        Equipo equipo2 = new Equipo(1, "eq2", "");
        Partido partido = new Partido(1, 1, equipo1, equipo2, 2, 1);

        Map<Integer, Partido> partidos = new LinkedHashMap<>();
        partidos.put(1, partido);

        Ronda ronda = new Ronda(1, "Ronda 1", partidos);

        Assertions.assertThrows(RondaException.class, () -> ronda.obtenerPartido(0));

    }

}
