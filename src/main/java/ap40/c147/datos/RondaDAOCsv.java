package ap40.c147.datos;

import ap40.c147.exceptions.RondaException;
import ap40.c147.tpg9.Partido;
import ap40.c147.tpg9.Ronda;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.map.LinkedMap;

/**
 *
 * @author david
 */
public class RondaDAOCsv implements RondaDAO {

    private static final String RUTA_ARCHIVO_CSV = Paths.get(System.getProperty("user.dir")) + "/src/main/resources/resultados.csv";

    @Override
    public Map<Integer, Ronda> select(Map<Integer, Partido> partidos) {
        Map<Integer, Ronda> rondas = new LinkedMap<>();

        FileReader fileReader = null;

        Ronda ronda = null;

        try {
            fileReader = new FileReader(RUTA_ARCHIVO_CSV);

            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] linea;

            while ((linea = csvReader.readNext()) != null) {
                int idRonda = Integer.parseInt(linea[0]);
                String nroRonda = "Ronda nro " + idRonda;
                Map<Integer, Partido> partidosRonda = partidos.entrySet().stream()
                        .filter(entry -> entry.getValue().getIdRonda() == idRonda)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                ronda = new Ronda(idRonda, nroRonda, partidosRonda);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException | CsvValidationException | RondaException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return rondas;
    }

    @Override
    public int insert(Ronda ronda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Ronda ronda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Ronda ronda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
