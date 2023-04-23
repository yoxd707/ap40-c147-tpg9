package ap40.c147.datos;

import ap40.c147.tpg9.Pronostico;
import java.util.Map;

/**
 *
 * @author david
 */
public interface PronosticoDAO {

    public Map<Integer, Pronostico> select();

    public int insert(Pronostico pronostico);

    public int update(Pronostico pronostico);

    public int delete(Pronostico pronostico);

}
