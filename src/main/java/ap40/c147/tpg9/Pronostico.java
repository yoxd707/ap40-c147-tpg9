package ap40.c147.tpg9;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author david
 */
@Setter
@Getter
public class Pronostico {
    
    private int id;
    private int rondaId;
    private Participante participante;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoPronosticado;
    private ResultadoEnum resultado;

    public Pronostico(int id, int rondaId, Participante participante, Partido partido, Equipo equipo, ResultadoEnum resultadoPronosticado, ResultadoEnum resultado) {
        this.id = id;
        this.rondaId = rondaId;
        this.participante = participante;
        this.partido = partido;
        this.equipo = equipo;
        this.resultadoPronosticado = resultadoPronosticado;
        this.resultado = resultado;
    }
    
    
    public void asignarPuntosParticipante(){
        
        // implementar
        
    }
    
    
}
