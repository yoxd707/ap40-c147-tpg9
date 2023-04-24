package ap40.c147.datos;

import ap40.c147.tpg9.Participante;
import ap40.c147.tpg9.Partido;
import ap40.c147.tpg9.Pronostico;
import java.util.Map;

/**
 *
 * @author david
 */
public interface PronosticoDAO {

    public Map<Integer, Pronostico> select(Map<Integer, Participante> participantes, Map<Integer, Partido> partidos);

    public int insert(Pronostico pronostico);

    public int update(Pronostico pronostico);

    public int delete(Pronostico pronostico);

}
