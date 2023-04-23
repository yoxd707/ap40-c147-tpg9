package ap40.c147.datos;

import ap40.c147.tpg9.Equipo;
import ap40.c147.tpg9.Partido;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import org.apache.commons.collections4.map.LinkedMap;

/**
 *
 * @author david
 */
public class PartidoDAOCsv implements PartidoDAO {

    private static final String RUTA_ARCHIVO_CSV = Paths.get(System.getProperty("user.dir")) + "/src/main/resources/resultados.csv";

    @Override
    public Map<Integer, Partido> select(Map<Integer, Equipo> equipos) {
        Map<Integer, Partido> partidos = new LinkedMap<>();

        FileReader fileReader = null;

        Partido partido = null;

        try {
            fileReader = new FileReader(RUTA_ARCHIVO_CSV);

            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] linea;

            while ((linea = csvReader.readNext()) != null) {
                int idPartido = Integer.parseInt(linea[2]);
                int idRonda = Integer.parseInt(linea[0]);
                Equipo equipo1 = equipos.get(Integer.valueOf(linea[3]));
                Equipo equipo2 = equipos.get(Integer.valueOf(linea[7]));
                int golesEquipo1 = Integer.parseInt(linea[6]);
                int golesEquipo2 = Integer.parseInt(linea[10]);

                partido = new Partido(idPartido, idRonda, equipo1, equipo2, golesEquipo1, golesEquipo2);

                partidos.put(idRonda, partido);
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

        return partidos;
    }

    @Override
    public int insert(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Partido partido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
