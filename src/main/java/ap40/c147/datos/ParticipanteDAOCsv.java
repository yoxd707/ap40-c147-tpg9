package ap40.c147.datos;

import ap40.c147.tpg9.Participante;
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
public class ParticipanteDAOCsv implements ParticipanteDAO {

    private static final String RUTA_ARCHIVO_CSV = Paths.get(System.getProperty("user.dir")) + "/src/main/resources/pronosticos.csv";

    @Override
    public Map<Integer, Participante> select() {
        Map<Integer, Participante> participantes = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(RUTA_ARCHIVO_CSV);

            CSVReader csvReader = new CSVReader(fileReader);

            csvReader.skip(1);

            String[] linea;

            while ((linea = csvReader.readNext()) != null) {
                int idParticipante = Integer.parseInt(linea[2]);
                String nombreParticipante = linea[3];
                Participante participante = new Participante(idParticipante, nombreParticipante);
                participantes.put(idParticipante, participante);
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
        return participantes;
    }

}
