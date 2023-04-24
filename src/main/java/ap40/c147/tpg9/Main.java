package ap40.c147.tpg9;

import ap40.c147.datos.EquipoDAO;
import ap40.c147.datos.EquipoDAOCsv;
import ap40.c147.datos.ParticipanteDAO;
import ap40.c147.datos.ParticipanteDAOCsv;
import ap40.c147.datos.PartidoDAO;
import ap40.c147.datos.PartidoDAOCsv;
import ap40.c147.datos.PronosticoDAO;
import ap40.c147.datos.PronosticoDAOCsv;
import ap40.c147.datos.RondaDAO;
import ap40.c147.datos.RondaDAOCsv;
import ap40.c147.db.DbManager;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Participante> participantes = listarParticipantes();

        Map<Integer, Equipo> equipos = listarEquipos();

        listarRondas(equipos);

        listarPronosticos(participantes, equipos);

        listarResultadosDePronosticos(participantes);

        try {
            String archivoDeConfiguracion = args[0];

            List<Configuracion> csvConfiguracion = new CsvToBeanBuilder<Configuracion>(new FileReader(archivoDeConfiguracion))
                    .withType(Configuracion.class)
                    .build()
                    .parse();

            if (csvConfiguracion.size() == 0) {
                throw new RuntimeException("El archivo de configuración no contiene datos.");
            }

            Configuracion configuracion = csvConfiguracion.get(0);

            DbManager dbManager = new DbManager(
                    configuracion.getDatabase(),
                    configuracion.getUsername(),
                    configuracion.getPassword()
            );

            dbManager.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Participante> listarParticipantes() {

        ParticipanteDAO participanteDAO = new ParticipanteDAOCsv();

        Map<Integer, Participante> participantes = participanteDAO.select();

        System.out.println("Listado de participantes: \n");
        participantes.forEach((id, participante) -> {
            System.out.println("Participante nro: " + id);
            System.out.println("-Id: " + id);
            System.out.println("-Nombre: " + participante.getNombre() + "\n");
        });

        return participantes;

    }

    public static Map<Integer, Equipo> listarEquipos() {

        EquipoDAO equipoDAO = new EquipoDAOCsv();

        Map<Integer, Equipo> equipos = equipoDAO.select();

        System.out.println("Listado de equipos: \n");
        equipos.forEach((id, equipo) -> {
            System.out.println("Equipo nro: " + id);
            System.out.println("-Id: " + id);
            System.out.println("-Nombre: " + equipo.getNombre());
            System.out.println("-Descripcion: " + equipo.getDescripcion() + "\n");
        });

        return equipos;
    }

    public static void listarRondas(Map<Integer, Equipo> equipos) {

        PartidoDAO partidoDAO = new PartidoDAOCsv();
        RondaDAO rondaDAO = new RondaDAOCsv();

        Map<Integer, Partido> partidos = partidoDAO.select(equipos);

        Map<Integer, Ronda> rondas = rondaDAO.select(partidos);

        System.out.println("Listado de Rondas: \n");
        rondas.forEach((idRonda, ronda) -> {
            System.out.println("### " + ronda.getNro() + " ###\n");
            System.out.println("partidos: \n");
            ronda.getPartidos().forEach((idPartido, partido) -> {
                System.out.println(" -id: " + idPartido);
                System.out.println(" -" + partido.getEquipo1().getNombre() + " " + partido.getGolesEquipo1() + " - " + partido.getGolesEquipo2() + " " + partido.getEquipo2().getNombre() + "\n");
            });
        });

    }

    public static void listarPronosticos(Map<Integer, Participante> participantes, Map<Integer, Equipo> equipos) {

        PronosticoDAO pronosticoDAO = new PronosticoDAOCsv();

        PartidoDAO partidoDAO = new PartidoDAOCsv();

        Map<Integer, Partido> partidos = partidoDAO.select(equipos);

        Map<Integer, Pronostico> pronosticos = pronosticoDAO.select(participantes, partidos);

        System.out.println("Listado de pronosticos: \n");
        pronosticos.forEach((id, pronostico) -> {
            System.out.println("Pronostico nro: " + id);
            System.out.println("-Participante: " + pronostico.getParticipante().getNombre());
            System.out.println("-Partido: " + pronostico.getPartido().getEquipo1().getNombre() + " vs " + pronostico.getPartido().getEquipo2().getNombre());
            System.out.println("-Aposto por: " + (pronostico.getResultadoPronosticado() == ResultadoEnum.EMPATE ? ResultadoEnum.EMPATE : pronostico.getEquipo().getNombre()));
            System.out.println("-Resultado: " + pronostico.getResultado() + "\n");
            pronostico.asignarPuntosParticipante();
        });

    }

    public static void listarResultadosDePronosticos(Map<Integer, Participante> participantes) {

        System.out.println("Listado de puntos: \n");
        participantes.forEach((id, participante) -> {
            System.out.println(" -El/La participante " + participante.getNombre() + " a consegido un total de " + participante.getPuntos() + " puntos\n");
        });

    }

}
