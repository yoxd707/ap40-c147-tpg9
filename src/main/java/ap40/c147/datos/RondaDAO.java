package ap40.c147.datos;

import ap40.c147.tpg9.Partido;
import ap40.c147.tpg9.Ronda;
import java.util.Map;

/**
 *
 * @author david
 */
public interface RondaDAO {

    public Map<Integer, Ronda> select(Map<Integer, Partido> partidos);

    public int insert(Ronda ronda);

    public int update(Ronda ronda);

    public int delete(Ronda ronda);

}
