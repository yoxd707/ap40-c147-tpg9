package ap40.c147.datos;

import ap40.c147.tpg9.Participante;
import java.util.Map;

/**
 *
 * @author david
 */
public interface ParticipanteDao {
    public Map<Integer,Participante> select();
}
