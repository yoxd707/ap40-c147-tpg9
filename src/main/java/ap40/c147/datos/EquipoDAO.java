package ap40.c147.datos;

import ap40.c147.tpg9.Equipo;
import java.util.Map;

/**
 *
 * @author david
 */
public interface EquipoDAO {

    public Map<Integer, Equipo> select();
    public int insert(Equipo equipo);
    public int update(Equipo equipo);
    public int delete(Equipo equipo);
    
}
