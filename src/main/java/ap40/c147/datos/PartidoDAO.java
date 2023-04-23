package ap40.c147.datos;

import ap40.c147.tpg9.Equipo;
import ap40.c147.tpg9.Partido;
import java.util.Map;

/**
 *
 * @author david
 */
public interface PartidoDAO {

    public Map<Integer, Partido> select(Map<Integer, Equipo> equipos);

    public int insert(Partido partido);

    public int update(Partido partido);

    public int delete(Partido partido);
}
