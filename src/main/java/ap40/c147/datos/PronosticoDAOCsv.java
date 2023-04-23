package ap40.c147.datos;

import ap40.c147.tpg9.Pronostico;
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
    public Map<Integer, Pronostico> select() {

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
