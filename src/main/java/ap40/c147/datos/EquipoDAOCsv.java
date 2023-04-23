package ap40.c147.datos;

import ap40.c147.tpg9.Equipo;
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
public class EquipoDAOCsv implements EquipoDAO {

    private static final String RUTA_ARCHIVO_CSV = Paths.get(System.getProperty("user.dir")) + "/src/main/resources/resultados.csv";

    @Override
    public Map<Integer, Equipo> select() {

        Map<Integer, Equipo> equipos = new LinkedMap<>();

        FileReader fileReader = null;

        Equipo equipo = null;

        try {
            fileReader = new FileReader(RUTA_ARCHIVO_CSV);

            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] linea;

            while ((linea = csvReader.readNext()) != null) {
                int idEquipo = Integer.parseInt(linea[3]);
                String nombreEquipo = linea[4];
                String descripcionEquipo = linea[5];

                equipo = new Equipo(idEquipo, nombreEquipo, descripcionEquipo);

                equipos.put(idEquipo, equipo);

                idEquipo = Integer.parseInt(linea[7]);
                nombreEquipo = linea[8];
                descripcionEquipo = linea[9];

                equipo = new Equipo(idEquipo, nombreEquipo, descripcionEquipo);

                equipos.put(idEquipo, equipo);
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

        return equipos;

    }

    @Override
    public int insert(Equipo equipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Equipo equipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Equipo equipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
