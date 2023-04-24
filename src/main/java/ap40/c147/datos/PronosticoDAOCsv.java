package ap40.c147.datos;

import ap40.c147.tpg9.Equipo;
import ap40.c147.tpg9.Participante;
import ap40.c147.tpg9.Partido;
import ap40.c147.tpg9.Pronostico;
import ap40.c147.tpg9.ResultadoEnum;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author david
 */
public class PronosticoDAOCsv implements PronosticoDAO {

    private static final String RUTA_ARCHIVO_CSV = Paths.get(System.getProperty("user.dir")) + "/src/main/resources/pronosticos.csv";

    @Override
    public Map<Integer, Pronostico> select(Map<Integer, Participante> participantes, Map<Integer, Partido> partidos) {

        Map<Integer, Pronostico> pronosticos = new LinkedHashMap<>();
        FileReader fileReader = null;
        Pronostico pronostico = null;
        try {
            fileReader = new FileReader(RUTA_ARCHIVO_CSV);

            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] linea;

            while ((linea = csvReader.readNext()) != null) {
                int idPronostico = Integer.parseInt(linea[0]);
                int idRonda = Integer.parseInt(linea[1]);
                Participante participante = participantes.get(Integer.valueOf(linea[2]));
                Partido partido = partidos.get(Integer.valueOf(linea[4]));
                Equipo equipo = linea[5].equalsIgnoreCase("x") ? partido.getEquipo1() : partido.getEquipo2();
                ResultadoEnum resultadoPronosticado = linea[6].equalsIgnoreCase("x") ? ResultadoEnum.EMPATE : ResultadoEnum.GANADOR;

                pronostico = new Pronostico(idPronostico, idRonda, participante, partido, equipo, resultadoPronosticado);

                pronosticos.put(idPronostico, pronostico);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return pronosticos;

    }

    @Override
    public int insert(Pronostico pronostico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Pronostico pronostico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Pronostico pronostico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
